import React, { useState } from "react";

/*
Default view = prompt to select a furniture type.

If Chair is selected → show Chair details + back button.

If Table is selected → show Table details + back button.

If Sofa is selected → show Sofa details + back button.

If Bed is selected → show Bed details + back button.

Back brings user to selection view.
*/

export default function FurnitureAppSwitch() {
  const [selectedFurniture, setSelectedFurniture] = useState("none");

  const furnitureData = {
    Chair: {
      name: "Ergonomic Chair",
      price: 120,
      material: "Leather",
      size: "Medium",
      brand: "ComfortSit"
    },
    Table: {
      name: "Dining Table",
      price: 300,
      material: "Wood",
      size: "Large",
      brand: "WoodCraft"
    },
    Sofa: {
      name: "Luxury Sofa",
      price: 450,
      material: "Fabric",
      size: "XL",
      brand: "RelaxHome"
    },
    Bed: {
      name: "King Size Bed",
      price: 600,
      material: "Metal",
      size: "King",
      brand: "SleepWell"
    }
  };

  function goBack() {
    setSelectedFurniture("none");
  }

  // Switch-case logic for conditional rendering
  function renderFurniture() {
    switch (selectedFurniture) {
      case "Chair":
      case "Table":
      case "Sofa":
      case "Bed":
        const item = furnitureData[selectedFurniture];
        return (
          <div>
            <h3>{selectedFurniture} Details</h3>
            <p><strong>Name:</strong> {item.name}</p>
            <p><strong>Price:</strong> ${item.price}</p>
            <p><strong>Material:</strong> {item.material}</p>
            <p><strong>Size:</strong> {item.size}</p>
            <p><strong>Brand:</strong> {item.brand}</p>
            <button className="btn btn-secondary mt-3" onClick={goBack}>
              Back to Selection
            </button>
          </div>
        );

      default: // selection view
        return (
          <div>
            <h4>Select a Furniture Item</h4>
            <button className="btn btn-outline-dark m-2" onClick={() => setSelectedFurniture("Chair")}>
              View Chair
            </button>
            <button className="btn btn-outline-dark m-2" onClick={() => setSelectedFurniture("Table")}>
              View Table
            </button>
            <button className="btn btn-outline-dark m-2" onClick={() => setSelectedFurniture("Sofa")}>
              View Sofa
            </button>
            <button className="btn btn-outline-dark m-2" onClick={() => setSelectedFurniture("Bed")}>
              View Bed
            </button>
          </div>
        );
    }
  }

  return (
    <div className="container mt-4 text-center">
      <h2>Furniture Showcase</h2>
      <hr />
      {renderFurniture()}
    </div>
  );
}


