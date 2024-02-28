import { mdiBell, mdiBullhorn, mdiCalendarBadge } from '@mdi/js';
import Icon from '@mdi/react';
import React, { memo } from 'react';
import { ASSET_PATH } from '../../util/constants';

const Header = () => {
  return (
    <header className="App-header">
      <nav className="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
        <div className="nav-content d-flex w-100">
          <div className="logo">
            <img src={ASSET_PATH.USER_LOGO}></img>
          </div>
          <div className="nav-user-info">
            <div className="notification-icon">
              <div className="icon-wrapper">
                <Icon path={mdiBell} size={1} />
              </div>
              <div className="icon-wrapper">
                <Icon path={mdiBullhorn} size={1} />
              </div>
              <div className="icon-wrapper">
                <Icon path={mdiBullhorn} size={1} />
              </div>
              <div className="icon-wrapper">
                <Icon path={mdiCalendarBadge} size={1} />
              </div>
            </div>
            <div className="nav-user-info">
              <button
                className="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarTogglerDemo02"
                aria-controls="navbarTogglerDemo02"
                aria-expanded="false"
                aria-label="Toggle navigation"
              >
                <span className="navbar-toggler-icon"></span>
              </button>

              <div
                className="collapse navbar-collapse"
                id="navbarTogglerDemo02"
              ></div>
              <div className="nav-user-info-content m-2">
                <div className="nav-user-info-content-label">
                  <label>Demo User</label>
                </div>

                <img src={ASSET_PATH.USER_LOGO}></img>
              </div>
            </div>
          </div>
        </div>
      </nav>
    </header>
  );
};

export default memo(Header);
