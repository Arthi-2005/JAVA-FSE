import React from 'react';

function UserList({ users, onSelect, selectedId, onDelete, loading }) {
  if (loading) {
    return <div className="loading">Loading users...</div>;
  }

  if (users.length === 0) {
    return <div className="empty">No users found. Add one!</div>;
  }

  return (
    <div>
      <h3 style={{ marginBottom: 15 }}>Users ({users.length})</h3>
      {users.map(user => (
        <div
          key={user.id}
          className={`user-card ${selectedId === user.id ? 'active' : ''}`}
          onClick={() => onSelect(user)}
        >
          <div>
            <div className="name">{user.name}</div>
            <div className="email">{user.email}</div>
          </div>
          <button
            className="btn btn-danger btn-sm"
            onClick={(e) => { e.stopPropagation(); onDelete(user.id); }}
          >
            Delete
          </button>
        </div>
      ))}
    </div>
  );
}

export default UserList;
