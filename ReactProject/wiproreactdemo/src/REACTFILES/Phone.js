import React, { useState } from 'react';

const Phone = () => {

  const [phone, setPhone] = useState({
    brand: 'HAUWEI',
    model: 'Hauwei Mate Xt',
    price: 300000
  });

  
  const updatePrice = () => {
    setPhone({
      ...phone,        
      price: 400000     
    });
  };

  return (
    <div>
      <h2>Phone Details</h2>
      <p><strong>Brand:</strong> {phone.brand}</p>
      <p><strong>Model:</strong> {phone.model}</p>
      <p><strong>Price:</strong> RS{phone.price}</p>

      <button onClick={updatePrice}>Update Price</button>
    </div>
  );
};

export default Phone;
