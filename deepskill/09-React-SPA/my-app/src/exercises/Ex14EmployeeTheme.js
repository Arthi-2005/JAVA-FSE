import React, { useState, createContext, useContext } from 'react';

const ThemeContext = createContext();

function ThemeProvider({ children }) {
  const [theme, setTheme] = useState('light');
  const toggleTheme = () => setTheme(theme === 'light' ? 'dark' : 'light');
  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      {children}
    </ThemeContext.Provider>
  );
}

function EmployeeCard() {
  const { theme } = useContext(ThemeContext);
  const style = {
    padding: 20,
    margin: '10px 0',
    borderRadius: 8,
    background: theme === 'light' ? '#fff' : '#2d3436',
    color: theme === 'light' ? '#333' : '#dfe6e9',
    border: '1px solid #ddd'
  };

  return (
    <div style={style}>
      <h3>Employee Details</h3>
      <p>Name: Rahul Kumar</p>
      <p>Role: Software Engineer</p>
      <p>Department: IT</p>
    </div>
  );
}

function Ex14EmployeeTheme() {
  return (
    <ThemeProvider>
      <ThemeInner />
    </ThemeProvider>
  );
}

function ThemeInner() {
  const { theme, toggleTheme } = useContext(ThemeContext);
  return (
    <div className="exercise-wrap">
      <h1>Employee Theme</h1>
      <button onClick={toggleTheme}>
        Switch to {theme === 'light' ? 'Dark' : 'Light'} Theme
      </button>
      <EmployeeCard />
    </div>
  );
}

export default Ex14EmployeeTheme;
