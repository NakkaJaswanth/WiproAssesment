import React from 'react';

const TempleList = () => {
  const temples = [
    {
      name: 'Meenakshi Temple',
      location: 'Madurai',
      deities: ['Meenakshi', 'Shiva']
    },
    {
      name: 'Jagannath Temple',
      location: 'Puri',
      deities: ['Jagannath', 'Balabhadra', 'Subhadra']
    },
    {
      name: 'ISKCON Temple',
      location: 'Bangalore',
      deities: ['Krishna', 'Radha']
    }
  ];

  return (
    <div style={{ textAlign: 'center', marginTop: '30px' }}>
      <h2>Famous Temples in India</h2>
      <table border="1" cellPadding="10" style={{ margin: '0 auto', borderCollapse: 'collapse' }}>
        <thead>
          <tr>
            <th>Temple Name</th>
            <th>Location</th>
            <th>Deities</th>
          </tr>
        </thead>
        <tbody>
          {temples.map((temple, index) => (
            <tr key={index}>
              <td>{temple.name}</td>
              <td>{temple.location}</td>
              <td>
                <ul style={{ listStyleType: 'none', padding: 0, margin: 0 }}>
                  {temple.deities.map((deity, i) => (
                    <li key={i}>{deity}</li>
                  ))}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TempleList;
