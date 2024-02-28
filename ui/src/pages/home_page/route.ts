import { RouteConfig } from 'react-router-config';
import CalendarPage from './home';

export const homeRoutes = (): RouteConfig[] => [
  {
    path: '/',
    exact: true,
    component: CalendarPage,
  },
];
