import React, { useEffect, useState } from "react";
import AdminService from "../Service/Adminservice";

function Reservationlist() {
  const [resv, setresv] = useState([]);

  useEffect(() => {
    AdminService.viewReservation().then((res) => setresv(res));
  }, []);
  console.log(resv);
  return (
    <div>
      <h1>View Reservation</h1>
      <table cellPadding="2px" border="1px" align="center">
        <thead>
          <td>ReservationID</td>
          <td>JourneyDate</td>
          <td>BookingDate</td>
          <td>BookingStatus</td>
          <td>BoardingPoint</td>
          <td>DropPoint</td>
          <td>UserId</td>
          <td>driverID</td>
          <td>Driver - name</td>
          <td>vehicle - name</td>
          <td>vehicleID</td>
          <td>vehicle - registrationNumber</td>
        </thead>
        <tbody>
          {resv.map((r) => {
            return (
              <tr>
                <td>{r.reservationID}</td>
                <td>{r.journeyDate}</td>
                <td>{r.bookingDate}</td>
                <td>{r.bookingStatus}</td>
                <td>{r.boardingPoint}</td>
                <td>{r.dropPoint}</td>
                <td>{r.credentialsBean.userId}</td>
                <td>{r.driverBean.driverID}</td>
                <td>{r.driverBean.name}</td>
                <td>{r.driverBean.vehicleBean.name}</td>
                <td>{r.driverBean.vehicleBean.vehicleID}</td>
                <td>{r.driverBean.vehicleBean.registrationNumber}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}

export default Reservationlist;
