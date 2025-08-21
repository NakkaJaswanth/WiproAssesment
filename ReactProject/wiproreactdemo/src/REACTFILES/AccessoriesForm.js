import React, { Component } from 'react';

class AccessoriesForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      accessoryName: '',
      description: '',
      category: 'Mobile',
      brand: '',
      inStock: false,
      warranty: '',
      submittedData: null,
    };
  }

  // Handle text, textarea, number, select, radio, checkbox inputs
handleChange = (e) => {
  const { name, value, type, checked } = e.target;
  //if it is checkbox it returns true or false
  //it is not checkbox it uses regular value
  this.setState({ [name]: type === 'checkbox' ? checked : value });
};


  // Handle form submission
  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({
      submittedData: {
        accessoryName: this.state.accessoryName,
        description: this.state.description,
        category: this.state.category,
        brand: this.state.brand,
        inStock: this.state.inStock,
        warranty: this.state.warranty
      },
   
    });
  };

  render() {
    const { accessoryName, description, category, brand, inStock, warranty, submittedData } = this.state;

    return (
      <div className="container mt-5">
        <div className="card shadow p-4">
          <h3 className="mb-4">Accessories Form</h3>
          <form onSubmit={this.handleSubmit}>
            {/* Text Input */}
            <div className="mb-3">
              <label>Accessory Name</label>
              <input
                type="text"
                className="form-control"
                name="accessoryName"
                value={accessoryName}
                onChange={this.handleChange}
              />
            </div>

            {/* Textarea */}
            <div className="mb-3">
              <label>Description</label>
              <textarea
                className="form-control"
                name="description"
                rows="2"
                value={description}
                onChange={this.handleChange}
              />
            </div>

            {/* Select Dropdown */}
            <div className="mb-3">
              <label>Category</label>
              <select
                className="form-select"
                name="category"
                value={category}
                onChange={this.handleChange}
              >
                <option>Mobile</option>
                <option>Laptop</option>
                <option>Audio</option>
                <option>Camera</option>
              </select>
            </div>

            {/* Radio Buttons */}
            <div className="mb-3">
              <label>Brand</label><br />
              <div className="form-check form-check-inline">
                <input
                  className="form-check-input"
                  type="radio"
                  name="brand"
                  value="Sony"
                  checked={brand === 'Sony'}
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Sony</label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  className="form-check-input"
                  type="radio"
                  name="brand"
                  value="Samsung"
                  checked={brand === 'Samsung'}
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Samsung</label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  className="form-check-input"
                  type="radio"
                  name="brand"
                  value="Boat"
                  checked={brand === 'Boat'}
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Boat</label>
              </div>
            </div>

            {/* Checkbox */}
            <div className="mb-3 form-check">
              <input
                type="checkbox"
                className="form-check-input"
                name="inStock"
                checked={inStock}
                onChange={this.handleChange}
              />
              <label className="form-check-label">Available in stock</label>
            </div>

            {/* Number Input */}
            <div className="mb-3">
              <label>Warranty (in years)</label>
              <input
                type="number"
                className="form-control"
                name="warranty"
                value={warranty}
                onChange={this.handleChange}
              />
            </div>

            {/* Submit Button */}
            <button type="submit" className="btn btn-primary">Submit</button>
          </form>

          {/* Display Table */}
          {submittedData && (
            <div className="mt-5">
              <h4>Submitted Accessory Details</h4>
              <table className="table table-bordered mt-3">
                <thead className="table-light">
                  <tr>
                    <th>Accessory Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Brand</th>
                    <th>In Stock</th>
                    <th>Warranty (years)</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>{submittedData.accessoryName}</td>
                    <td>{submittedData.description}</td>
                    <td>{submittedData.category}</td>
                    <td>{submittedData.brand}</td>
                    <td>{submittedData.inStock ? 'Yes' : 'No'}</td>
                    <td>{submittedData.warranty}</td>
                  </tr>
                </tbody>
              </table>
            </div>
          )}
        </div>
      </div>
    );
  }
};

export default AccessoriesForm;
