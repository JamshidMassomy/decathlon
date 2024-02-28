import { ReactElement } from 'react';
import Header from '../components/header/Header';

export const HomeLayout = ({ children }): ReactElement => {
  return (
    <>
      <Header />
      {children}
    </>
  );
};
