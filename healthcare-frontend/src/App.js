import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Navbar from './components/NavBar/NavBar';
import Footer from "./components/Footer/Footer";

import SideBar from "./components/SideBar/SideBar";

// import Home from './pages/Home';
// import Contact from './pages/Contact';
// import Appointments from './pages/Appointments';
// import About from './pages/About';
// import Signup from './pages/Signup';
// import Login from './pages/Login';
// import Notifications from './pages/Notifications';

function App() {
  return (
      <Router>
        <div>
          <Navbar />

            <SideBar/>

          <Footer/>
        </div>
      </Router>
  );
}

export default App;
