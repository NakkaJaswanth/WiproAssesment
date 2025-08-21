import React from 'react';
import CanteenItem from './CanteenItem';

const CanteenMenu = () => {
  const canteenName = 'JJ Canteen';
  const location = 'Achanta Centre,WestGodavari';
  const openHours = '8:00 AM - 10:00 PM';

  return (
    <div>
      <h2>{canteenName}</h2>
      <p><strong>Location:</strong> {location}</p>
      <p><strong>Open Hours:</strong> {openHours}</p>

      <h3>Menu</h3>


      <CanteenItem name="Pesarattu UPMA" price={30} category="Breakfast" available="Yes" />
      <CanteenItem name="Meals combos(veg & nonveg)" price={70} category="Lunch" available="Yes" />
      <CanteenItem name="punugulu" price={15} category="Snack" available="No" />
      <CanteenItem name="Pakodi" price={50} category="Snack" available="Yes" />
       <CanteenItem name="JJ Spcl Biryani" price={250} category="Dinner" available="Yes" />
    </div>
  );
};

export default CanteenMenu;
