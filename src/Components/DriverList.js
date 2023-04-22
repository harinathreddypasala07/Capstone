import React, { useEffect, useState } from "react";
import AdminService from "../Service/Adminservice";
import { Link, useNavigate } from "react-router-dom";

function DriverList() {
  const navigate = useNavigate();
  const [data, setdata] = useState([]);
  useEffect(() => {
    AdminService.getDriver().then((res) => {
      setdata(res);
    });
  }, []);
  console.log(data);
  const create = () => {
    navigate("/adddriver");
  };
  const deletedriver = (id) => {
    let ans = window.confirm(`Do you want Delete ${id} `);
    if (ans) {
      AdminService.deleteDriver(id).then(() => {
        setdata(data.filter((item) => item.driverID !== id));
      });
    } else {
      return;
    }
  };
  return (
    <div>
      <h1>Drivers</h1>
      <button onClick={create}>Create</button>
      <table cellPadding="2px" border="1px" align="center">
        <thead>
          <tr>
            <td>DriverID</td>
            <td>Driver-Name</td>
            <td>LicenseNumber</td>
            <td>Mobileno</td>
            <td>Location</td>
            <td>Street</td>
            <td>State</td>
            <td>Assigned-vehicleID</td>
          </tr>
        </thead>
        <tbody>
          {data.map((d) => {
            return (
              <tr key={d.driverID}>
                <td>{d.driverID}</td>
                <td>{d.name}</td>
                <td>{d.licenseNumber}</td>
                <td>{d.mobileno}</td>
                <td>{d.location}</td>
                <td>{d.street}</td>
                <td>{d.state}</td>
                <td>{d.vehicleBean ? d.vehicleBean.vehicleID : ""}</td>
                <td>
                  <Link to={`/editdriver/${d.driverID}`}>Edit</Link>
                </td>
                <td>
                  <button onClick={() => deletedriver(d.driverID)}>
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

export default DriverList;
