import React, { useState } from "react";
import { Formik, Field, Form, ErrorMessage, FieldArray } from "formik";
import * as Yup from "yup";

// Helper function to calculate age from date of birth
const calculateAge = (dob) => {
  const birthDate = new Date(dob);
  const today = new Date();
  let age = today.getFullYear() - birthDate.getFullYear();
  const monthDiff = today.getMonth() - birthDate.getMonth();

  // Adjust age if birth month/day not reached yet this year
  /*monthDiff < 0
This checks if the current month (today.getMonth()) is before the birth month (birthDate.getMonth()).

If yes, it means the person hasn't had their birthday yet this year, so the age should be one less.

(monthDiff === 0 && today.getDate() < birthDate.getDate())
This checks if we are in the birth month, but the current day of the month is before the birth day.

If yes, the birthday hasn’t occurred yet this month, so age should also be reduced by 1.

age--
If either condition is true, we subtract 1 from the age calculated earlier because the person hasn't had their birthday yet this year.*/
  if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
    age--;
  }
  return age;
};

// Validation schema using Yup
const validationSchema = Yup.object().shape({
  // Player Name: letters and spaces only, min 3, max 40 characters, required
  playerName: Yup.string()
    .matches(/^[A-Za-z ]+$/, "Only letters and spaces allowed")
    .min(3, "Minimum 3 characters")
    .max(40, "Maximum 40 characters")
    .required("Player name is required"),

  // Jersey Number: numeric between 1 and 99, required
  jerseyNumber: Yup.number()
    .min(1, "Minimum jersey number is 1")
    .max(99, "Maximum jersey number is 99")
    .required("Jersey number is required"),

  // Position: one of Forward, Defense, Goalie, required
  position: Yup.string()
    .oneOf(["Forward", "Defense", "Goalie"], "Invalid position")
    .required("Position is required"),

  // Stick Hand: either Left or Right, required
  stickHand: Yup.string()
    .oneOf(["Left", "Right"], "Invalid stick hand")
    .required("Stick hand is required"),

  // Date of Birth: required, age must be between 10 and 55 inclusive
  dateOfBirth: Yup.date()
    .required("Date of birth is required")
    .test("age", "Age must be between 10 and 55", (dob) => {
      if (!dob) return false; // Prevent error on empty dob
      const age = calculateAge(dob);
      return age >= 10 && age <= 55;
    }),

  // Nationality: required
  nationality: Yup.string().required("Nationality is required"),

  // Email: must be valid email and required
  email: Yup.string().email("Invalid email").required("Email is required"),

  // Phone: must match Indian phone number format (starting 6-9 and 10 digits), required
  phone: Yup.string()
    .matches(/^[6-9]\d{9}$/, "Invalid Indian phone number")
    .required("Phone is required"),

  // Player ID: format HOCK-XXXX where X are digits, required
  playerId: Yup.string()
    .matches(/^HOCK-\d{4}$/, "Format: HOCK-XXXX")
    .required("Player ID is required"),

  // Guardian Name: required only if player is under 18
  guardianName: Yup.string().when("dateOfBirth", {
    is: (dob) => dob && calculateAge(dob) < 18,
    then: (schema) => schema.required("Guardian name is required"),
    otherwise: (schema) => schema.notRequired(),
  }),

  // Team Name: required
  teamName: Yup.string().required("Team name is required"),

  // League Level: must be one of Amateur, College, Pro, required
  leagueLevel: Yup.string()
    .oneOf(["Amateur", "College", "Pro"], "Invalid league level")
    .required("League level is required"),

  // Tournament Name: required
  tournamentName: Yup.string().required("Tournament name is required"),

  // Start Date: required
  startDate: Yup.date().required("Start date is required"),

  // End Date: required and cannot be before start date
  endDate: Yup.date()
    .required("End date is required")
    .min(Yup.ref("startDate"), "End date must be on or after start date"),

  // Jersey Size: required only if position is NOT Goalie
  jerseySize: Yup.string().when("position", {
    is: (pos) => pos !== "Goalie",
    then: (schema) => schema.required("Jersey size is required"),
    otherwise: (schema) => schema.notRequired(),
  }),

  // Pad Size: required only if position IS Goalie
  padSize: Yup.string().when("position", {
    is: "Goalie",
    then: (schema) => schema.required("Pad size is required"),
    otherwise: (schema) => schema.notRequired(),
  }),

  // Has medical condition: boolean, no validations here
  hasMedicalCondition: Yup.boolean(),

  // Medical Certificate Number: required and must match format MED-XXXX if hasMedicalCondition is true
  medicalCertNumber: Yup.string().when("hasMedicalCondition", {
    is: true,
    then: (schema) =>
      schema
        .matches(/^MED-\d{4}$/, "Format: MED-XXXX")
        .required("Medical certificate number is required"),
    otherwise: (schema) => schema.notRequired(),
  }),

  // Consent checkbox: must be true to submit
  consent: Yup.boolean()
    .oneOf([true], "You must give consent to submit")
    .required("Consent is required"),

  // Past Teams: array with max 3 entries, each having clubName (2-30 chars) and years (1-20)
  pastTeams: Yup.array()
    .of(
      Yup.object().shape({
        clubName: Yup.string()
          .min(2, "Min 2 characters")
          .max(30, "Max 30 characters")
          .required("Club name is required"),
        years: Yup.number()
          .min(1, "Minimum 1 year")
          .max(20, "Maximum 20 years")
          .required("Years required"),
      })
    )
    .max(3, "Max 3 past teams"),
});

// Initial values for the form fields
const initialValues = {
  playerName: "",
  jerseyNumber: "",
  position: "",
  stickHand: "",
  dateOfBirth: "",
  nationality: "",
  email: "",
  phone: "",
  playerId: "",
  guardianName: "",
  teamName: "",
  leagueLevel: "",
  tournamentName: "",
  startDate: "",
  endDate: "",
  jerseySize: "",
  padSize: "",
  hasMedicalCondition: false,
  medicalCertNumber: "",
  consent: false,
  pastTeams: [],
};

const HockeyTournamentForm = () => {
  // State to hold submitted entries to display below the form
  const [submittedData, setSubmittedData] = useState([]);

  // Function called on form submission
  const handleSubmit = (values, { resetForm }) => {
    console.log("Submitted:", values);
    setSubmittedData((prev) => [...prev, values]); // Add to submitted entries
    resetForm(); // Reset form fields
    alert("Form submitted! Check the table below.");
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4">Hockey Tournament Registration</h2>

      {/* Formik wrapper */}
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
      >
        {({ values, isValid }) => (
          <Form>
            {/* Player Details Section */}
            <h4>Player Details</h4>
            <div className="row">
              {/* Player Name */}
              <div className="col-md-6">
                <label>Player Name</label>
                <Field name="playerName" className="form-control" />
                <ErrorMessage name="playerName" className="text-danger" component="div" />
              </div>

              {/* Jersey Number */}
              <div className="col-md-6">
                <label>Jersey Number</label>
                <Field name="jerseyNumber" type="number" className="form-control" />
                <ErrorMessage name="jerseyNumber" className="text-danger" component="div" />
              </div>

              {/* Position */}
              <div className="col-md-6">
                <label>Position</label>
                <Field as="select" name="position" className="form-select">
                  <option value="">Select</option>
                  <option>Forward</option>
                  <option>Defense</option>
                  <option>Goalie</option>
                </Field>
                <ErrorMessage name="position" className="text-danger" component="div" />
              </div>

              {/* Stick Hand */}
              <div className="col-md-6">
                <label>Stick Hand</label>
                <Field as="select" name="stickHand" className="form-select">
                  <option value="">Select</option>
                  <option>Left</option>
                  <option>Right</option>
                </Field>
                <ErrorMessage name="stickHand" className="text-danger" component="div" />
              </div>

              {/* Date of Birth */}
              <div className="col-md-6">
                <label>Date of Birth</label>
                <Field type="date" name="dateOfBirth" className="form-control" />
                <ErrorMessage name="dateOfBirth" className="text-danger" component="div" />
              </div>

              {/* Nationality */}
              <div className="col-md-6">
                <label>Nationality</label>
                <Field name="nationality" className="form-control" />
                <ErrorMessage name="nationality" className="text-danger" component="div" />
              </div>

              {/* Email */}
              <div className="col-md-6">
                <label>Email</label>
                <Field name="email" type="email" className="form-control" />
                <ErrorMessage name="email" className="text-danger" component="div" />
              </div>

              {/* Phone */}
              <div className="col-md-6">
                <label>Phone</label>
                <Field name="phone" className="form-control" />
                <ErrorMessage name="phone" className="text-danger" component="div" />
              </div>

              {/* Player ID */}
              <div className="col-md-6">
                <label>Player ID</label>
                <Field name="playerId" className="form-control" />
                <ErrorMessage name="playerId" className="text-danger" component="div" />
              </div>

              {/* Guardian Name - Only show if player is under 18 */}
              {calculateAge(values.dateOfBirth) < 18 && (
                <div className="col-md-6">
                  <label>Guardian Name</label>
                  <Field name="guardianName" className="form-control" />
                  <ErrorMessage name="guardianName" className="text-danger" component="div" />
                </div>
              )}
            </div>

            {/* Team & Event Information Section */}
            <h4 className="mt-4">Team & Event Information</h4>
            <div className="row">
              {/* Team Name */}
              <div className="col-md-6">
                <label>Team Name</label>
                <Field name="teamName" className="form-control" />
                <ErrorMessage name="teamName" className="text-danger" component="div" />
              </div>

              {/* League Level */}
              <div className="col-md-6">
                <label>League Level</label>
                <Field as="select" name="leagueLevel" className="form-select">
                  <option value="">Select</option>
                  <option>Amateur</option>
                  <option>College</option>
                  <option>Pro</option>
                </Field>
                <ErrorMessage name="leagueLevel" className="text-danger" component="div" />
              </div>

              {/* Tournament Name */}
              <div className="col-md-6">
                <label>Tournament Name</label>
                <Field name="tournamentName" className="form-control" />
                <ErrorMessage name="tournamentName" className="text-danger" component="div" />
              </div>

              {/* Start Date */}
              <div className="col-md-3">
                <label>Start Date</label>
                <Field type="date" name="startDate" className="form-control" />
                <ErrorMessage name="startDate" className="text-danger" component="div" />
              </div>

              {/* End Date */}
              <div className="col-md-3">
                <label>End Date</label>
                <Field type="date" name="endDate" className="form-control" />
                <ErrorMessage name="endDate" className="text-danger" component="div" />
              </div>

              {/* Jersey Size - Only if position is NOT Goalie */}
              {values.position !== "Goalie" && (
                <div className="col-md-6">
                  <label>Jersey Size</label>
                  <Field name="jerseySize" className="form-control" />
                  <ErrorMessage name="jerseySize" className="text-danger" component="div" />
                </div>
              )}

              {/* Pad Size - Only if position is Goalie */}
              {values.position === "Goalie" && (
                <div className="col-md-6">
                  <label>Pad Size</label>
                  <Field name="padSize" className="form-control" />
                  <ErrorMessage name="padSize" className="text-danger" component="div" />
                </div>
              )}
            </div>

            {/* Medical & Consent Section */}
            <h4 className="mt-4">Medical & Consent</h4>
            <div className="form-check">
              <Field type="checkbox" name="hasMedicalCondition" className="form-check-input" />
              <label className="form-check-label">Has Medical Condition</label>
            </div>

            {/* Medical Certificate Number - show only if hasMedicalCondition checked */}
            {values.hasMedicalCondition && (
              <div className="mb-3">
                <Field name="medicalCertNumber" className="form-control" placeholder="MED-XXXX" />
                <ErrorMessage name="medicalCertNumber" className="text-danger" component="div" />
              </div>
            )}

            {/* Consent Checkbox - must be checked to submit */}
            <div className="form-check mb-3">
              <Field type="checkbox" name="consent" className="form-check-input" />
              <label className="form-check-label">I agree to the terms and consent</label>
              <ErrorMessage name="consent" className="text-danger" component="div" />
            </div>

            {/* Past Teams Section */}
            <h4>Past Teams</h4>
            <FieldArray name="pastTeams">
              {({ push, remove }) => (
                <>
                  {values.pastTeams.map((team, index) => (
                    <div key={index} className="row mb-2">
                      <div className="col-md-6">
                        <Field
                          name={`pastTeams[${index}].clubName`}
                          placeholder="Club Name"
                          className="form-control"
                        />
                        <ErrorMessage
                          name={`pastTeams[${index}].clubName`}
                          className="text-danger"
                          component="div"
                        />
                      </div>
                      <div className="col-md-3">
                        <Field
                          name={`pastTeams[${index}].years`}
                          type="number"
                          placeholder="Years"
                          className="form-control"
                        />
                        <ErrorMessage
                          name={`pastTeams[${index}].years`}
                          className="text-danger"
                          component="div"
                        />
                      </div>
                      <div className="col-md-3">
                        <button type="button" className="btn btn-danger" onClick={() => remove(index)}>
                          Remove
                        </button>
                      </div>
                    </div>
                  ))}

                  {/* Button to add new past team, max 3 */}
                  {values.pastTeams.length < 3 && (
                    <button
                      type="button"
                      className="btn btn-secondary"
                      onClick={() => push({ clubName: "", years: "" })}
                    >
                      Add Past Team
                    </button>
                  )}
                </>
              )}
            </FieldArray>

            {/* Submit Button - disabled if form invalid */}
            <button type="submit" className="btn btn-primary mt-4" disabled={!isValid}>
              Submit
            </button>
          </Form>
        )}
      </Formik>

      {/* Display table of submitted entries */}
      {submittedData.length > 0 && (
        <div className="mt-5">
          <h4>Submitted Entries</h4>
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>Player</th>
                <th>Jersey</th>
                <th>Position</th>
                <th>DOB</th>
                <th>Guardian</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Team</th>
              </tr>
            </thead>
            <tbody>
              {submittedData.map((player, i) => (
                <tr key={i}>
                  <td>{player.playerName}</td>
                  <td>{player.jerseyNumber}</td>
                  <td>{player.position}</td>
                  <td>{player.dateOfBirth}</td>
                  <td>{player.guardianName || "-"}</td>
                  <td>{player.email}</td>
                  <td>{player.phone}</td>
                  <td>{player.teamName}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default HockeyTournamentForm;
