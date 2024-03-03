import React, { memo } from 'react';

const Header = () => {
  return (
    <header className="nav-header">
      <nav className="navbar navbar-light bg-gradient-to-r from-pink-300 via-purple-300 to-indigo-400 shadow-sm">
        <div className="nav-content d-flex w-100">
          <h4>Decathlon Calculator(Men)</h4>
        </div>
      </nav>
    </header>
  );
};

export default memo(Header);
