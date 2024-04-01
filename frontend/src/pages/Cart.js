import CartItem from '../components/CartItem.js';
import '../css/Cart.css'
import { useEffect, useState } from "react";
export default function Cart() {

    const [cartItems, setCartItems] = useState([]);
    const [address, setAddress] = useState({
        "houseNumber": "",
        "lane": "",
        "city": "",
        "state": "",
        "pincode": 0,
        
      });
      const [total,setTotal] = useState(0);

    var customerId = sessionStorage.getItem("customerId");

    const [orderPlaced, setOrderPlaced] = useState(false);

    useEffect(() => {
        fetch("http://localhost:8080/getCart?customerId="+customerId).then(
            data => data.json()
        ).then(
            data => {
                let totalAmount = 0;
                if(data.items.length !== 0){
                    totalAmount = data.items.reduce((total, item) => {
                        return total + (item.product.productCost.sellingPrice * item.quantity);
                    }, 0);
                }
                setTotal(totalAmount);
                setAddress(data.address);
                setCartItems(data.items);
            }
        );

        
    },[orderPlaced,total])


    const removeItemFromCart = (itemId) => {
        setCartItems(prevCartItems => {
            const updatedCartItems = prevCartItems.filter(item => item.id !== itemId);
            recalculateTotal(updatedCartItems);
            return updatedCartItems;
        });
    };

    const recalculateTotal = (items) => {
        let totalAmount = 0;
        if(items.length !== 0){
            totalAmount = items.reduce((total, item) => {
                return total + (item.product.productCost.sellingPrice * item.quantity);
            }, 0);
        }
        setTotal(totalAmount);
    };
    
    
   

    const handleOrder = async () => {
        const response = await fetch("http://localhost:8080/takeOrders/1", {method: 'post'});
        const data = await response.json();
        // setOrderStatus(data.orderStatus);
        let alertMessage = '';
        data.orderStatus.forEach(item => {
            alertMessage += `Product Name: ${item.cartItem.product.name}, Quantity: ${item.cartItem.quantity}, Status: ${item.status}\n`;
        });
        alert(alertMessage);
        setOrderPlaced(prevState => !prevState);  // Toggle the orderPlaced state
    };
    
    
    

    // var address = {
    //     "houseNumber": "123",
    //     "lane": "Main Street",
    //     "city": "Hyderabad",
    //     "state": "Telangana",
    //     "pincode": 500001,
    //     "customer": {
    //       "customerId": 1,
    //       "name": "John Doe",
    //       "email": "johndoe@example.com"
    //     }
    //   }
    
    return<div className="outter-contaner"> <div className="cart-contaner">

        <div className="cart-title">
            ITEMS IN YOUR CART
        </div>
        <div className="cart-items">
            {cartItems.length === 0 ? "No Items In The cart":cartItems.map(i => 
            <CartItem itemId={i.id} item={i} quantity={i.quantity} removeItemFromCart={removeItemFromCart}  recalculateTotal={recalculateTotal}/>)}
        </div>

        <div className="total-amount">
            
                <div className="def">
                    Total Amount : 
                </div>
                <div>
                <span className="currency-symbol">₹</span>
                {total}
                </div>
            
        </div>

        <div className="delivery-address">
            <div className="address-title">
                DELIVERY ADDRESS
            </div>
            <div className="address">
            {address.houseNumber}<br/>
            {address.lane}<br/>
            City : {address.city}<br/>
            State : {address.state}<br/>
            Pincode : {address.pincode}
            </div>
        </div>

        <div className="buy">
            <div className="buy">
                    <button onClick={handleOrder}>order</button>
                </div>
        </div>
    </div>
    </div>

}

