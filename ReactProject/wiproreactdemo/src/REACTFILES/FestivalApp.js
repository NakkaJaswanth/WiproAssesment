import React, { useEffect, useState } from "react";

export default function FestivalApp() {
  const [festival, setFestival] = useState("Diwali");
  const [countdown, setCountdown] = useState(10);
 //useEffect is used to run side effects (like logging, setting intervals, cleanup, etc.).
  //  Festival App Rendered - Every render
  useEffect(() => {
    console.log("Festival App Rendered");
  }); //  No dependency array → runs every render

  //  Welcome Message - Run once
  useEffect(() => {
    alert("Welcome to Diwali Festival App");
  }, []); //  Empty dependency array → run once on mount

  //  Festival Change Tracker
  useEffect(() => {
    console.log(`Festival changed to: ${festival}`);
  }, [festival]); //  Runs only when festival changes

  // Countdown Timer with cleanup
  useEffect(() => {
    const intervalId = setInterval(() => {
      setCountdown((prev) => prev - 1);
    }, 1000);

    // Cleanup function when component unmounts
    return () => {
      clearInterval(intervalId);
      console.log("Timer cleared on unmount");
    };
  }, []); //  Starts only once when component mounts

  //  Multiple Dependencies
  useEffect(() => {
    console.log(`Festival: ${festival} | Countdown: ${countdown}`);
  }, [festival, countdown]); //  Runs whenever either changes

  // UI
  return (
    <div className="container mt-5 text-center">
      <h2>🎉 Festival React App</h2>
      <h4>Current Festival: {festival}</h4>
      <h4>Countdown: {countdown}</h4>

      <select
        className="form-select w-50 mx-auto mt-3"
        value={festival}
        onChange={(e) => setFestival(e.target.value)}
      >
        <option value="Diwali">Diwali</option>
        <option value="Holi">Holi</option>
        <option value="Pongal">Pongal</option>
        <option value="Christmas">Christmas</option>
      </select>
    </div>
  );
}
