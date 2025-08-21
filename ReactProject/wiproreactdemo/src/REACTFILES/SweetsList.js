import React from 'react';

const SweetsList = () => {
  
  const sweets = [
    { id: 1, name: 'Gulab Jamun', price: 40 },
    { id: 2, name: 'Rasgulla', price: 35 },
    { id: 3, name: 'Kalakanda', price: 60 },
    { id: 4, name: 'Ladoo', price: 25 },
    { id: 5, name: 'jangri', price: 50 }
  ];

  return (
    <div>
      <h2>Sweets List</h2>
      {sweets.map((sweet) => (
        <div key={sweet.id}>
          {sweet.name} - Price: RS{sweet.price}
        </div>
      ))}
    </div>
  );
};

export default SweetsList;
