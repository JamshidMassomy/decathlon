import { mdiBell, mdiBullhorn, mdiCalendarBadge } from '@mdi/js';
import Icon from '@mdi/react';
import React, { memo } from 'react';

const Header = () => {
  return (
    <header className="App-header">
      <nav className="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
        <div className="nav-content d-flex w-100">
          <div className="logo">
            <h4>Decathlon Calculator UI</h4>
          </div>
        </div>
      </nav>
    </header>
  );
};

export default memo(Header);
