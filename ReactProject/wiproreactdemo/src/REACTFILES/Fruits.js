import React, { Component } from 'react';

// Functional Component
// This component receives a list of fruits as props

const FruitList = ({ fruits }) => {
  return (
    <ul>
      {fruits.map((fruit, index) => (
        <li key={index}>{fruit}</li>
      ))}
    </ul>
  );
};

// Class Component
//This component manages the fruit list and handles adding new fruits
class Fruits extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fruits: ['Apple', 'Banana'],
      newFruit: ''
    };
  }

  //handler to update `newFruit`
  //Updates state when input value changes

  handleInputChange = (e) => {
    this.setState({ newFruit: e.target.value });
  };

  addFruit = () => {
    const { newFruit, fruits } = this.state; 
    if (newFruit.trim() !== '') {  
    // Trim to remove whitespace, prevent adding empty fruits
      this.setState({
        fruits: [...fruits, newFruit],
        newFruit: ''
      });
    }
  };

  render() {
    return (
      <div>
        <h2>Fruit List</h2>
        {/* controlled component */}
        <input
          type="text"
          value={this.state.newFruit}
          onChange={this.handleInputChange}
          placeholder="Enter fruit name"
        />
        <button onClick={this.addFruit}>Add Fruit</button>
        <FruitList fruits={this.state.fruits} />
      </div>
    );
  }
}

export default Fruits;
