import React from 'react';

function CalculateScore({ name, school, total, goal }) {
  let average = total / 4;
  let style = { padding: '20px', margin: '10px 0', borderRadius: '8px', background: '#dfe6e9' };

  return (
    <div style={style}>
      <h3>Score Card</h3>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>School:</strong> {school}</p>
      <p><strong>Total:</strong> {total}</p>
      <p><strong>Goal:</strong> {goal}</p>
      <p><strong>Average:</strong> {average}</p>
      <p>{average >= goal ? 'Goal achieved!' : 'Need improvement'}</p>
    </div>
  );
}

function Ex03ScoreCalculator() {
  return (
    <div className="exercise-wrap">
      <h1>Score Calculator</h1>
      <CalculateScore name="John" school="ABC High" total={320} goal={80} />
      <CalculateScore name="Jane" school="XYZ School" total={280} goal={85} />
    </div>
  );
}

export default Ex03ScoreCalculator;
