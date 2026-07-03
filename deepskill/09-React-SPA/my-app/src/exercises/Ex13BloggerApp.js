import React, { useState } from 'react';

function Ex13BloggerApp() {
  const [section, setSection] = useState('book');

  return (
    <div className="exercise-wrap">
      <h1>Blogger App</h1>
      <div style={{ margin: '15px 0' }}>
        <button onClick={() => setSection('book')}>Book Details</button>
        <button onClick={() => setSection('blog')}>Blog Details</button>
        <button onClick={() => setSection('course')}>Course Details</button>
      </div>

      {section === 'book' && (
        <div>
          <h2>Book Details</h2>
          <p>Title: React for Beginners</p>
          <p>Author: John Doe</p>
          <p>Price: $29.99</p>
        </div>
      )}

      {section === 'blog' && (
        <div>
          <h2>Blog Details</h2>
          <p>Title: Learning React Hooks</p>
          <p>Published: Jan 2024</p>
          <p>Content: Hooks let you use state and other React features...</p>
        </div>
      )}

      {section === 'course' && (
        <div>
          <h2>Course Details</h2>
          <p>Course: Full Stack React</p>
          <p>Duration: 12 weeks</p>
          <p>Instructor: Jane Smith</p>
        </div>
      )}
    </div>
  );
}

export default Ex13BloggerApp;
