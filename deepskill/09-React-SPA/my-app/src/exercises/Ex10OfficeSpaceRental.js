import React from 'react';

const offices = [
  { id: 1, name: 'Cubicle A1', rent: 500 },
  { id: 2, name: 'Cubicle A2', rent: 300 },
  { id: 3, name: 'Cubicle B1', rent: 700 },
  { id: 4, name: 'Cubicle B2', rent: 200 },
  { id: 5, name: 'Cubicle C1', rent: 800 }
];

function Ex10OfficeSpaceRental() {
  return (
    <div className="exercise-wrap">
      <h1>Office Space Rental</h1>
      <ul>
        {offices.map(office => (
          <li
            key={office.id}
            style={{
              padding: '10px',
              margin: '5px 0',
              color: 'white',
              background: office.rent > 500 ? 'red' : 'green',
              borderRadius: '4px'
            }}
          >
            {office.name} - Rs.{office.rent}/month
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Ex10OfficeSpaceRental;
