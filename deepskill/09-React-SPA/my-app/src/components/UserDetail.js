import React from 'react';

function UserDetail({ user }) {
  if (!user) {
    return <div className="empty">Select a user to view details</div>;
  }

  return (
    <div>
      <h3>{user.name}</h3>
      <p><span className="label">Email:</span> {user.email}</p>
      <p><span className="label">Phone:</span> {user.phone}</p>
      <p><span className="label">Website:</span> {user.website}</p>
      <p><span className="label">Company:</span> {user.company?.name}</p>
      <p><span className="label">Address:</span> {user.address?.street}, {user.address?.city}</p>
    </div>
  );
}

export default UserDetail;
