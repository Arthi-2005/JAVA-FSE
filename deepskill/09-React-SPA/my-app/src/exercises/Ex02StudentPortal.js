import React, { Component } from 'react';

class Home extends Component {
  render() {
    return <div><h2>Home Page</h2><p>Welcome to the Student Portal Home page.</p></div>;
  }
}

class About extends Component {
  render() {
    return <div><h2>About Us</h2><p>This is the Student Portal. We help students learn React.</p></div>;
  }
}

class Contact extends Component {
  render() {
    return <div><h2>Contact</h2><p>Email: student@portal.com</p><p>Phone: 123-456-7890</p></div>;
  }
}

function Ex02StudentPortal() {
  return (
    <div className="exercise-wrap">
      <h1>Student Portal</h1>
      <Home />
      <About />
      <Contact />
    </div>
  );
}

export default Ex02StudentPortal;
