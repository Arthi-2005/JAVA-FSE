import React, { useState } from 'react';

function CountPeople() {
  const [entry, setEntry] = useState(0);
  const [exit, setExit] = useState(0);
  let total = entry - exit;

  return (
    <div>
      <h2>People Counter</h2>
      <p>Entry: {entry}</p>
      <p>Exit: {exit}</p>
      <p><strong>Total inside: {total}</strong></p>
      <button onClick={() => setEntry(entry + 1)}>Entry</button>
      <button onClick={() => setExit(exit + 1)} style={{ marginLeft: 10 }}>Exit</button>
    </div>
  );
}

function Ex08CounterApp() {
  return (
    <div className="exercise-wrap">
      <h1>Counter App</h1>
      <CountPeople />
    </div>
  );
}

export default Ex08CounterApp;
