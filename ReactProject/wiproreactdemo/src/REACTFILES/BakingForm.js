import React, { useState } from "react";

const BakingForm = () => {
  // State for form inputs
  const [formData, setFormData] = useState({
    itemName: "",
    quantity: "",
    ingredients: "",
    bakingTime: "",
    category: "Cake",
  });

  // State for list of baking items
  const [bakingItems, setBakingItems] = useState([]);

  // Handle form input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    // Add new baking item to the list
    setBakingItems((prevItems) => [...prevItems, formData]);

    // Reset form fields
    setFormData({
      itemName: "",
      quantity: "",
      ingredients: "",
      bakingTime: "",
      category: "Cake",
    });
  };

  return (
    <div className="container mt-4">
      <div className="card p-4">
        <h2 className="mb-4">Add Baking Item</h2>
        <form onSubmit={handleSubmit}>
          {/* Item Name */}
          <div className="mb-3">
            <label htmlFor="itemName" className="form-label">
              Item Name
            </label>
            <input
              type="text"
              className="form-control"
              id="itemName"
              name="itemName"
              value={formData.itemName}
              onChange={handleChange}
              required
            />
          </div>

          {/* Quantity */}
          <div className="mb-3">
            <label htmlFor="quantity" className="form-label">
              Quantity
            </label>
            <input
              type="number"
              className="form-control"
              id="quantity"
              name="quantity"
              value={formData.quantity}
              onChange={handleChange}
              required
              min="1"
            />
          </div>

          {/* Ingredients */}
          <div className="mb-3">
            <label htmlFor="ingredients" className="form-label">
              Ingredients
            </label>
            <textarea
              className="form-control"
              id="ingredients"
              name="ingredients"
              value={formData.ingredients}
              onChange={handleChange}
              rows="3"
              required
            ></textarea>
          </div>

          {/* Baking Time */}
          <div className="mb-3">
            <label htmlFor="bakingTime" className="form-label">
              Baking Time (minutes)
            </label>
            <input
              type="number"
              className="form-control"
              id="bakingTime"
              name="bakingTime"
              value={formData.bakingTime}
              onChange={handleChange}
              required
              min="1"
            />
          </div>

          {/* Category */}
          <div className="mb-3">
            <label htmlFor="category" className="form-label">
              Category
            </label>
            <select
              className="form-select"
              id="category"
              name="category"
              value={formData.category}
              onChange={handleChange}
              required
            >
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

          <button type="submit" className="btn btn-primary">
            Add Item
          </button>
        </form>
      </div>

      {/* Display Baking Items */}
      {bakingItems.length > 0 && (
        <div className="card mt-5 p-4">
          <h3>Baking Items</h3>
          <table className="table table-striped mt-3">
            <thead>
              <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Ingredients</th>
                <th>Baking Time (min)</th>
                <th>Category</th>
              </tr>
            </thead>
            <tbody>
              {bakingItems.map((item, index) => (
                <tr key={index}>
                  <td>{item.itemName}</td>
                  <td>{item.quantity}</td>
                  <td>{item.ingredients}</td>
                  <td>{item.bakingTime}</td>
                  <td>{item.category}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default BakingForm;
