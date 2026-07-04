import React, { useState } from 'react';

function Ex15TicketRaising() {
  const [name, setName] = useState('');
  const [issue, setIssue] = useState('');
  const [ref, setRef] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    let refNo = 'TKT-' + Date.now();
    setRef(refNo);
  };

  return (
    <div className="exercise-wrap">
      <h1>Complaint Register</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name: </label>
          <input value={name} onChange={e => setName(e.target.value)} required />
        </div>
        <div style={{ marginTop: 10 }}>
          <label>Issue: </label>
          <textarea value={issue} onChange={e => setIssue(e.target.value)} required />
        </div>
        <button type="submit" style={{ marginTop: 10 }}>Submit</button>
      </form>
      {ref && (
        <div style={{ marginTop: 20, padding: 15, background: '#dfe6e9', borderRadius: 8 }}>
          <h3>Ticket Raised!</h3>
          <p>Reference Number: <strong>{ref}</strong></p>
        </div>
      )}
    </div>
  );
}

export default Ex15TicketRaising;
