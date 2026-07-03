import React from 'react';

function ListOfPlayers() {
  const players = [
    { name: 'Virat', runs: 12000 },
    { name: 'Dhoni', runs: 10000 },
    { name: 'Rohit', runs: 9000 },
    { name: 'Sachin', runs: 15000 },
    { name: 'Kohli', runs: 8000 }
  ];

  const highScorers = players.filter(p => p.runs > 9000);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map(p => <li key={p.name}>{p.name} - {p.runs} runs</li>)}
      </ul>
      <h3>Players with runs &gt; 9000</h3>
      <ul>
        {highScorers.map(p => <li key={p.name}>{p.name}</li>)}
      </ul>
    </div>
  );
}

function IndianPlayers() {
  const teamA = ['Virat', 'Rohit'];
  const teamB = ['Dhoni', 'Bumrah'];
  const merged = [...teamA, ...teamB];

  return (
    <div>
      <h2>Indian Players (Destructuring)</h2>
      <p>Team A: {teamA.join(', ')}</p>
      <p>Team B: {teamB.join(', ')}</p>
      <p>Merged: {merged.join(', ')}</p>
    </div>
  );
}

function Ex09CricketApp() {
  return (
    <div className="exercise-wrap">
      <h1>Cricket App</h1>
      <ListOfPlayers />
      <IndianPlayers />
    </div>
  );
}

export default Ex09CricketApp;
