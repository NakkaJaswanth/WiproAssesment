import React, { Component } from 'react';

class MarriageForm extends Component {
  constructor(props) {
    super(props);
    // State holds form input values and submitted data
    this.state = {
      brideName: '',
      groomName: '',
      date: '',
      venue: '',
      submittedData: null,  // will store submitted form values
    };
  }

  // Updates state on each input change (controlled inputs)
  handleChange = (e) => {
    const { name, value } = e.target;  // name matches state key
    this.setState({ [name]: value });
  };

  // On form submit, validate and save the data
  //the page stays the same, and your data gets saved or displayed

  handleSubmit = (e) => {
    e.preventDefault();  //prevent the form from reloading the page when it is submitted.
    const { brideName, groomName, date, venue } = this.state;
    if (brideName && groomName && date && venue) {
      this.setState({
        submittedData: { brideName, groomName, date, venue },
        brideName: '',
        groomName: '',
        date: '',
        venue: '',
      });
    } else {
      alert('Please fill all fields.');
    }
  };

  render() {
    const { brideName, groomName, date, venue, submittedData } = this.state;

    return (
      <div className="container mt-5">
        <div className="card p-4 shadow">
          <h3>Marriage Form</h3>

          <form onSubmit={this.handleSubmit}>
            {/* Bride Name Input */}
            <div className="mb-3 form-group">
              <label htmlFor="brideName" className="form-label">Bride Name</label>
              <input
                type="text"
                className="form-control"
                id="brideName"
                name="brideName"
                value={brideName}
                onChange={this.handleChange}
                placeholder="Enter bride's name"
              />
            </div>

            {/* Groom Name Input */}
            <div className="mb-3 form-group">
              <label htmlFor="groomName" className="form-label">Groom Name</label>
              <input
                type="text"
                className="form-control"
                id="groomName"
                name="groomName"
                value={groomName}
                onChange={this.handleChange}
                placeholder="Enter groom's name"
              />
            </div>

            {/* Date Input */}
            <div className="mb-3 form-group">
              <label htmlFor="date" className="form-label">Date</label>
              <input
                type="date"
                className="form-control"
                id="date"
                name="date"
                value={date}
                onChange={this.handleChange}
              />
            </div>

            {/* Venue Input */}
            <div className="mb-3 form-group">
              <label htmlFor="venue" className="form-label">Venue</label>
              <input
                type="text"
                className="form-control"
                id="venue"
                name="venue"
                value={venue}
                onChange={this.handleChange}
                placeholder="Enter venue"
              />
            </div>

            {/* Submit Button */}
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </form>

          {/* Submitted details   --If submittedData is null or undefined, React will skip rendering this whole block and nothing will appear on the screen.*/}
          {submittedData && (
            <div className="mt-4 p-3 border rounded bg-light">
              <h4>Submitted Marriage Details</h4>
              <p><strong>Bride Name:</strong> {submittedData.brideName}</p>
              <p><strong>Groom Name:</strong> {submittedData.groomName}</p>
              <p><strong>Date:</strong> {submittedData.date}</p>
              <p><strong>Venue:</strong> {submittedData.venue}</p>
            </div>
          )}
        </div>
      </div>
    );
  }
}

export default MarriageForm;
