import React, { useEffect, useRef, useState } from 'react';
import { Select } from '../select';
import { Input } from '../input';
import './styles.scss';
import { Button } from '../button';
import { connect } from 'react-redux';
import { fetchCalculations } from '../../store/action/calculationAction';
import { fetchSportTypes } from '../../store/action/sportActions';
import toast from 'react-hot-toast';

const Form = ({ fetchCalculations, fetchSports, sports, calculation }) => {
  useEffect(() => {
    fetchSports();
  }, []);

  const [request, setRequest] = useState({
    sport: null,
    result: null,
  });

  const onSubmit = () => {
    fetchCalculations(request);
    // a new component like result
    // toast('Calculated Point is ' + calculation?.point);
  };

  const onInputChange = (event) => {
    const { name, value } = event.target;
    setRequest((prevProps) => ({
      ...prevProps,
      [name]: value,
    }));
  };

  return (
    <div className="bg-white p-10 rounded-lg shadow mx-auto form-content">
      <form action="" className="form-body">
        <Select
          value={request.sport}
          onChange={onInputChange}
          name="sport"
          dataset={sports}
        />
        <Input
          name="result"
          value={request?.result}
          label="Result"
          onChange={onInputChange}
        />
        <div className="form-btn">
          <Button label="Submit" onClick={() => onSubmit()} type="primary" />
        </div>
      </form>
    </div>
  );
};
const mapStateToProps = (state) => ({
  calculation: state.calculation.point,
  sports: state.sports.data,
});

const mapDispatchToProps = (dispatch) => ({
  fetchCalculations: (request) => dispatch(fetchCalculations(request)),
  fetchSports: () => dispatch(fetchSportTypes()),
});

export default connect(mapStateToProps, mapDispatchToProps)(Form);
