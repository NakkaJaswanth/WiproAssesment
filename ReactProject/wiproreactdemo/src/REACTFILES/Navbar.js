import React from 'react';
import { NavLink } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
      <div className="container-fluid">
         {/* Brand/logo link that navigates to the home page */}
        <NavLink className="navbar-brand" to="/">Income Tax Portal</NavLink>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
          <span className="navbar-toggler-icon" />
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav">
            {[
              { to: '/', label: 'Home' },
              { to: '/add-taxpayer', label: 'Add Taxpayer' },
              { to: '/taxpayer-list', label: 'Taxpayer List' },
              { to: '/calculate-tax', label: 'Calculate Tax' },
              { to: '/tax-rates', label: 'Tax Rates' },
              { to: '/contact', label: 'Contact' },
              { to: '/about', label: 'About' },
              { to: '/faq', label: 'FAQ' },
            ].map(link => (
              <li className="nav-item" key={link.to}>
                <NavLink
                  to={link.to}
                  className={({ isActive }) => `nav-link${isActive ? ' active' : ''}`}
                >
                  {link.label}
                </NavLink>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
