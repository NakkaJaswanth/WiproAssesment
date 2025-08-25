import React, { useState, useEffect } from "react";

//  Loading Component
const LoadingComponent = () => (
  <h3 style={{ color: "blue" }}>Loading product details...</h3>
);

//  Error Component
const ErrorComponent = () => (
  <h3 style={{ color: "red" }}>⚠️ Error fetching product details</h3>
);

//  Product Component
const ProductComponent = ({ product }) => (
  <div style={{ border: "1px solid #ccc", padding: 20, borderRadius: 10 }}>
    <h2>{product.name}</h2>
    <p><strong>Brand:</strong> {product.brand}</p>
    <p><strong>Category:</strong> {product.category}</p>
    <p><strong>Price:</strong> ₹{product.price}</p>

    <p>
      <strong>Type:</strong>{" "}
      {product.price > 50000 ? "Premium Product" : "Budget Product"}
    </p>

    <p>
      <strong>Warranty:</strong>{" "}
      {product.warranty > 0 ? `Warranty: ${product.warranty} years` : "No Warranty"}
    </p>

    <p>
      <strong>Availability:</strong>{" "}
      {product.availability ? "✅ In Stock" : "❌ Out of Stock"}
    </p>

    <p>
      {product.category === "Laptop" ? "🎒 Free Laptop Bag Offer" : ""}
    </p>
  </div>
);

//  Main Component
export default function ElectronicAppSwitch() {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [product, setProduct] = useState(null);

  useEffect(() => {
    // Simulate API call
    setTimeout(() => {
      const isError = false; //  Change to true to test error if  it is true it will return error

      if (isError) {
        setError(true);
        setLoading(false);
      } else {
        setProduct({
          name: "Dell G15",
          brand: "Dell",
          price: 78000,
          category: "Laptop",
          warranty: 2,
          availability: true,
        });
        setLoading(false);
      }
    }, 2000);
  }, []);

  return (
    <div className="container mt-4 text-center">
      <h2>🛒 Electronic Product Store</h2>
      <hr />
      {loading
        ? <LoadingComponent />
        : error
          ? <ErrorComponent />
          : <ProductComponent product={product} />}
    </div>
  );
}
