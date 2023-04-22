import React, { useEffect, useState } from "react";
import AdminService from "../Service/Adminservice";
import { useNavigate } from "react-router-dom";

function Addvehicle() {
  const navigate = useNavigate();
  const vehicleID = window.location.pathname.split("/")[2];

  const [data, setdata] = useState({
    name: "",
    registrationNumber: "",
    seatingapacity: "",
    farePerKM: "",
    type: "",
  });
  useEffect(() => {
    if (vehicleID) {
      AdminService.getVehicelById(vehicleID).then((res) => {
        setdata({
          name: res.name,
          registrationNumber: res.registrationNumber,
          seatingapacity: res.seatingapacity,
          farePerKM: res.farePerKM,
          type: res.type,
          vehicleID: res.vehicleID,
        });
      });
    }
  }, [vehicleID]);

  const handlechange = (e) => {
    setdata({ ...data, [e.target.id]: e.target.value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    if (vehicleID) {
      AdminService.putVehicle(data).then((res) => {
        alert("Vehicle is Updated");
        navigate("/vehiclelist");
      });
    } else {
      AdminService.postVehicle(data).then((res) => {
        alert("Vehicle is Added");
        navigate("/vehiclelist");
      });
    }
  };
  console.log(data);
  return (
    <div>
      <h1>{vehicleID ? "EditVehicle" : "AddVehicle"}</h1>
      <form onSubmit={handleSubmit}>
        <label>Vehicle-Name</label>
        <input
          type="text"
          onChange={handlechange}
          id="name"
          required
          value={data.name}
        />
        <br />
        <label>Vehicle-Rg-No</label>
        <input
          type="text"
          onChange={handlechange}
          id="registrationNumber"
          required
          value={data.registrationNumber}
        />
        <br />
        <label>Vehicle-Capacity</label>
        <input
          type="text"
          onChange={handlechange}
          id="seatingapacity"
          required
          value={data.seatingapacity}
        />
        <br />
        <label>Vehicle-Fare/Km</label>
        <input
          type="text"
          onChange={handlechange}
          id="farePerKM"
          required
          value={data.farePerKM}
        />
        <br />
        <label>Vehicle-Type</label>
        <input
          type="text"
          onChange={handlechange}
          id="type"
          required
          value={data.type}
        />
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default Addvehicle;
