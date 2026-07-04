import React, { useState, useEffect } from 'react';

function Getuser() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    fetch('https://randomuser.me/api/')
      .then(res => res.json())
      .then(data => setUser(data.results[0]))
      .catch(err => console.log(err));
  }, []);

  return (
    <div>
      <h2>Random User</h2>
      {user ? (
        <div>
          <img src={user.picture.large} alt="user" style={{ borderRadius: '50%' }} />
          <p><strong>Name:</strong> {user.name.first} {user.name.last}</p>
          <p><strong>Email:</strong> {user.email}</p>
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
}

function Ex17FetchUser() {
  return (
    <div className="exercise-wrap">
      <h1>Fetch User</h1>
      <Getuser />
    </div>
  );
}

export default Ex17FetchUser;
