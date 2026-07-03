import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

const trainers = [
  { id: 1, name: 'John', skill: 'React' },
  { id: 2, name: 'Sarah', skill: 'Angular' },
  { id: 3, name: 'Mike', skill: 'Vue' }
];

function HomePage() {
  return <div><h2>Welcome</h2><p>This is the Trainers App homepage.</p></div>;
}

function TrainerList() {
  return (
    <div>
      <h2>Trainers</h2>
      <ul>
        {trainers.map(t => (
          <li key={t.id}>{t.name} - {t.skill}</li>
        ))}
      </ul>
    </div>
  );
}

function Ex06TrainersApp() {
  return (
    <BrowserRouter>
      <div className="exercise-wrap">
        <h1>Trainers App (Router Demo)</h1>
        <nav style={{ margin: '10px 0' }}>
          <Link to="/ex06-home" style={{ marginRight: 10 }}>Home</Link>
          <Link to="/ex06-trainers">Trainers</Link>
        </nav>
        <Routes>
          <Route path="/ex06-home" element={<HomePage />} />
          <Route path="/ex06-trainers" element={<TrainerList />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default Ex06TrainersApp;
