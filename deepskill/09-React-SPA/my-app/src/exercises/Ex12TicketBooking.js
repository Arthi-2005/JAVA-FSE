import React, { useState } from 'react';

function Ex12TicketBooking() {
  const [loggedIn, setLoggedIn] = useState(false);

  return (
    <div className="exercise-wrap">
      <h1>Ticket Booking</h1>
      <button onClick={() => setLoggedIn(!loggedIn)}>
        {loggedIn ? 'Logout' : 'Login'}
      </button>
      {loggedIn ? (
        <div style={{ marginTop: 20 }}>
          <h2>Book Your Ticket</h2>
          <p>Select movie, date and seats to book tickets.</p>
          <button>Book Now</button>
        </div>
      ) : (
        <p style={{ marginTop: 20, color: '#888' }}>Please login to book tickets.</p>
      )}
    </div>
  );
}

export default Ex12TicketBooking;
