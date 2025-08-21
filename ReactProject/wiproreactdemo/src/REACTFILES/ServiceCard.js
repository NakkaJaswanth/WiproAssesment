import React from 'react';

const ServiceCard = ({ serviceName, price, fabricsAvailable }) => {
  return (
    <div className="col-md-4 mb-4">
      <div className="card h-100 shadow">
        <div className="card-body">
          <h5 className="card-title">{serviceName}</h5>
          <p className="card-text">Price: ₹{price}</p>
          <h6>Fabrics Available:</h6>
          <ul className="list-group list-group-flush">
            {fabricsAvailable.map((fabric, index) => (
              <li key={index} className="list-group-item">
                {fabric}
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default ServiceCard;
