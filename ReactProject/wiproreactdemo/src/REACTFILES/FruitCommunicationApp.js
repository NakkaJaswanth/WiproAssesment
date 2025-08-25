import React, { useState } from "react";

/*
Lab: Parent / Child / Sibling Communication

1. Parent → Child A: Pass fruit list.
2. Child A → Parent: Select a fruit.
3. Child B → Parent: Add a new fruit ("Orange").
4. Parent → Child C: Pass selected fruit.
*/

export default function FruitCommunicationApp() {
  const [fruits, setFruits] = useState(["Apple", "Mango"]);
  const [selectedFruit, setSelectedFruit] = useState("");

  // Adds "Orange" to the list if not already added
  function handleAddFruit() {
    if (!fruits.includes("Orange")) {
      setFruits([...fruits, "Orange"]);
    }
  }

  // Handles fruit selection from Child A
  function handleSelectFruit(fruit) {
    setSelectedFruit(fruit);
  }

  // Child A: Displays fruit list, allows selecting one
  function renderChildA() {
    return (
      <div className="border p-3 mb-3">
        <h4>Child A  Fruit List</h4>
        <ul className="list-unstyled">
          {fruits.map((fruit, index) => (
            <li key={index}>
              <button
                className="btn btn-sm btn-outline-primary m-1"
                onClick={() => handleSelectFruit(fruit)}
              >
                {fruit}
              </button>
            </li>
          ))}
        </ul>
        <small>(Click a fruit to select)</small>
      </div>
    );
  }

  // Child B: Sends new fruit to Parent
  function renderChildB() {
    return (
      <div className="border p-3 mb-3">
        <h4>Child B Add Fruit</h4>
        <button className="btn btn-success" onClick={handleAddFruit}>
          Send Fruit ("Orange")
        </button>
      </div>
    );
  }

  // Child C: Displays the selected fruit (from Child A via Parent)
  function renderChildC() {
    return (
      <div className="border p-3">
        <h4>Child C Selected Fruit</h4>
        <p>
          {selectedFruit
            ? `You selected: ${selectedFruit}`
            : "No fruit selected yet."}
        </p>
      </div>
    );
  }

  return (
    <div className="container mt-4 text-center">
      <h2>Fruit Communication App</h2>
      <hr />
      {renderChildA()}
      {renderChildB()}
      {renderChildC()}
    </div>
  );
}
