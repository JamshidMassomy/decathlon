// react
import React, { ReactElement, useEffect, useState } from 'react';

// component
import { Toaster } from 'react-hot-toast';

// styles
import './styles.scss';
import { Form } from '../../components/form';
import { Table } from '../../components/table';
import { connect } from 'react-redux';

const HomePage = ({ calculation }): ReactElement => {
  const columns = ['Point', 'Sport'];
  const [calculationData, setCalculationData] = useState([]);

  const bindCalculationData = () => {
    if (calculation) {
      const foundIndex = calculationData.findIndex(
        (item) => item?.sport === calculation.sport
      );

      if (foundIndex === -1 && calculation?.sport) {
        setCalculationData((prevCalculationData) => [
          ...prevCalculationData,
          calculation,
        ]);
      }

      if (foundIndex !== -1) {
        setCalculationData((prevCalculationData) => {
          const newData = [...prevCalculationData];
          newData[foundIndex] = calculation;
          return newData;
        });
      }
    }
  };

  useEffect(() => {
    bindCalculationData();
  }, [calculation]);

  return (
    <>
      <Toaster position="top-right" />
      <div className="body-content">
        <Form />
        <Table columns={columns} data={calculationData}></Table>
      </div>
    </>
  );
};

const mapStateToProps = (state) => ({
  calculation: state.calculation,
});
export default connect(mapStateToProps)(HomePage);
