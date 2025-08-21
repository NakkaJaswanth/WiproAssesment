import React from 'react';
import ServiceCard from './ServiceCard';

const TailorShop = () => {
  const services = [
    {
      serviceName: 'Shirt Stitching',
      price: 400,
      fabricsAvailable: ['Cotton', 'Linen', 'Silk']
    },
    {
      serviceName: 'Pant Stitching',
      price: 600,
      fabricsAvailable: ['Denim', 'Linen', 'Wool']
    },
    {
      serviceName: 'Lehenga Stitching',
      price: 1500,
      fabricsAvailable: ['Silk', 'Chiffon', 'Velvet']
    },
    {
      serviceName: 'Blouse Stitching',
      price: 700,
      fabricsAvailable: ['Cotton', 'Georgette', 'Net']
    }
  ];

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Tailoring Services</h2>
      <div className="row">
        {services.map((service, index) => (
          <ServiceCard
            key={index}
            serviceName={service.serviceName}
            price={service.price}
            fabricsAvailable={service.fabricsAvailable}
          />
        ))}
      </div>
    </div>
  );
};

export default TailorShop;
