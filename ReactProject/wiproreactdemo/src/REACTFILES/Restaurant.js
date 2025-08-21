import React, { Component } from 'react';
import MenuItem from './MenuItem';

class Restaurant extends Component {
  render() {
    const restaurantName = 'JJ Bite';
    const location = 'Koderu Road, Achanta';
    const openHours = '10:00 AM - 10:00 PM';

    return (
      <div style={{ padding: '20px' }}>
        <h2>{restaurantName}</h2>
        <p><strong>Location:</strong> {location}</p>
        <p><strong>Open Hours:</strong> {openHours}</p>

        <h3>Menu</h3>

        <MenuItem name="Mutton Dum Biryani" price={150} category="Main Course" available="Yes" />
        <MenuItem name="Kaju Chicken Pakodi" price={90} category="Starter" available="Yes" />
        <MenuItem name="BADAM MILK" price={60} category="Drink" available="No" />
        <MenuItem name="Chocolate Cake" price={120} category="Dessert" available="Yes" />
      </div>
    );
  }
}

export default Restaurant;
