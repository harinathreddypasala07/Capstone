import React, { useEffect, useState } from "react";
import CustomerService from "../Service/Customerservice";

function ReservationById() {
  const [resv, setresv] = useState([]);
  const userId = window.location.pathname.split("/")[2];

  useEffect(() => {
    if (userId) {
      CustomerService.getReservationByusrId(userId).then((res) => setresv(res));
    }
  }, [userId]);
  const cancelreservation = (id) => {
    let ans = window.confirm(
      `Do you want Delete your Booking and the ID is ${id}  `
    );

    if (ans) {
      CustomerService.deleteResrvation(id).then((res) => {
        setresv(resv.filter((item) => item.reservationID !== id));
      });
    }
  };
  return (
    <div>
      <h1>View Reservation</h1>
      {resv.length ? (
        <table cellPadding="2px" border="1px" align="center">
          <thead>
            <td>BookingID</td>
            <td>JourneyDate</td>
            <td>BookingDate</td>

            <td>BoardingPoint</td>
            <td>DropPoint</td>

            <td>Driver - name</td>
            <td>vehicle - name</td>

            <td>vehicle - registrationNumber</td>
          </thead>
          <tbody>
            {resv.map((r) => {
              return (
                <tr>
                  <td>{r.reservationID}</td>
                  <td>{r.journeyDate}</td>
                  <td>{r.bookingDate}</td>

                  <td>{r.boardingPoint}</td>
                  <td>{r.dropPoint}</td>

                  <td>{r.driverBean.name}</td>
                  <td>{r.driverBean.vehicleBean.name}</td>

                  <td>{r.driverBean.vehicleBean.registrationNumber}</td>
                  <td>
                    <button onClick={() => cancelreservation(r.reservationID)}>
                      Cancel - Booking
                    </button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      ) : (
        <span>You Have No Booking</span>
      )}
    </div>
  );
}

export default ReservationById;
