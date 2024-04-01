import React, { useState, useEffect } from 'react';
import '../css/Profile.css'

function Profile() {

    const [customer, setCustomer] = useState({
        Id: 1,
        name: '',
        email: '',
        phoneNumber: '',
        password: '',
        address: {
            Id: 1,
            houseNumber: '',
            lane: '',
            city: '',
            state: '',
            pincode: ''
        }
    });

    var customerId = sessionStorage.getItem("customerId");

    useEffect(() => {
        // Fetch the initial customer details when the component mounts
        fetchCustomerDetails();
    }, []);

    const fetchCustomerDetails = async () => {
        const response = await fetch('http://localhost:8080/getCustomerDetails/' + customerId);
        const data = await response.json();
        
        setCustomer(data);
    };

    const updateCustomerDetails = async () => {
        if (!validateForm()) {
            return;
        }

        const response = await fetch('http://localhost:8080/update/' + customerId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(customer)
        });
        const data = await response.json();
        alert("YOUR PROFILE DETAILS ARE UPDATED!");
        setCustomer(data);
    };

    const handleChange = (e) => {
        setCustomer(prevState => ({
            ...prevState,
            address: {
                ...prevState.address,
                [e.target.name]: e.target.value
            }
        }));
    };
    

    const validateForm = () => {
        let isValid = true;
    
        // Validate name
        if (!customer.name || customer.name.trim().length === 0) {
            alert('Name is required');
            isValid = false;
        }
    
        // Validate email
        const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!customer.email || !emailRegex.test(customer.email)) {
            alert('Please enter a valid email');
            isValid = false;
        }
    
        // Validate phone number
        const phoneRegex = /^\d{10}$/;
        if (!customer.phoneNumber || !phoneRegex.test(customer.phoneNumber)) {
            alert('Please enter a valid 10-digit phone number');
            isValid = false;
        }
    
        // Validate password
        // if (!customer.password || customer.password.length < 8) {
        //     alert('Password must be at least 8 characters');
        //     isValid = false;
        // }
    
        // Validate address
        if (!customer.address || !customer.address.houseNumber || customer.address.houseNumber.trim().length === 0 || 
            !customer.address.lane || customer.address.lane.trim().length === 0 || 
            !customer.address.city || customer.address.city.trim().length === 0 || 
            !customer.address.state || customer.address.state.trim().length === 0 || 
            !customer.address.pincode || customer.address.pincode.toString().length !== 6) {
            alert('All address fields are required');
            isValid = false;
        }
    
        return isValid;
    };

    return (
        <div className="customer-details">
            <div>
                <h1>Customer Details</h1>
                <label>
                    Name:
                    <input type="text" name="name" value={customer.name} onChange={handleChange} />
                </label>
                <label>
                    Email:
                    <input type="text" name="email" value={customer.email} onChange={handleChange} />
                </label>
                <label>
                    Phone Number:
                    <input type="text" name="phoneNumber" value={customer.phoneNumber} onChange={handleChange} />
                </label>
                {/* <label>
                    Password:
                    <input type="password" name="password" value={customer.password} onChange={handleChange} />
                </label> */}
            </div>
            <div>
                <h2>Address</h2>
                <label>
                    House Number:
                    <input type="text" name="houseNumber" value={customer.address.houseNumber} onChange={handleChange} />
                </label>
                <label>
                    Area Name:
                    <input type="text" name="lane" value={customer.address.lane} onChange={handleChange} />
                </label>
                <label>
                    City:
                    <input type="text" name="city" value={customer.address.city} onChange={handleChange} />
                </label>
                <label>
                    State:
                    <input type="text" name="state" value={customer.address.state} onChange={handleChange} />
                </label>
                <label>
                    Pincode:
                    <input type="text" name="pincode" value={customer.address.pincode} onChange={handleChange} />
                </label>
            </div>
            <button onClick={updateCustomerDetails}>Update</button>
        </div>
    );
}

export default Profile;
