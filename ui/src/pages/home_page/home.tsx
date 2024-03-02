// react
import React, { ReactElement } from 'react';

// component
import { Toaster } from 'react-hot-toast';

// styles
import './styles.scss';
import { Form } from '../../components/form';
import { Table } from '../../components/table';

const HomePage = (): ReactElement => {
  const columns = ['Sport', 'Point'];
  const data = [
    ['Long_jump', 30],
    ['High Jump', 25],
  ];

  return (
    <>
      <Toaster position="top-right" />
      <div className="body-content">
        <Form />
        <Table columns={columns} data={data}></Table>
      </div>
    </>
  );
};
export default HomePage;
