import axios from "axios";
const Adminurl = "http://localhost:8080/admin";
const AdminService = {
  //Route
  getRoute: async () => {
    const response = await axios.get(Adminurl + "/viewRoute");
    return response.data;
  },
  postRoute: async (data) => {
    const response = await axios.post(Adminurl + "/addRoute", data);
    return response.data;
  },
  getRouteById: async (id) => {
    const response = await axios.get(`${Adminurl}/route/${id}`);
    return response.data;
  },
  putRoute: async (data) => {
    const response = await axios.put(`${Adminurl}/modifyRoute`, data);
    return response.data;
  },
  deleteRoute: async (id) => {
    const response = await axios.delete(`${Adminurl}/deleteRoute/${id}`);
    return response.data;
  },

  //Vehicle
  getVehicle: async () => {
    const response = await axios.get(Adminurl + "/viewVehicle");
    return response.data;
  },
  postVehicle: async (data) => {
    const response = await axios.post(Adminurl + "/addVehicle", data);
    return response.data;
  },
  getVehicelById: async (id) => {
    const response = await axios.get(`${Adminurl}/Vehicle/${id}`);
    return response.data;
  },
  getVehicelById1: async (id) => {
    const response = await axios.get(`${Adminurl}/Vehicle/${id}`);
    return response.data;
  },
  putVehicle: async (data) => {
    const response = await axios.put(`${Adminurl}/modifyVehicle`, data);
    return response.data;
  },
  deleteVehicle: async (id) => {
    const response = await axios.delete(`${Adminurl}/deleteVehicle/${id}`);
    return response.data;
  },

  //Driver
  getDriver: async () => {
    const response = await axios.get(Adminurl + "/viewDriver");
    return response.data;
  },
  getDriverById: async (id) => {
    const response = await axios.get(`${Adminurl}/driver/${id}`);
    return response.data;
  },
  postDriver: async (data) => {
    const response = await axios.post(Adminurl + "/addDriver", data);
    return response.data;
  },
  putDriver: async (data) => {
    const response = await axios.put(`${Adminurl}/modifyDriver`, data);
    return response.data;
  },
  deleteDriver: async (id) => {
    const response = await axios.delete(`${Adminurl}/deleteDriver/${id}`);
    return response.data;
  },

  //Reservation
  viewReservation: async () => {
    const response = await axios.get(Adminurl + "/reservation");
    return response.data;
  },

  //Login
  getLogin: async (userId, password) => {
    const response = await axios.get(
      `${Adminurl}/selectUser/${userId}/${password}`
    );
    return response.data;
  },
  getusrById: async (id) => {
    const response = await axios.get(`${Adminurl}/userbyid/${id}`);
    return response.data;
  },
};
export default AdminService;
