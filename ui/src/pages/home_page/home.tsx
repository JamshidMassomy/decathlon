// react
import React, { ReactElement, useEffect, useState } from 'react';

// component
import { Toaster } from 'react-hot-toast';

// styles
import './styles.scss';
import { connect } from 'react-redux';
import { fetchCalculations } from '../../store/action/calculation_action';

const CalendarPage = ({ fetchCalculations }): ReactElement => {
  useEffect(() => {
    fetchCalculations();
  }, []);

  return (
    <>
      <Toaster position="top-right" />
      <div className="fc-wrapper">
        <h1>Calendar page</h1>
      </div>
    </>
  );
};
const mapStateToProps = (state) => ({
  eventData: state.events,
});

const mapDispatchToProps = (dispatch) => ({
  fetchCalculations: () => dispatch(fetchCalculations()),
});

export default connect(mapStateToProps, mapDispatchToProps)(CalendarPage);
