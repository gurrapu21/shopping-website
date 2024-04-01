import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../css/Login.css';

export default function Login() {
    const [userid, setUserid] = useState('');
    const [password, setPassword] = useState('');
    const [msg, setMsg] = useState('');

    const handleChange = (e, setter) => setter(e.target.value);

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!userid || !password) {
            setMsg('Please enter both email and password.');
            return;
        }
        

        const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email: userid, password: password })
        });
        const data = await response.json();
        console.log(data);
        if (data>0) {
            sessionStorage.setItem("customerId",data);
            setMsg('Login successful!');
            sessionStorage.setItem("isLogin","true");
            console.log(sessionStorage.getItem("isLogin"));
            window.location.href = 'http://localhost:3000';
            // Perform any additional actions on successful login here
        } else {
            setMsg('Login failed. Please check your username and password.');
        }
    };

    return (
        <div className="main">
            <div className="login-container">
                <div className="form-container login-container">
                    <form onSubmit={handleSubmit} id="login-form">
                        <h2>Login</h2><br/>
                        <input className="loginInput" placeholder="Email" type="text" name="uname" onChange={(e) =>  handleChange(e,setUserid)} required='required'/><br/>
                        <input className="loginInput" placeholder="Password" type="password" name = "password" onChange={(e) => handleChange(e,setPassword)} required='required'/><br/><br/>
                        <button className="loginButton" type="submit" name="submit">Login</button><br/>
                        <div id="msg">{msg}</div>
                        {/* <Link to = '/forgotPassword' >Forgot Password?</Link> */}
                    </form>
                </div>
            </div>
        </div>
    );
}
