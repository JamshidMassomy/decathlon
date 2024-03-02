import React, { useEffect, useState } from 'react';
import { Select } from '../select';
import { Input } from '../input';
import './styles.scss';
import { Button } from '../button';
import { connect } from 'react-redux';
import { fetchCalculations } from '../../store/action/calculationAction';
import { fetchSportTypes } from '../../store/action/sportActions';
import toast from 'react-hot-toast';

const Form = ({ fetchCalculations, fetchSports, sports, point }) => {
  useEffect(() => {
    fetchSports();
  }, []);

  const [request, setRequest] = useState({
    sport: null,
    result: null,
  });

  const onSubmit = async () => {
    await fetchCalculations(request);
    console.log('point', point);
    toast('Here is your toast.' + point);
    setRequest(null);
  };

  const onInputChange = (event) => {
    const { name, value } = event.target;
    setRequest((prevProps) => ({
      ...prevProps,
      [name]: value,
    }));
  };

  return (
    <div className="bg-white p-10 rounded-lg shadow md:w-3/4 mx-auto lg:w-1/2 form-content">
      <form action="" className="form-body">
        <Select onChange={onInputChange} name="sport" dataset={sports} />
        <Input
          name="result"
          value={request?.result}
          label="result"
          onChange={onInputChange}
        />
        <Button label="Submit" onClick={() => onSubmit()} type="primary" />
      </form>
    </div>
  );
};
const mapStateToProps = (state) => ({
  point: state.calculation.point,
  sports: state.sports.data,
});

const mapDispatchToProps = (dispatch) => ({
  fetchCalculations: (request) => dispatch(fetchCalculations(request)),
  fetchSports: () => dispatch(fetchSportTypes()),
});

export default connect(mapStateToProps, mapDispatchToProps)(Form);
