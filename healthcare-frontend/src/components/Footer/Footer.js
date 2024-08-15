import React from "react";
import {Link} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import './Footer.css';

const Footer = () => {
  return(
      <footer className="footer d-flex justify-content-between align-items-center p-3 bg-light">
          <div className="footer-content">
              <div className="row align-items-center upper-footer">
                  <div className="col-md-4 text-center text-md-left mb-4 mb-md-0 logo">
                      <Link to="/">
                          <img src="/assets/logo.png" alt="Healthcare System" className="img-fluid" />
                      </Link>
                  </div>
                  <div className="col-md-4 text-center mb-4 mb-md-0 " >
                      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce vitae velit sit amet dui blandit euismod. Cras hendrerit odio et ipsum tincidunt, ac aliquam lacus commodo. In suscipit odio id iaculis porttitor.</p>
                  </div>
                  <div className="col-md-4 text-center text-md-right">
                      <div className="row-cols-1">
                          <p>Email : lifelinehealthcare@gov.lk</p>
                      </div>
                      <div className="row-cols-1">
                          <p>Address : Lifeline Healthcare, 9 -10, Level -3,<br/>
                              One Galle Face Mall, Colombo -02.</p>
                      </div>
                      <div className="row-cols-1">
                          <p>Tell : 0112 333 944</p>
                      </div>
                  </div>
              </div>
              <hr/>
              <div className="footer-lower bg-light py-2">
                  <div className="container d-flex justify-content-between align-items-center">
                      <ul className="list-inline mb-0">
                          <li className="list-inline-item">
                              <Link className="nav-link" to="/">HOME</Link>
                          </li>
                          <li className="list-inline-item">
                              <Link className="nav-link" to="/contact">CONTACT</Link>
                          </li>
                          <li className="list-inline-item">
                              <Link className="nav-link" to="/appointments">APPOINTMENTS</Link>
                          </li>
                          <li className="list-inline-item">
                              <Link className="nav-link" to="/about">ABOUT US</Link>
                          </li>
                          <li className="list-inline-item">
                              <Link className="nav-link" to="/signup">SIGN UP</Link>
                          </li>
                          <li className="list-inline-item">
                              <Link className="nav-link" to="/login">LOGIN</Link>
                          </li>
                      </ul>
                      <div className="social-icons px-5">
                          <a href="https://www.facebook.com" target="_blank" rel="noopener noreferrer"><img src="/assets/fb.png" alt="Facebook"/></a>
                          <a href="https://www.instagram.com" target="_blank" rel="noopener noreferrer"><img src="/assets/insta.png" alt="Instagram"/></a>
                          <a href="https://www.twitter.com" target="_blank" rel="noopener noreferrer"><img src="/assets/twitter.png" alt="Twitter"/></a>
                          <a href="https://www.linkedin.com" target="_blank" rel="noopener noreferrer"><img src="/assets/linkden.png" alt="Linkden"/></a>
                      </div>
                  </div>
              </div>
          </div>
      </footer>
  );
};
export default Footer;