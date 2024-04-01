import { useState } from 'react';
import '../css/Registration.css'

export default function Registration() {

    const [form, setForm] = useState({
        name: '',
        email: '',
        phoneNumber: '',
        password: '',
        address: {
            Id: '',
            houseNumber: '',
            lane: '',
            city: '',
            state: '',
            pincode: ''
        }
    });

    const handleChange = (e) => {
        const { id, value } = e.target;
        setForm(prevState => ({
            ...prevState,
            [id]: value
        }));
    }

    const register = (event) => {
        event.preventDefault();
        fetch('http://localhost:8080/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(form)
        })
            .then(response => response.text())  // Get response text
            .then(data => {
                alert(data);  // Handle the data (string) from the response
            })
            .catch((error) => {
                console.error('Error:', error);
            });

    }

    function validateForm() {
        // Name validation
        var name = document.getElementById('name').value;
        if (!/^[a-zA-Z\s]*$/.test(name)) {
            alert('Invalid name. Only alphabets and spaces are allowed.');
            return false;
        }

        // Email validation
        var email = document.getElementById('email').value;
        if (!/^\S+@\S+\.\S+$/.test(email)) {
            alert('Invalid email.');
            return false;
        }

        // Phone number validation
        var phoneNumber = document.getElementById('phoneNumber').value;
        if (!/^\d{10}$/.test(phoneNumber)) {
            alert('Invalid phone number. It should contain exactly 10 digits.');
            return false;
        }

        // Password validation
        var password = document.getElementById('password').value;
        if (!/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/.test(password)) {
            alert('Invalid password. It should contain at least one number, one lowercase and one uppercase letter, and at least 8 characters.');
            return false;
        }

        // Address validation
        var houseNumber = document.getElementById('houseNumber').value;
        var lane = document.getElementById('lane').value;
        var city = document.getElementById('city').value;
        var state = document.getElementById('state').value;
        var pincode = document.getElementById('pincode').value;

        if (!/^[\d-/]+$/.test(houseNumber)) {
            alert('Invalid house number. It should contain only digits, hyphens (-), and slashes (/).');
            return false;
        }


        if (!/^[a-zA-Z\s]*$/.test(lane)) {
            alert('Invalid Area. Only alphabets and spaces are allowed.');
            return false;
        }

        if (!/^[a-zA-Z\s]*$/.test(city)) {
            alert('Invalid city. Only alphabets and spaces are allowed.');
            return false;
        }

        if (!/^[a-zA-Z\s]*$/.test(state)) {
            alert('Invalid state. Only alphabets and spaces are allowed.');
            return false;
        }

        if (!/^\d{6}$/.test(pincode)) {
            alert('Invalid pincode. It should contain exactly 6 digits.');
            return false;
        }

        return true;
    }

    return <>
        <form onSubmit={register}>
            <div className='registation-container'>
                <div className="container">
                    <div className='input-fields'>
                        <div >
                            <label for="name"><b>Name</b></label>
                            <input className='registration-inputs' type="text" placeholder="Enter Name" name="name" id="name" required onChange={handleChange} />

                            <label for="email"><b>Email</b></label>
                            <input className='registration-inputs' type="email" placeholder="Enter Email" name="email" id="email" required onChange={handleChange} />

                            <label for="phoneNumber"><b>Phone Number</b></label>
                            <input className='registration-inputs' type="number" placeholder="Enter Phone Number" name="phoneNumber" id="phoneNumber" required onChange={handleChange} />

                            <label for="password"><b>Password</b></label>
                            <input className='registration-inputs' type="password" placeholder="Enter Password" name="password" id="password" required onChange={handleChange} />
                        </div>
                        <div >
                            <label for="address"><b>Address</b></label>
                            <input className='registration-inputs' type="text" placeholder="Enter House Number" name="houseNumber" id="houseNumber" required onChange={handleChange} />
                            <input className='registration-inputs' type="text" placeholder="Enter Area" name="lane" id="lane" required onChange={handleChange} />
                            <input className='registration-inputs' type="text" placeholder="Enter City" name="city" id="city" required onChange={handleChange} />
                            <input className='registration-inputs' type="text" placeholder="Enter State" name="state" id="state" required onChange={handleChange} />
                            <input className='registration-inputs' type="number" placeholder="Enter Pincode" name="pincode" id="pincode" required onChange={handleChange} />
                        </div>
                    </div>
                    <button className='registrationButton' type="submit">Register</button>
                </div>

            </div>
        </form>
    </>
}