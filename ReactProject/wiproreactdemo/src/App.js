import logo from './logo.svg';
import './App.css';

import React, { useState } from 'react';


import GroceryList from './REACTFILES/GroceryList';
import Car from './REACTFILES/Car';
import Phone from './REACTFILES/Phone';
import SweetsList from './REACTFILES/SweetsList';
import Phoneupdate from './REACTFILES/Phoneupdate';
import CanteenMenu from './REACTFILES/CanteenMenu';
import JuiceList from './REACTFILES/JuiceList';
import Restaurant from './REACTFILES/Restaurant';
import TempleList from './REACTFILES/TempleList';
import TailorShop from './REACTFILES/TailorShop';
import Fruits from './REACTFILES/Fruits';
import { TelevisionManager } from './REACTFILES/TelevisionComponents';
import MarriageForm from './REACTFILES/MarriageForm';


/*
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}
*/
class Student {
  constructor(name, age) 
  {
    this.n = name;  
    this.a = age;
  }
  display() {
    console.log("The Name of the student is: ", this.n)
    console.log("The Age of the student is: ", this.a)
  }
}






function App() {
  const student1 = new Student("jash", 20);
  student1.display();
  const groceries = ['Rice', 'Wheat', 'Sugar', 'Milk', 'Oil'];

  return (
    <div className="App">
       <h1>Check the console for student info</h1>
      <GroceryList items={groceries} />
       <h1>Welcome to the Car Showroom</h1>
      <Car brand="Toyota" model="Fortuner" color="Black" year="2025"/>
      <h1>Phone Store</h1>
      <Phone />
      <h1>Welcome to Sweet Shop</h1>
      <SweetsList />
       <h1>Phone Store</h1>
      <Phoneupdate />
       <h1>Welcome to Our College Canteen</h1>
      <CanteenMenu />
       <h1>Welcome to the Juice Bar</h1>
      <JuiceList />
      <h1>Welcome to Our Restaurant</h1>
      <Restaurant />
      <h1>Temple Directory</h1>
      <TempleList />
       <h1 className="text-center mt-3">Welcome to Our Tailoring Shop</h1>
      <TailorShop />
      <Fruits />
      <TelevisionManager />
       <MarriageForm />
       
    </div>
  );
}



export default App;
