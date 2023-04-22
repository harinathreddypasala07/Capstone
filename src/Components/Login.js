import React, { useEffect, useState } from "react";
import AdminService from "../Service/Adminservice";
import { useNavigate } from "react-router-dom";

function Login() {
  const [userId, setuserId] = useState();
  const [password, setpassword] = useState();
  const [submit, setsubmit] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    if (submit) {
      AdminService.getLogin(userId, password).then((res) => {
        // alert(res);
        if (res === true) {
          AdminService.getusrById(userId).then((res) => {
            if (res.userType === "C") {
              navigate(`/booking/${userId}`);
            } else if (res.userType === "A") {
              navigate(`/routeList`);
            }
          });
        } else if (res === false) {
          alert("Sign up first");
          setsubmit(false);
          alert("Sign up first");
          navigate(`/profileadd`);
        }
      });
    }
  }, [submit, userId, password, navigate]);

  // useEffect(() => {

  // }, [])

  const handleuser = (e) => {
    setuserId(e.target.value);
  };
  const handlepassword = (e) => {
    setpassword(e.target.value);
  };

  const handlesubmit = (e) => {
    e.preventDefault();
    setsubmit(true);
  };
  return (
    <div>
      <form onSubmit={handlesubmit}>
        <label>UserName</label>
        <input type="text" onChange={handleuser} />
        <label>Password</label>
        <input type="password" onChange={handlepassword} />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default Login;
