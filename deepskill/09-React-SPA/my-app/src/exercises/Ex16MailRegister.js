import React, { useState } from 'react';

function Ex16MailRegister() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState({});

  const validate = () => {
    let errs = {};
    if (name.length < 5) errs.name = 'Name must be at least 5 characters';
    if (!email.includes('@') || !email.includes('.')) errs.email = 'Enter a valid email';
    if (password.length < 8) errs.password = 'Password must be at least 8 characters';
    setErrors(errs);
    return Object.keys(errs).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert('Registration successful!');
      setName('');
      setEmail('');
      setPassword('');
    }
  };

  return (
    <div className="exercise-wrap">
      <h1>Mail Register</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name: </label>
          <input value={name} onChange={e => setName(e.target.value)} />
          {errors.name && <p style={{ color: 'red', fontSize: 12 }}>{errors.name}</p>}
        </div>
        <div style={{ marginTop: 10 }}>
          <label>Email: </label>
          <input value={email} onChange={e => setEmail(e.target.value)} />
          {errors.email && <p style={{ color: 'red', fontSize: 12 }}>{errors.email}</p>}
        </div>
        <div style={{ marginTop: 10 }}>
          <label>Password: </label>
          <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
          {errors.password && <p style={{ color: 'red', fontSize: 12 }}>{errors.password}</p>}
        </div>
        <button type="submit" style={{ marginTop: 10 }}>Register</button>
      </form>
    </div>
  );
}

export default Ex16MailRegister;
