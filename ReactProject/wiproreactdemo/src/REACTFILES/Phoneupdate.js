import React, { useState } from 'react';

const Phone = () => {
  
  const [phone, setPhone] = useState({
    brand: 'Samsung',
    model: 'Galaxy S24',
    price: 5000
  });

  
  const changeBrand = () => {
    setPhone({
      ...phone,
      brand: 'Apple'
    });
  };

  
  const increasePrice = () => {
    setPhone({
      ...phone,
      price: phone.price + 500
    });
  };

  return (
    <div>
      <h2>Phone Details</h2>
      <p><strong>Brand:</strong> {phone.brand}</p>
      <p><strong>Model:</strong> {phone.model}</p>
      <p><strong>Price:</strong> RS{phone.price}</p>

      <button onClick={changeBrand}>Change Brand </button><br /><br />
      <button onClick={increasePrice}>Increase Price </button>
    </div>
  );
};

export default Phone;
