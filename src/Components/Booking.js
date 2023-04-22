import React, { useEffect, useState } from "react";
import CustomerService from "../Service/Customerservice";
import AdminService from "../Service/Adminservice";
import { useNavigate } from "react-router-dom";

function Booking() {
  const navigate = useNavigate();
  const [route, setroute] = useState([]);
  const [driver, setdriver] = useState([]);
  const [routeid, setrouteid] = useState();
  const [driverid, setdriverid] = useState();
  const [customerset, setcustomerset] = useState({});
  const [routeidset, setrouteidset] = useState({});
  const [driveridset, setdriveridset] = useState({
    driverID: 0,
    name: "",
    licenseNumber: "",
    mobileno: "",
    location: "",
    street: "",
    state: "",
    vehicleBean: {
      name: "",
      registrationNumber: "",
      seatingapacity: 0,
      farePerKM: "",
      type: "",
      vehicleID: 0,
    },
  });
  const customerid = window.location.pathname.split("/")[2];
  useEffect(() => {
    if (customerid) {
      AdminService.getusrById(customerid).then((res) => {
        setcustomerset({
          userId: res.userId,
          password: res.password,
          userType: res.userType,
          loginStatus: res.loginStatus,
        });
      });
    }
  }, [customerid]);

  const [reserv, setreserv] = useState({
    journeyDate: "",
    bookingDate: "",
    bookingStatus: "",
    totalFare: "",
    boardingPoint: "",
    dropPoint: "",
    routeBean: {
      source: "",
      destination: "",
      distance: "",
      travelDuration: "",
      routeID: 0,
    },
    driverBean: {
      driverID: 0,
      name: "",
      licenseNumber: "",
      mobileno: "",
      location: "",
      street: "",
      state: "",
      vehicleBean: {
        name: "",
        registrationNumbe: "",
        seatingapacit: "",
        farePerKM: "",
        type: "",
        vehicleID: 0,
      },
    },
  });

  useEffect(() => {
    CustomerService.getRoute().then((res) => setroute(res));
  }, []);
  // console.log(route);
  useEffect(() => {
    CustomerService.getDriver().then((res) => setdriver(res));
  }, []);
  // console.log(driver);
  useEffect(() => {
    if (routeid)
      CustomerService.getRouteById(routeid).then((res) =>
        setrouteidset({
          source: res.source,
          destination: res.destination,
          distance: res.distance,
          travelDuration: res.travelDuration,
          routeID: res.routeID,
        })
      );
  }, [routeid]);
  // console.log(routeidset);

  useEffect(() => {
    if (driverid)
      CustomerService.getDriverById(driverid).then((res) =>
        setdriveridset({
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
      );
  }, [driverid]);
  // console.log(driveridset);
  const handleselect = (e) => {
    setrouteid(e.target.value);
  };
  const handleselect1 = (e) => {
    setdriverid(e.target.value);
  };
  const handlechange = (e) => {
    setreserv({
      ...reserv,
      [e.target.id]: e.target.value,
      bookingDate: Date().slice(0, 10),
      bookingStatus: "true",
      totalFare:
        parseInt(driveridset.vehicleBean.farePerKM) *
        parseInt(routeidset.distance),
      boardingPoint: routeidset.source,
      dropPoint: routeidset.destination,
      routeBean: {
        source: routeidset.source,
        destination: routeidset.destination,
        distance: routeidset.distance,
        travelDuration: routeidset.travelDuration,
        routeID: routeidset.routeID,
      },
      credentialsBean: {
        userId: customerset.userId,
        password: customerset.password,
        userType: customerset.userType,
        loginStatus: customerset.loginStatus,
      },
      driverBean: {
        driverID: driveridset.driverID,
        name: driveridset.name,
        licenseNumber: driveridset.licenseNumber,
        mobileno: driveridset.mobileno,
        location: driveridset.location,
        street: driveridset.street,
        state: driveridset.state,
        vehicleBean: {
          name: driveridset.vehicleBean.name,
          registrationNumber: driveridset.vehicleBean.registrationNumber,
          seatingapacit: driveridset.vehicleBean.seatingapacity,
          farePerKM: driveridset.vehicleBean.farePerKM,
          type: driveridset.vehicleBean.type,
          vehicleID: driveridset.vehicleBean.vehicleID,
        },
      },
    });
  };

  const handlesubmit = (e) => {
    e.preventDefault();
    CustomerService.Bookvehicle(reserv).then((res) => alert("Vehicel Booked"));
    console.log(JSON.stringify(reserv));
  };

  const showBooking = () => {
    alert("your booking");
    navigate(`/resrvationbyuseid/${customerid}`);
  };
  return (
    <div>
      <button onClick={showBooking}>show Your Booking</button>
      <select onChange={handleselect}>
        <option>--Select-Route---</option>
        {route.map((r) => {
          return (
            <option value={r.routeID} key={r.routeID}>
              {r.source}--{r.destination}
            </option>
          );
        })}
      </select>

      <select onChange={handleselect1}>
        <option>--Select-Vehicle---</option>
        {driver.map((d) => {
          return (
            <option value={d.driverID} key={d.driverID}>
              Vehicle - {d.vehicleBean.name} --- Fare -{" "}
              {d.vehicleBean.farePerKM}
              Rs/-
            </option>
          );
        })}
      </select>
      {routeid ? (
        <div>
          <br />
          <label>Destination</label>
          <input value={routeidset.destination} disabled />
          <br />
          <label>Source</label>
          <input value={routeidset.source} disabled />
          <br />
          <label>Distance</label>
          <input value={routeidset.distance + " Km"} disabled />
          <br />
          <label>Travel-Duration</label>
          <input value={routeidset.travelDuration + " Hrs"} disabled />
          <br />
        </div>
      ) : (
        <span></span>
      )}

      {driverid ? (
        <div>
          <br />
          <label>Vehicle - Name</label>
          <input defaultValue={driveridset.vehicleBean.name} disabled />
          <br />
          <label>Vehicle - Type</label>
          <input value={driveridset.vehicleBean.type} disabled />
          <br />
          <label>Registration - Number</label>
          <input value={driveridset.vehicleBean.registrationNumber} disabled />
          <br />
          <label>Seating-Capacity</label>
          <input value={driveridset.vehicleBean.seatingapacity} disabled />
          <br />
          <label>Driver-Name</label>
          <input value={driveridset.name} disabled />
          <br />
          <label>Driver-MobileNo</label>
          <input value={driveridset.mobileno} disabled />
          <br />
        </div>
      ) : (
        <span></span>
      )}
      <br />
      {driverid && routeid ? (
        <div>
          <label>TOTAL FARE</label>
          <input
            value={
              parseInt(driveridset.vehicleBean.farePerKM) *
                parseInt(routeidset.distance) +
              " Rs only"
            }
            disabled
          />
          <br />
          <form onSubmit={handlesubmit}>
            <label>Journey Date</label>
            <input
              type="date"
              id="journeyDate"
              onChange={handlechange}
              required
            />
            <label>Booking -Date</label>
            <input value={Date().slice(0, 10)} readOnly id="bookingDate" />
            <label>Boarding-Point</label>
            <input
              type="text"
              id="boardingPoint"
              value={routeidset.source}
              readOnly
            />
            <label>Drop-Point</label>
            <input
              type="text"
              id="dropPoint"
              defaultValue={routeidset.destination}
              readOnly
            />
            <label>Total fare</label>
            <input
              value={
                parseInt(driveridset.vehicleBean.farePerKM) *
                parseInt(routeidset.distance)
              }
              id="totalFare"
              readOnly
            />
            <button type="submit">Submit</button>
          </form>
        </div>
      ) : (
        <span></span>
      )}
    </div>
  );
}

export default Booking;
