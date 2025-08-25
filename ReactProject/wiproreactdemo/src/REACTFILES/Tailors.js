import React, { useEffect, useState } from 'react';
import axios from 'axios';  // Axios for HTTP requests

const Tailors = () => {
  // State to hold the list of tailoring items fetched from the server
  const [items, setItems] = useState([]);
  // State to track loading status (true while fetching data)
  const [loading, setLoading] = useState(true);

  // useEffect with empty dependency array means this runs once when component mounts
  useEffect(() => {
    // Make GET request to fetch tailoring items from backend API
    axios.get("http://localhost:5000/tailoringItems")
      .then((response) => {
        // On success: store the response data (tailoring items) in state
        setItems(response.data);
        // Turn off loading indicator
        setLoading(false);
      })
      .catch((error) => {
        // On failure: log the error for debugging
        console.error("Error fetching tailoring items:", error);
        // Turn off loading indicator even if there's an error
        setLoading(false);
      });
  }, []);  // Empty dependency array ensures this runs once on mount only

  return (
    <div className="container mt-5">
      <h2 className="mb-4">Tailoring Shop Inventory</h2>
      
      {/* Show loading message while data is being fetched */}
      {loading ? (
        <p>Loading...</p>
      ) : (
        // Once loading is false, show the table of items
        <table className="table table-bordered table-striped">
          <thead className="table-dark">
            <tr>
              <th>ID</th>
              <th>Item Name</th>
              <th>Size</th>
              <th>Price (₹)</th>
            </tr>
          </thead>
          <tbody>
            {/* Loop through the items array and render each item as a table row */}
            {items.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>        {/* Display item ID */}
                <td>{item.name}</td>      {/* Display item name */}
                <td>{item.size}</td>      {/* Display item size */}
                <td>{item.price}</td>     {/* Display item price in ₹ */}
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default Tailors;
