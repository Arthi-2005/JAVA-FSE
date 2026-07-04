import React, { useState } from 'react';
import axios from 'axios';

function Ex19GitClient() {
  const [username, setUsername] = useState('');
  const [userData, setUserData] = useState(null);

  const fetchUser = () => {
    axios.get(`https://api.github.com/users/${username}`)
      .then(res => setUserData(res.data))
      .catch(err => alert('User not found'));
  };

  return (
    <div className="exercise-wrap">
      <h1>Git Client</h1>
      <div>
        <input
          value={username}
          onChange={e => setUsername(e.target.value)}
          placeholder="Enter GitHub username"
        />
        <button onClick={fetchUser} style={{ marginLeft: 10 }}>Search</button>
      </div>
      {userData && (
        <div style={{ marginTop: 20 }}>
          <img src={userData.avatar_url} alt="avatar" width={100} style={{ borderRadius: '50%' }} />
          <h3>{userData.name || userData.login}</h3>
          <p>Public repos: {userData.public_repos}</p>
          <p>Followers: {userData.followers}</p>
          <p>Following: {userData.following}</p>
        </div>
      )}
    </div>
  );
}

export default Ex19GitClient;
