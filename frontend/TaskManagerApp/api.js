import axios from "axios";

const API = axios.create({
  baseURL: "http://192.168.169.239:8080", // Use your local machine IP (NOT localhost or 127.0.0.1)
});

export default API;
