// react
import React from 'react';
import ReactDOM from 'react-dom/client';

// components
import { App } from './App';
import reportWebVitals from './reportWebVitals';

// router
import { Provider } from 'react-redux';
import { Router } from 'react-router';
import { createBrowserHistory } from 'history';

// redux
import store from './store';

// Bootstrap
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';

// global styles
import './index.css';

export const history = createBrowserHistory();

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

const render = (): void => {
  if (root) {
    root.render(
      <Provider store={store}>
        <Router history={history}>
          <App />
        </Router>
      </Provider>
    );
  }
};
render();
reportWebVitals();
