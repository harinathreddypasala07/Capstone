import React, { useEffect, useState } from "react";
import AdminService from "../Service/Adminservice";
import { useNavigate } from "react-router-dom";

function Addroute() {
  const routeID = window.location.pathname.split("/")[2];

  const navigate = useNavigate();
  const [data, setdata] = useState({
    source: "",
    destination: "",
    distance: 0,
    travelDuration: 0,
    // routeID: 0,
  });

  useEffect(() => {
    if (routeID) {
      AdminService.getRouteById(routeID).then((res) =>
        setdata({
          source: res.source,
          destination: res.destination,
          distance: res.distance,
          travelDuration: res.travelDuration,
          routeID: res.routeID,
        })
      );
    }
  }, [routeID]);

  // console.log(data);
  // console.log(routeID);
  // console.log(routeID.id);

  const handlechange = (e) => {
    setdata({ ...data, [e.target.id]: e.target.value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();

    if (routeID) {
      AdminService.putRoute(data).then((res) => alert("Data is updated"));
      navigate("/routeList");
      window.location.reload();
    } else {
      AdminService.postRoute(data).then((res) => alert("Route is Added"));
      navigate("/routeList");
      window.location.reload();
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit} id="route_form">
        <h1>{routeID ? "EditRoute" : "AddRoute"}</h1>
        <label>Source</label>
        <input
          type="text"
          id="source"
          onChange={handlechange}
          value={data.source}
          required
        />
        <br />
        <label>Destination</label>
        <input
          type="text"
          id="destination"
          onChange={handlechange}
          value={data.destination}
          required
        />
        <br />
        <label>Distance</label>
        <input
          type="text"
          id="distance"
          maxLength="4"
          pattern="[0-9]*"
          onChange={handlechange}
          value={data.distance}
          required
        />
        <span>KM</span>
        <br />
        <label>TravelDuration</label>
        <input
          type="text"
          id="travelDuration"
          maxLength="2"
          pattern="[0-9]*"
          onChange={handlechange}
          value={data.travelDuration}
          required
        />
        <span>Hrs</span>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default Addroute;
