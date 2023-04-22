import axios from "axios";
const Adminurl = "http://localhost:8080/customer";
const CustomerService = {
  getRoute: async () => {
    const response = await axios.get(Adminurl + "/viewRoute");
    return response.data;
  },
  getDriver: async () => {
    const response = await axios.get(Adminurl + "/viewDriver");
    return response.data;
  },
  getRouteById: async (id) => {
    const response = await axios.get(`${Adminurl}/route/${id}`);
    return response.data;
  },
  getDriverById: async (id) => {
    const response = await axios.get(`${Adminurl}/driver/${id}`);
    return response.data;
  },
  Bookvehicle: async (data) => {
    const response = await axios.post(Adminurl + "/bookVehicle", data);
    return response.data;
  },
  //Profile
  Addprofile: async (data) => {
    const response = await axios.post(Adminurl + "/addProfile", data);
    return response.data;
  },
  getReservationByusrId: async (id) => {
    const response = await axios.get(`${Adminurl}/reservationbyuser/${id}`);
    return response.data;
  },
  deleteResrvation: async (id) => {
    const response = await axios.delete(`${Adminurl}/deletereservation/${id}`);
    return response.data;
  },
};
export default CustomerService;
