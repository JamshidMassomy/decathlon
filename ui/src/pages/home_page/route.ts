import { RouteConfig } from 'react-router-config';
import HomePage from './home';

export const homeRoutes = (): RouteConfig[] => [
  {
    path: '/',
    exact: true,
    component: HomePage,
  },
];
