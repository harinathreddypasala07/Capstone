import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <div>
      <Link to="/">Routes</Link>
      <Link to="/vehiclelist">Vehicles</Link>
      <Link to="/driverlist">Drivers</Link>
      <Link to="/viewreservation">Reservations</Link>
    </div>
  );
}

export default Navbar;
