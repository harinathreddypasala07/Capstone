import React, { useEffect, useState } from "react";
import AdminService from "../Service/Adminservice";
import { useNavigate } from "react-router-dom";

function AddDriver() {
  const navigate = useNavigate();
  const driverID = window.location.pathname.split("/")[2];

  const [driver, setdriver] = useState({});
  const [vehicle, setvehicle] = useState([]);
  const [id, setid] = useState();

  useEffect(() => {
    AdminService.getVehicle().then((res) => setvehicle(res));
  }, []);

  useEffect(() => {
    if (id !== null && id !== undefined) {
      AdminService.getVehicelById(id).then((res) =>
        setdriver({
          ...driver,
          vehicleBean: {
            name: res.name,
            registrationNumber: res.registrationNumber,
            seatingapacity: res.seatingapacity,
            farePerKM: res.farePerKM,
            type: res.type,
            vehicleID: res.vehicleID,
          },
        })
      );
    }
  }, [id, driver]);

  useEffect(() => {
    if (driverID) {
      AdminService.getDriverById(driverID).then((res) =>
        res.vehicleBean
          ? setdriver({
              driverID: res.driverID,
              name: res.name,
              licenseNumber: res.licenseNumber,
              mobileno: res.mobileno,
              location: res.location,
              street: res.street,
              state: res.state,
              vehicleBean: {
                name: res.name,
                registrationNumber: res.vehicleBean.registrationNumber,
                seatingapacity: res.vehicleBean.seatingapacity,
                farePerKM: res.vehicleBean.farePerKM,
                type: res.vehicleBean.type,
                vehicleID: res.vehicleBean.vehicleID,
              },
            })
          : setdriver({
              driverID: res.driverID,
              name: res.name,
              licenseNumber: res.licenseNumber,
              mobileno: res.mobileno,
              location: res.location,
              street: res.street,
              state: res.state,
            })
      );
    }
  }, [driverID]);

  const handleselect = (e) => {
    setid(parseInt(e.target.value));
  };

  const handlechange = (e) => {
    setdriver({ ...driver, [e.target.id]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (driverID) {
      AdminService.putDriver(driver).then((res) => {
        alert("Driver is Updated");
        navigate("/driverlist");
      });
    } else {
      AdminService.postDriver(driver).then((res) => {
        alert("Driver is Added");
        navigate("/driverlist");
      });
    }
  };

  return (
    <div>
      <h1>{driverID ? "EditDriver" : "Add Driver"}</h1>
      <form onSubmit={handleSubmit}>
        <label>Driver-Name</label>
        <input
          type="text"
          id="name"
          onChange={handlechange}
          required
          value={driver.name}
        />
        <br />
        <label>LicenseNumber</label>
        <input
          type="text"
          id="licenseNumber"
          onChange={handlechange}
          required
          value={driver.licenseNumber}
        />
        <br />
        <label>Mobileno</label>
        <input
          type="text"
          id="mobileno"
          onChange={handlechange}
          required
          value={driver.mobileno}
        />
        <br />
        <label>Location</label>
        <input
          type="text"
          id="location"
          onChange={handlechange}
          required
          value={driver.location}
        />
        <br />
        <label>Street</label>
        <input
          type="text"
          id="street"
          onChange={handlechange}
          required
          value={driver.street}
        />
        <br />
        <label>State</label>
        <input
          type="text"
          id="state"
          onChange={handlechange}
          required
          value={driver.state}
        />
        <br />
        <label>Select Vehicle</label>
        <select
          id="vehicleBean"
          onChange={handleselect}
          value={driver.vehicleBean?.vehicleID}
        >
          <option>---Select-Vehicle---</option>
          {vehicle.map((v) => {
            return (
              <option value={v.vehicleID} key={v.vehicleID}>
                {v.name}
                <span> - </span>
                {v.registrationNumber}
              </option>
            );
          })}
        </select>
        <br />

        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default AddDriver;
