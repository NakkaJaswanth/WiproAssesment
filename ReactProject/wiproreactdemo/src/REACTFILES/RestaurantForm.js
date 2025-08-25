import React, { useEffect, useState } from "react";

export default function RestaurantForm() {
  //  Form state
  const [formData, setFormData] = useState({
    restaurantName: "",
    ownerName: "",
    email: "",
    contactNumber: "",
    address: "",
    cuisineType: "",
    openingHours: "",
  });

  const [submittedData, setSubmittedData] = useState(null);

  //  Run on every render
  useEffect(() => {
    console.log("Component Rendered");
  });

  // Run only once on mount
  useEffect(() => {
    console.log("Welcome to the Restaurant Registration Form");
  }, []);

  //  Run when form data changes
  useEffect(() => {
    console.log("Form data updated", formData);
  }, [formData]);

  //Auto-save form data every 5 seconds
  useEffect(() => {
    const intervalId = setInterval(() => {
      console.log("Auto-saving form data:", formData);
    }, 5000);

    // Cleanup on unmount
    return () => {
      clearInterval(intervalId);
      console.log("Auto-save stopped");
    };
  }, [formData]);

  //  Handle input changes
  function handleChange(e) {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  }

  // Submit handler
  function handleSubmit(e) {
    e.preventDefault();
    setSubmittedData(formData);
  }

  return (
    <div className="container mt-4">
      <h2>🍽️ Restaurant Registration</h2>
      <form onSubmit={handleSubmit}>
        {[
          { label: "Restaurant Name", name: "restaurantName" },
          { label: "Owner Name", name: "ownerName" },
          { label: "Email", name: "email", type: "email" },
          { label: "Contact Number", name: "contactNumber", type: "tel" },
          { label: "Address", name: "address" },
          { label: "Cuisine Type", name: "cuisineType" },
          { label: "Opening Hours", name: "openingHours" },
        ].map(({ label, name, type = "text" }) => (
          <div className="mb-3" key={name}>
            <label className="form-label">{label}</label>
            <input
              type={type}
              className="form-control"
              name={name}
              value={formData[name]}
              onChange={handleChange}
              required
            />
          </div>
        ))}

        <button className="btn btn-success" type="submit">
          Submit
        </button>
      </form>

      {submittedData && (
        <div className="mt-4">
          <h4>📦 Submitted JSON Output:</h4>
          <pre>{JSON.stringify(submittedData, null, 2)}</pre>
        </div>
      )}
    </div>
  );
}
