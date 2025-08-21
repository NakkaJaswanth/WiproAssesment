import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import TailorShop from "./REACTFILES/TailorShop";
import MarriageForm from './REACTFILES/MarriageForm';
import AccessoriesForm from './REACTFILES/AccessoriesForm'; 
import BakingForm from "./REACTFILES/BakingForm";
import { FlightBookingControlled, FlightBookingUncontrolled } from "./REACTFILES/FlightBookingForms";
import MovieForm from "./REACTFILES/MovieForm";



const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
    <AccessoriesForm />
    <BakingForm />
    

     <FlightBookingControlled />
      <hr />
      <FlightBookingUncontrolled />
      <MovieForm />

    
    
    

  </React.StrictMode>
  
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
