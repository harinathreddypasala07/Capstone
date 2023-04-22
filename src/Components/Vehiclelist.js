import React, { useEffect, useState } from "react";
import AdminService from "../Service/Adminservice";
import { Link, useNavigate } from "react-router-dom";

function Vehiclelist() {
  const navigate = useNavigate();
  const [vehicle, setvehicle] = useState([]);

  useEffect(() => {
    AdminService.getVehicle().then((res) => setvehicle(res));
  }, []);

  const create = () => {
    navigate("/addvehicle");
  };
  const deletevehicle = (id) => {
    let ans = window.confirm(`Do you want Delete ${id} `);
    if (ans) {
      AdminService.deleteVehicle(id).then(() => {
        setvehicle(vehicle.filter((item) => item.vehicleID !== id));
      });
    } else {
      return;
    }
  };
  return (
    <div>
      <h1>Vehicles</h1>
      <button onClick={create}>Create</button>
      <table cellPadding="2px" border="1px" align="center">
        <thead>
          <tr>
            <td>VehicleID</td>
            <td>Vehicle-Name</td>
            <td>Vehicle-No</td>
            <td>Vehicle-Capacity</td>
            <td>Vehicle-Fare/Km</td>
            <td>Vehicle-Type</td>
          </tr>
        </thead>
        <tbody>
          {vehicle.map((v) => {
            return (
              <tr key={v.vehicleID}>
                <td>{v.vehicleID}</td>
                <td>{v.name}</td>
                <td>{v.registrationNumber}</td>
                <td>{v.seatingapacity}</td>
                <td>
                  <span>Rs- </span>
                  {v.farePerKM}
                </td>
                <td>{v.type}</td>
                <td>
                  <Link to={`/editvehicle/${v.vehicleID}`}>Edit</Link>
                </td>
                <td>
                  <button onClick={() => deletevehicle(v.vehicleID)}>
                    Delete
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}

export default Vehiclelist;
