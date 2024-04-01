import React, { useEffect, useState } from 'react';
import '../css/Orders.css'

function Orders() {
    const [orders, setOrders] = useState([]);
    var customerId = sessionStorage.getItem("customerId");

    useEffect(() => {
        fetch('http://localhost:8080/getOrders/'+customerId)
            .then(response => response.json())
            .then(data => setOrders(data))
            .catch(error => console.error('There was an error!', error));
    }, []);

    return (
        <div className="order-details">
            {
            orders.length !== 0  ? orders.map((order, index) => (
                <div key={index} className="order-item">
                    <h2>Order Num :  #{order.id}</h2>
                    <p>Date: {order.date}</p>
                    <p>Amount: {order.amount}</p>
                    <p>Payment Method: {order.paymentMethod}</p>
                    <p>Quantity: {order.quantity}</p>
                    <p>Status: {order.status}</p>
                    <h3>Product Details</h3>
                    <p>Name: {order.product.name}</p>
                    <p>Type: {order.product.type}</p>
                    <p>Selling Price: {order.product.productCost.sellingPrice}</p>
                    {/* Add more product details as needed */}
                </div>
            )): <h4>There Are No Orders To Display</h4>}
        </div>
    );
}

export default Orders;
