import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-md navbar-light bg-success mb-4">
      <div className="container-fluid">
        <Link className="navbar-brand mx-auto" to="/" style={{ color: '#fff' }}>Access Key Manager</Link>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarCollapse">
          <ul className="navbar-nav ms-auto mb-2 mb-md-0">
            <li className="nav-item">
              <Link className="nav-link" to="/" style={{ color: '#fff' }}>Login</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/register" style={{ color: '#fff' }}>Register</Link>
            </li>
            <li className="nav-item">
              <span className="nav-link" style={{ cursor: 'pointer', color: '#fff' }}>Logout</span>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
