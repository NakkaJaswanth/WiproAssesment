import React, { useEffect, useState } from "react";
import axios from "axios"; // HTTP client to communicate with backend (JSON server)
import { Formik, Form, Field, ErrorMessage } from "formik"; // Formik components for form handling
import * as Yup from "yup"; // Yup for schema-based validation

const API_URL = "http://localhost:5001/players"; // API endpoint for CRUD operations on players

const PlayerManager = () => {
  // State to store the list of players fetched from backend
  const [players, setPlayers] = useState([]);

  // State to hold the player being edited (null means adding new player)
  const [editingPlayer, setEditingPlayer] = useState(null);

  // Fetch players from server on component mount (only once)
  //When the component first loads (mounts), it will fetch the list of players from the server exactly one time.
  useEffect(() => {
    axios
      .get(API_URL) // GET request to fetch players
      .then((res) => setPlayers(res.data)) // Save fetched players in state
      .catch((err) => console.error("Error fetching players:", err)); // Log any errors
  }, []); // empty dependency array means this runs only once on mount
  //Without the empty array, the effect would run after every render (which may cause unwanted repeated requests or side effects).
  // Yup validation schema for player form fields
  const playerSchema = Yup.object({
    name: Yup.string().min(3, "Min 3 characters").required("Required"),
    age: Yup.number()
      .required("Required")
      .min(16, "Min age 16")
      .max(40, "Max age 40"),
    position: Yup.string()
      .oneOf(["Forward", "Midfielder", "Defender", "Goalkeeper"], "Invalid position")
      .required("Required"),
    club: Yup.string().required("Required"),
    nationality: Yup.string().required("Required"),
    goals: Yup.number().min(0, "Must be ≥ 0").required("Required"),
    matchesPlayed: Yup.number().min(0, "Must be ≥ 0").required("Required"),
    jerseyNumber: Yup.number().min(1, "1-99").max(99, "1-99").required("Required"),
    email: Yup.string().email("Invalid email").required("Required"),
    contactNumber: Yup.string()
      .matches(/^\d{10}$/, "Must be 10 digits")
      .required("Required"),
  });

  // Handle form submission to either add or update a player
  const handleSubmit = (values, { resetForm }) => {
    if (editingPlayer) {
      // If editingPlayer is set, update existing player via PUT request
      axios
        .put(`${API_URL}/${editingPlayer.id}`, values)
        .then((res) => {
          // Update the players array, replacing the old player with updated data
          setPlayers(players.map((p) => (p.id === editingPlayer.id ? res.data : p)));
          setEditingPlayer(null); // Reset editing state
          resetForm(); // Clear form fields
        })
        .catch((err) => console.error("Error updating player:", err));
    } else {
      // If not editing, add new player via POST request
      axios
        .post(API_URL, values)
        .then((res) => {
          setPlayers([...players, res.data]); // Append new player to players array
          resetForm(); // Clear form fields
        })
        .catch((err) => console.error("Error adding player:", err));
    }
  };

  // Delete a player by id after confirmation
  const handleDelete = (id) => {
    if (window.confirm("Are you sure you want to delete this player?")) {
      axios
        .delete(`${API_URL}/${id}`)
        .then(() => {
          // Remove the deleted player from state
          setPlayers(players.filter((p) => p.id !== id));
        })
        .catch((err) => console.error("Error deleting player:", err));
    }
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-4 text-center">Football Player Management</h2>

      {/* Formik handles the form logic */}
      <Formik
        initialValues={
          editingPlayer || {
            name: "",
            age: "",
            position: "",
            club: "",
            nationality: "",
            goals: "",
            matchesPlayed: "",
            jerseyNumber: "",
            email: "",
            contactNumber: "",
          }
        }
        enableReinitialize
        validationSchema={playerSchema}
        onSubmit={handleSubmit}
      >
        {/* Form UI */}
        <Form className="mb-4">
          <div className="row g-3">
            {/* Each Field is mapped to a form input with validation errors shown */}
            <div className="col-md-4">
              <Field name="name" type="text" placeholder="Name" className="form-control" />
              <ErrorMessage name="name" component="div" className="text-danger" />
            </div>

            <div className="col-md-2">
              <Field name="age" type="number" placeholder="Age" className="form-control" />
              <ErrorMessage name="age" component="div" className="text-danger" />
            </div>

            <div className="col-md-3">
              <Field as="select" name="position" className="form-select">
                <option value="">Select Position</option>
                <option value="Forward">Forward</option>
                <option value="Midfielder">Midfielder</option>
                <option value="Defender">Defender</option>
                <option value="Goalkeeper">Goalkeeper</option>
              </Field>
              <ErrorMessage name="position" component="div" className="text-danger" />
            </div>

            <div className="col-md-3">
              <Field name="club" type="text" placeholder="Club" className="form-control" />
              <ErrorMessage name="club" component="div" className="text-danger" />
            </div>

            <div className="col-md-3">
              <Field name="nationality" type="text" placeholder="Nationality" className="form-control" />
              <ErrorMessage name="nationality" component="div" className="text-danger" />
            </div>

            <div className="col-md-2">
              <Field name="goals" type="number" placeholder="Goals" className="form-control" />
              <ErrorMessage name="goals" component="div" className="text-danger" />
            </div>

            <div className="col-md-2">
              <Field
                name="matchesPlayed"
                type="number"
                placeholder="Matches Played"
                className="form-control"
              />
              <ErrorMessage name="matchesPlayed" component="div" className="text-danger" />
            </div>

            <div className="col-md-2">
              <Field
                name="jerseyNumber"
                type="number"
                placeholder="Jersey Number"
                className="form-control"
              />
              <ErrorMessage name="jerseyNumber" component="div" className="text-danger" />
            </div>

            <div className="col-md-4">
              <Field name="email" type="email" placeholder="Email" className="form-control" />
              <ErrorMessage name="email" component="div" className="text-danger" />
            </div>

            <div className="col-md-4">
              <Field
                name="contactNumber"
                type="text"
                placeholder="Contact Number"
                className="form-control"
              />
              <ErrorMessage name="contactNumber" component="div" className="text-danger" />
            </div>

            {/* Submit Button toggles text based on editing state */}
            <div className="col-md-12">
              <button type="submit" className="btn btn-primary w-100">
                {editingPlayer ? "Update Player" : "Add Player"}
              </button>
            </div>
          </div>
        </Form>
      </Formik>

      {/* Table displaying the list of players */}
      <table className="table table-bordered mt-4">
        <thead className="table-dark">
          <tr>
            {/* Table headers */}
            <th>Name</th>
            <th>Age</th>
            <th>Position</th>
            <th>Club</th>
            <th>Nationality</th>
            <th>Goals</th>
            <th>Matches Played</th>
            <th>Jersey No.</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {/* Show message if no players */}
          {players.length === 0 && (
            <tr>
              <td colSpan="11" className="text-center">
                No players found.
              </td>
            </tr>
          )}

          {/* Map through players and show their data */}
          {players.map((player) => (
            <tr key={player.id}>
              <td>{player.name}</td>
              <td>{player.age}</td>
              <td>{player.position}</td>
              <td>{player.club}</td>
              <td>{player.nationality}</td>
              <td>{player.goals}</td>
              <td>{player.matchesPlayed}</td>
              <td>{player.jerseyNumber}</td>
              <td>{player.email}</td>
              <td>{player.contactNumber}</td>
              <td>
                {/* Edit button sets the player for editing */}
                <button
                  className="btn btn-warning btn-sm me-2"
                  onClick={() => setEditingPlayer(player)}
                >
                  Edit
                </button>

                {/* Delete button triggers player deletion */}
                <button
                  className="btn btn-danger btn-sm"
                  onClick={() => handleDelete(player.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PlayerManager;
