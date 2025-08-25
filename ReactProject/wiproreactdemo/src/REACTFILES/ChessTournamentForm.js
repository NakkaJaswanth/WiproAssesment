import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";



// Chess Tournament Registration Form
 // useState to store submitted data (list of registered players)
 //useState Initializes as an empty array.
const ChessTournamentForm = () => {
  const [submittedData, setSubmittedData] = useState([]);

  const initialValues = {
    playerName: "",
    dob: "",
    gender: "",
    fideId: "",
    rating: "",
    email: "",
    mobile: "",
    country: "",
    category: "",
    parentContact: "",
    paymentConfirmed: false,
    termsAccepted: false,
  };
  //Defines validation rules for each field
  //object that has specific fields with specific validation rules
  const validationSchema = Yup.object({
    playerName: Yup.string()
      .min(3, "Minimum 3 characters")
      .required("Player name is required"),

    dob: Yup.date()
      .required("Date of birth is required")
      .test("age", "Age must be between 5 and 90", function (value) {
        if (!value) return false;
        const birthYear = new Date(value).getFullYear();
        const currentYear = new Date().getFullYear();
        const age = currentYear - birthYear;
        return age >= 5 && age <= 90;
      }),

    gender: Yup.string().required("Gender is required"),
    //Exactly 8 times (not more, not less)
    fideId: Yup.string()
      
      .matches(/^\d{8}$/, "FIDE ID must be exactly 8 digits")
      .required("FIDE ID is required"),
    //rating between 100 1nd 3000
    rating: Yup.number()
      .typeError("Rating must be a number")
      .min(100, "Rating must be at least 100")
      .max(3000, "Rating must be at most 3000")
      .required("Rating is required"),

    email: Yup.string()
      .email("Invalid email format")
      .required("Email is required"),
    //atart number with 6-9 in between number and have 9 numbers
    mobile: Yup.string()
      .matches(/^[6-9]\d{9}$/, "Invalid mobile number")
      .required("Mobile number is required"),

    country: Yup.string().required("Country is required"),

    category: Yup.string()
      .oneOf(["Under 12", "Under 18", "Open"], "Select a valid category")
      .required("Category is required"),

    parentContact: Yup.string().when("category", {
      is: "Under 12",
      then: (schema) =>
        schema
          .matches(/^[6-9]\d{9}$/, "Invalid parent contact number")
          .required("Parent contact is required for Under 12"),
      otherwise: (schema) => schema.notRequired(),
    }),
   //.oneOf([...]) tells Yup: “Only allow values that are in this list.”
   //.oneOf() is great for dropdowns, radio buttons, or fixed-choice questions — where users must pick from predefined options.
    paymentConfirmed: Yup.boolean()
      .oneOf([true], "Payment confirmation is required"),

    termsAccepted: Yup.boolean()
      .oneOf([true], "You must accept the terms and conditions"),
  });
  //to submit form
  const onSubmit = (values, { resetForm }) => {
    console.log("Form submitted:", values);
    setSubmittedData((prev) => [...prev, values]);
    resetForm();
    alert("Form submitted! Check the table below.");
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4">Chess Tournament Registration Form</h2>

      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={onSubmit}
      >
        {({ values }) => (
          <Form>
            {/* Player Name */}
            <div className="mb-3">
              <label className="form-label">Player Name:</label>
              <Field
                type="text"
                name="playerName"
                placeholder="Enter name"
                className="form-control"
              />
              <ErrorMessage name="playerName" component="div" className="text-danger" />
            </div>

            {/* DOB */}
            <div className="mb-3">
              <label className="form-label">Date of Birth:</label>
              <Field type="date" name="dob" className="form-control" />
              <ErrorMessage name="dob" component="div" className="text-danger" />
            </div>

            {/* Gender */}
            <div className="mb-3">
              <label className="form-label">Gender:</label>
              <Field as="select" name="gender" className="form-select">
                <option value="">Select Gender</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
              </Field>
              <ErrorMessage name="gender" component="div" className="text-danger" />
            </div>

            {/* FIDE ID */}
            <div className="mb-3">
              <label className="form-label">FIDE ID:</label>
              <Field name="fideId" className="form-control" />
              <ErrorMessage name="fideId" component="div" className="text-danger" />
            </div>

            {/* Rating */}
            <div className="mb-3">
              <label className="form-label">Rating:</label>
              <Field type="number" name="rating" className="form-control" />
              <ErrorMessage name="rating" component="div" className="text-danger" />
            </div>

            {/* Email */}
            <div className="mb-3">
              <label className="form-label">Email:</label>
              <Field type="email" name="email" className="form-control" />
              <ErrorMessage name="email" component="div" className="text-danger" />
            </div>

            {/* Mobile */}
            <div className="mb-3">
              <label className="form-label">Mobile Number:</label>
              <Field name="mobile" className="form-control" />
              <ErrorMessage name="mobile" component="div" className="text-danger" />
            </div>

            {/* Country */}
            <div className="mb-3">
              <label className="form-label">Country:</label>
              <Field name="country" className="form-control" />
              <ErrorMessage name="country" component="div" className="text-danger" />
            </div>

            {/* Category */}
            <div className="mb-3">
              <label className="form-label">Category:</label>
              <Field as="select" name="category" className="form-select">
                <option value="">Select Category</option>
                <option value="Under 12">Under 12</option>
                <option value="Under 18">Under 18</option>
                <option value="Open">Open</option>
              </Field>
              <ErrorMessage name="category" component="div" className="text-danger" />
            </div>

            {/* Parent Contact (only if Under 12) */}
            {values.category === "Under 12" && (
              <div className="mb-3">
                <label className="form-label">Parent Contact:</label>
                <Field name="parentContact" className="form-control" />
                <ErrorMessage name="parentContact" component="div" className="text-danger" />
              </div>
            )}

            {/* Payment Confirmation */}
            <div className="form-check mb-3">
              <Field type="checkbox" name="paymentConfirmed" className="form-check-input" />
              <label className="form-check-label">Payment Confirmed</label>
              <ErrorMessage name="paymentConfirmed" component="div" className="text-danger" />
            </div>

            {/* Terms & Conditions */}
            <div className="form-check mb-3">
              <Field type="checkbox" name="termsAccepted" className="form-check-input" />
              <label className="form-check-label">Accept Terms & Conditions</label>
              <ErrorMessage name="termsAccepted" component="div" className="text-danger" />
            </div>

            {/* Submit Button */}
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </Form>
        )}
      </Formik>

      {/* Table Display */}
      {submittedData.length > 0 && (
        <div className="mt-5">
          <h4>Registered Players</h4>
          <table className="table table-bordered">
            <thead className="table-dark">
              <tr>
                <th>Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>FIDE ID</th>
                <th>Rating</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Country</th>
                <th>Category</th>
                <th>Parent Contact</th>
              </tr>
            </thead>
            <tbody>
              {submittedData.map((data, index) => (
                <tr key={index}>
                  <td>{data.playerName}</td>
                  <td>{data.dob}</td>
                  <td>{data.gender}</td>
                  <td>{data.fideId}</td>
                  <td>{data.rating}</td>
                  <td>{data.email}</td>
                  <td>{data.mobile}</td>
                  <td>{data.country}</td>
                  <td>{data.category}</td>
                  <td>{data.category === "Under 12" ? data.parentContact : "-"}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default ChessTournamentForm;

