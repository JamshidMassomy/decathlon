// react
import React, { useEffect, useState } from 'react';

// components
import { Select } from '../select';
import { Input } from '../input';
import { Button } from '../button';
import toast from 'react-hot-toast';

// redux
import { connect } from 'react-redux';
import { fetchCalculations } from '../../store/action/calculationAction';
import { fetchSportTypes } from '../../store/action/sportActions';

// styles
import './styles.scss';
import { isValidSport } from '../../types/Sport';

const Form = ({ fetchCalculations, fetchSports, sports }) => {
  useEffect(() => {
    fetchSports();
  }, []);

  const [request, setRequest] = useState({
    sport: null,
    result: null,
  });

  const onSubmit = () => {
    if (isFormValid()) {
      fetchCalculations(request);
    } else {
      toast.error(
        'One or more validations is missing. Fill out all required fields'
      );
    }
  };

  const onInputChange = (event) => {
    const { name, value } = event.target;
    setRequest((prevProps) => ({
      ...prevProps,
      [name]: value,
    }));
  };

  const isFormValid = () => {
    return request.sport && request.result && isValidSport(request.sport);
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
          type="number"
          placeholder="result"
          name="result"
          value={request?.result}
          label="Result*"
          onChange={onInputChange}
        />
        <div className="form-btn">
          <Button label="Submit" onClick={() => onSubmit()} type="primary" />
        </div>
      </form>
    </div>
  );
};
const mapStateToProps = (state: { sports: { data: any } }) => ({
  sports: state.sports.data,
});

const mapDispatchToProps = (dispatch) => ({
  fetchCalculations: (request) => dispatch(fetchCalculations(request)),
  fetchSports: () => dispatch(fetchSportTypes()),
});

export default connect(mapStateToProps, mapDispatchToProps)(Form);
