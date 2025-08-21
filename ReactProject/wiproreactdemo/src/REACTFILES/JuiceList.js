import React from 'react';
import Juice from './Juice';

const JuiceList = () => {
  const juices = [
    { id: 1, name: 'Mango Juice', price: 40 },
    { id: 2, name: 'Banana Juice', price: 35 },
    { id: 3, name: 'Apple Juice', price: 50 },
    { id: 4, name: 'Pineapple Juice', price: 45 }
  ];

  return (
    <div style={{ textAlign: 'center', marginTop: '40px' }}>
      <h2>Juice Menu</h2>
      <table border="1" cellPadding="10" style={{ margin: '0 auto', borderCollapse: 'collapse' }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Juice Name</th>
            <th>Price (₹)</th>
          </tr>
        </thead>
        <tbody>
          {juices.map((juice) => (
            <Juice key={juice.id} id={juice.id} name={juice.name} price={juice.price} />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default JuiceList;
