import React, { useEffect, useState } from "react";
import AdminService from "../Service/Adminservice";
import { Link, useNavigate } from "react-router-dom";

function Routelist() {
  const navigate = useNavigate();
  const [route, setroute] = useState([]);
  useEffect(() => {
    AdminService.getRoute().then((res) => {
      setroute(res);
    });
  }, []);

  const create = () => {
    navigate("/createroute");
  };
  const deleteroute = (id) => {
    let ans = window.confirm(`Do you want Delete ${id} `);
    if (ans) {
      AdminService.deleteRoute(id).then(() => {
        setroute(route.filter((item) => item.routeID !== id));
      });
    } else {
      return;
    }
  };
  return (
    <div>
      <h1>Routes</h1>
      <button onClick={create}>Create</button>
      <table cellPadding="2px" border="1px" align="center">
        <thead>
          <tr>
            <th>Route NO</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Distance</th>
            <th>TravelDuration</th>
          </tr>
        </thead>
        <tbody>
          {route.map((route) => {
            return (
              <tr key={route.routeID}>
                <td>{route.routeID}</td>
                <td>{route.source}</td>
                <td>{route.destination}</td>
                <td>{route.distance}</td>
                <td>{route.travelDuration}</td>
                <td>
                  <Link to={`/editroute/${route.routeID}`}>Edit</Link>
                </td>
                <td>
                  <button onClick={() => deleteroute(route.routeID)}>
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

export default Routelist;
