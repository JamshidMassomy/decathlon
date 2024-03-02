// react
import React, { ReactElement, useEffect, useState } from 'react';

// component
import { Toaster } from 'react-hot-toast';

// styles
import './styles.scss';
import { Form } from '../../components/form';

const HomePage = (): ReactElement => {
  return (
    <>
      <Toaster position="top-right" />
      <div className="fc-wrapper">
        <Form />
      </div>
    </>
  );
};
export default HomePage;
