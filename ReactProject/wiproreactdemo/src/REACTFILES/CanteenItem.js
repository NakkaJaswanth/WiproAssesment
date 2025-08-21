import React from 'react';

const CanteenItem = ({ name, price, category, available }) => {
  return (
    <div style={{ border: '1px solid gray', margin: '10px', padding: '10px' }}>
      <h4>{name}</h4>
      <p>Price: ₹{price}</p>
      <p>Category: {category}</p>
      <p>Available: {available}</p>
    </div>
  );
};

export default CanteenItem;
