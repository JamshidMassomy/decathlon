import React, { ReactElement } from 'react';
import { routes } from './router';
import { BrowserRouter as Router } from 'react-router-dom';
import { renderRoutes } from 'react-router-config';

export const App = (): ReactElement => <Router>{renderRoutes(routes)}</Router>;
