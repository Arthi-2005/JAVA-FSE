import React, { useState, useEffect } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Header from './components/Header';
import UserList from './components/UserList';
import UserForm from './components/UserForm';
import UserDetail from './components/UserDetail';
import Ex01MyFirstReact from './exercises/Ex01MyFirstReact';
import Ex02StudentPortal from './exercises/Ex02StudentPortal';
import Ex03ScoreCalculator from './exercises/Ex03ScoreCalculator';
import Ex04BlogApp from './exercises/Ex04BlogApp';
import Ex05CohortDashboard from './exercises/Ex05CohortDashboard';
import Ex06TrainersApp from './exercises/Ex06TrainersApp';
import Ex07ShoppingApp from './exercises/Ex07ShoppingApp';
import Ex08CounterApp from './exercises/Ex08CounterApp';
import Ex09CricketApp from './exercises/Ex09CricketApp';
import Ex10OfficeSpaceRental from './exercises/Ex10OfficeSpaceRental';
import Ex11EventExamples from './exercises/Ex11EventExamples';
import Ex12TicketBooking from './exercises/Ex12TicketBooking';
import Ex13BloggerApp from './exercises/Ex13BloggerApp';
import Ex14EmployeeTheme from './exercises/Ex14EmployeeTheme';
import Ex15TicketRaising from './exercises/Ex15TicketRaising';
import Ex16MailRegister from './exercises/Ex16MailRegister';
import Ex17FetchUser from './exercises/Ex17FetchUser';
import Ex18UnitTesting from './exercises/Ex18UnitTesting';
import Ex19GitClient from './exercises/Ex19GitClient';
import './App.css';

function Home() {
  const [users, setUsers] = useState([]);
  const [selectedUser, setSelectedUser] = useState(null);
  const [showForm, setShowForm] = useState(false);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    setLoading(true);
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/users');
      const data = await response.json();
      setUsers(data);
    } catch (error) {
      console.error('Error fetching users:', error);
    } finally {
      setLoading(false);
    }
  };

  const addUser = (user) => {
    const newUser = { ...user, id: users.length + 1 };
    setUsers([...users, newUser]);
    setShowForm(false);
  };

  const deleteUser = (id) => {
    setUsers(users.filter(user => user.id !== id));
    if (selectedUser && selectedUser.id === id) {
      setSelectedUser(null);
    }
  };

  return (
    <div>
      <Header title="React SPA - User Management" />
      <main className="container">
        <div className="actions">
          <button className="btn btn-primary" onClick={() => setShowForm(!showForm)}>
            {showForm ? 'Cancel' : 'Add User'}
          </button>
          <button className="btn btn-secondary" onClick={fetchUsers}>
            Refresh
          </button>
        </div>

        {showForm && <UserForm onSubmit={addUser} />}

        <div className="content">
          <div className="sidebar">
            <UserList
              users={users}
              onSelect={setSelectedUser}
              selectedId={selectedUser?.id}
              onDelete={deleteUser}
              loading={loading}
            />
          </div>
          <div className="detail">
            <UserDetail user={selectedUser} />
          </div>
        </div>
      </main>
    </div>
  );
}

function App() {
  return (
    <BrowserRouter>
      <div>
        <nav className="nav-bar">
          <div className="nav-inner">
            <Link to="/" className="nav-brand">React SPA</Link>
            <div className="nav-links">
              <Link to="/">Home</Link>
              <Link to="/ex01">Ex01</Link>
              <Link to="/ex02">Ex02</Link>
              <Link to="/ex03">Ex03</Link>
              <Link to="/ex04">Ex04</Link>
              <Link to="/ex05">Ex05</Link>
              <Link to="/ex06">Ex06</Link>
              <Link to="/ex07">Ex07</Link>
              <Link to="/ex08">Ex08</Link>
              <Link to="/ex09">Ex09</Link>
              <Link to="/ex10">Ex10</Link>
              <Link to="/ex11">Ex11</Link>
              <Link to="/ex12">Ex12</Link>
              <Link to="/ex13">Ex13</Link>
              <Link to="/ex14">Ex14</Link>
              <Link to="/ex15">Ex15</Link>
              <Link to="/ex16">Ex16</Link>
              <Link to="/ex17">Ex17</Link>
              <Link to="/ex18">Ex18</Link>
              <Link to="/ex19">Ex19</Link>
            </div>
          </div>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/ex01" element={<Ex01MyFirstReact />} />
          <Route path="/ex02" element={<Ex02StudentPortal />} />
          <Route path="/ex03" element={<Ex03ScoreCalculator />} />
          <Route path="/ex04" element={<Ex04BlogApp />} />
          <Route path="/ex05" element={<Ex05CohortDashboard />} />
          <Route path="/ex06" element={<Ex06TrainersApp />} />
          <Route path="/ex07" element={<Ex07ShoppingApp />} />
          <Route path="/ex08" element={<Ex08CounterApp />} />
          <Route path="/ex09" element={<Ex09CricketApp />} />
          <Route path="/ex10" element={<Ex10OfficeSpaceRental />} />
          <Route path="/ex11" element={<Ex11EventExamples />} />
          <Route path="/ex12" element={<Ex12TicketBooking />} />
          <Route path="/ex13" element={<Ex13BloggerApp />} />
          <Route path="/ex14" element={<Ex14EmployeeTheme />} />
          <Route path="/ex15" element={<Ex15TicketRaising />} />
          <Route path="/ex16" element={<Ex16MailRegister />} />
          <Route path="/ex17" element={<Ex17FetchUser />} />
          <Route path="/ex18" element={<Ex18UnitTesting />} />
          <Route path="/ex19" element={<Ex19GitClient />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
