import React, { Component } from 'react';

class MenuItem extends Component {
  render() {
    const { name, price, category, available } = this.props;
    return (
      <div style={{ border: '1px solid #ccc', padding: '10px', margin: '10px 0' }}>
        <h4>{name}</h4>
        <p>Price: RS{price}</p>
        <p>Category: {category}</p>
        <p>Available: {available}</p>
      </div>
    );
  }
}

export default MenuItem;
