import React, { useState, useEffect } from 'react';

function Posts() {
  const [posts, setPosts] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(res => res.json())
      .then(data => setPosts(data.slice(0, 10)))
      .catch(err => setError(err.message));
  }, []);

  if (error) {
    return <div style={{ color: 'red' }}>Error: {error}</div>;
  }

  return (
    <div>
      <h2>Blog Posts</h2>
      {posts.map(post => (
        <div key={post.id} style={{ borderBottom: '1px solid #eee', padding: '10px 0' }}>
          <h4>{post.title}</h4>
          <p>{post.body}</p>
        </div>
      ))}
    </div>
  );
}

function Ex04BlogApp() {
  return (
    <div className="exercise-wrap">
      <h1>Blog App</h1>
      <Posts />
    </div>
  );
}

export default Ex04BlogApp;
