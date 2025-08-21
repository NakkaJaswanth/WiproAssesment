import React, { Component, createRef } from "react";
//controlled component value is controlled by React state.
export class FlightBookingControlled extends Component {
  state = {
    passengerName: "",
    email: "",
    gender: "",
    mealPreference: "Veg",
    specialRequest: "",
    submittedData: null,
  };

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  handleGenderChange = (e) => {
    this.setState({ gender: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const { passengerName, email, gender, mealPreference, specialRequest } = this.state;
    this.setState({ submittedData: { passengerName, email, gender, mealPreference, specialRequest } });
  };

  render() {
    const { passengerName, email, gender, mealPreference, specialRequest, submittedData } = this.state;
    return (
      <div className="mb-5">
        <h3>Controlled Flight Booking Form</h3>
        <form onSubmit={this.handleSubmit}>
          <div className="mb-3">
            <label className="form-label">Passenger Name</label>
            <input
              type="text"
              name="passengerName"
              className="form-control"
              value={passengerName}
              onChange={this.handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Email</label>
            <input
              type="email"
              name="email"
              className="form-control"
              value={email}
              onChange={this.handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label me-3">Gender</label>
            <div className="form-check form-check-inline">
              <input
                type="radio"
                id="male"
                name="gender"
                value="Male"
                checked={gender === "Male"}
                onChange={this.handleGenderChange}
                className="form-check-input"
                required
              />
              <label htmlFor="male" className="form-check-label">
                Male
              </label>
            </div>

            <div className="form-check form-check-inline">
              <input
                type="radio"
                id="female"
                name="gender"
                value="Female"
                checked={gender === "Female"}
                onChange={this.handleGenderChange}
                className="form-check-input"
              />
              <label htmlFor="female" className="form-check-label">
                Female
              </label>
            </div>
          </div>

          <div className="mb-3">
            <label className="form-label">Meal Preference</label>
            <select
              name="mealPreference"
              className="form-select"
              value={mealPreference}
              onChange={this.handleChange}
            >
              <option value="Veg">Veg</option>
              <option value="Non-Veg">Non-Veg</option>
            </select>
          </div>

          <div className="mb-3">
            <label className="form-label">Special Request</label>
            <textarea
              name="specialRequest"
              className="form-control"
              value={specialRequest}
              onChange={this.handleChange}
              rows="3"
            />
          </div>

          <button type="submit" className="btn btn-primary">
            Submit Controlled Form
          </button>
        </form>

        {submittedData && (
          <div className="mt-4">
            <h5>Submitted Details</h5>
            <table className="table table-bordered">
              <tbody>
                <tr>
                  <th>Passenger Name</th>
                  <td>{submittedData.passengerName}</td>
                </tr>
                <tr>
                  <th>Email</th>
                  <td>{submittedData.email}</td>
                </tr>
                <tr>
                  <th>Gender</th>
                  <td>{submittedData.gender}</td>
                </tr>
                <tr>
                  <th>Meal Preference</th>
                  <td>{submittedData.mealPreference}</td>
                </tr>
                <tr>
                  <th>Special Request</th>
                  <td>{submittedData.specialRequest || "None"}</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}
//Uncontrolled components use refs instead of state
export class FlightBookingUncontrolled extends Component {
  flightNumberRef = createRef();
  sourceRef = createRef();
  destinationRef = createRef();
  travelDateRef = createRef();
  termsRef = createRef();

  state = {
    submittedData: null,
  };
  // Submit handler  fetch values using refs
  handleSubmit = (e) => {
    e.preventDefault();

    const flightNumber = this.flightNumberRef.current.value;
    const source = this.sourceRef.current.value;
    const destination = this.destinationRef.current.value;
    const travelDate = this.travelDateRef.current.value;
    const termsAccepted = this.termsRef.current.checked;

    this.setState({
      submittedData: { flightNumber, source, destination, travelDate, termsAccepted },
    });
  };

  render() {
    const { submittedData } = this.state;
    return (
      <div>
        <h3>Uncontrolled Flight Booking Form</h3>
        <form onSubmit={this.handleSubmit}>
          <div className="mb-3">
            <label className="form-label">Flight Number</label>
            <input type="text" ref={this.flightNumberRef} className="form-control" required />
          </div>

          <div className="mb-3">
            <label className="form-label">Source</label>
            <input type="text" ref={this.sourceRef} className="form-control" required />
          </div>

          <div className="mb-3">
            <label className="form-label">Destination</label>
            <input type="text" ref={this.destinationRef} className="form-control" required />
          </div>

          <div className="mb-3">
            <label className="form-label">Travel Date</label>
            <input type="date" ref={this.travelDateRef} className="form-control" required />
          </div>

          <div className="mb-3 form-check">
            <input type="checkbox" ref={this.termsRef} className="form-check-input" id="terms" required />
            <label htmlFor="terms" className="form-check-label">
              Accept Terms and Conditions
            </label>
          </div>

          <button type="submit" className="btn btn-success">
            Submit Uncontrolled Form
          </button>
        </form>

        {submittedData && (
          <div className="card mt-4">
            <div className="card-body">
              <h5 className="card-title">Submitted Flight Details</h5>
              <p>
                <strong>Flight Number:</strong> {submittedData.flightNumber}
              </p>
              <p>
                <strong>Source:</strong> {submittedData.source}
              </p>
              <p>
                <strong>Destination:</strong> {submittedData.destination}
              </p>
              <p>
                <strong>Travel Date:</strong> {submittedData.travelDate}
              </p>
              <p>
                <strong>Terms Accepted:</strong> {submittedData.termsAccepted ? "Yes" : "No"}
              </p>
            </div>
          </div>
        )}
      </div>
    );
  }
}
