import React from 'react';

function Header({ title }) {
  return (
    <header style={{ background: '#4361ee', color: 'white', padding: '20px 0' }}>
      <div className="container">
        <h1>{title}</h1>
        <p style={{ marginTop: 5, opacity: 0.9 }}>Single Page Application with React</p>
      </div>
    </header>
  );
}

export default Header;
