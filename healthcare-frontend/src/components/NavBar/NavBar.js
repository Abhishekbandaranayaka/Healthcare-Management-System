import React from "react";
import {Link} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import './NavBar.css';

const NavBar = () => {
    return(
        <header>
            {/* Upper line: Logo, Search field, Social media icons */}
            <div className="upper-navbar d-flex justify-content-between align-items-center p-2 bg-light">
                <div className="logo">
                    <Link to="/">
                        <img src="/assets/logo.png" alt="Healthcare System"/>
                    </Link>
                </div>
                <div className="search-bar " >
                    <input type="text" placeholder="     Search..." className="form-control rounded-pill" />
                </div>
                <div className="social-icons px-5">
                    <a href="https://www.facebook.com" target="_blank" rel="noopener noreferrer"><img src="/assets/fb.png" alt="Facebook"/></a>
                    <a href="https://www.instagram.com" target="_blank" rel="noopener noreferrer"><img src="/assets/insta.png" alt="Instagram"/></a>
                    <a href="https://www.twitter.com" target="_blank" rel="noopener noreferrer"><img src="/assets/twitter.png" alt="Twitter"/></a>
                    <a href="https://www.linkedin.com" target="_blank" rel="noopener noreferrer"><img src="/assets/linkden.png" alt="Linkden"/></a>
                </div>
            </div>

            {/* Lower line: Navigation links */}
            <nav className="navbar navbar-expand-lg d-flex justify-content-between align-items-center bg-light navbar-lower">
                <div className="container-fluid">
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <Link className="nav-link" to="/">HOME</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/contact">CONTACT</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/appointments">APPOINTMENTS</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/about">ABOUT US</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/signup">SIGN UP</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/login">LOGIN</Link>
                            </li>
                        </ul>
                        <div className="notification-icon">
                            <Link to="/notifications">
                                <img src="/assets/notification.png" alt="Healthcare System"/>
                            </Link>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
    )
};

export default NavBar;