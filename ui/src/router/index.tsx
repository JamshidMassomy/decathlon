import React, { ReactElement } from 'react';
import {
  renderRoutes,
  RouteConfig,
  RouteConfigComponentProps,
} from 'react-router-config';

import { homeRoutes } from '../pages/home_page';
import { HomeLayout } from '../_layout/home_layout';

const Root = ({ route }: RouteConfigComponentProps): ReactElement => (
  <HomeLayout>{renderRoutes(route?.routes)}</HomeLayout>
);

export const routes: RouteConfig[] = [
  {
    component: Root,
    routes: [...homeRoutes()],
  },
];
