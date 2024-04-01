import '../css/CartItem.css'
import { useState } from "react";

export default function CartItem(props) {

    var item = props.item.product;
    var variation = props.item.productVariation;
    var [quantity, setQuantity] = useState(props.quantity);
    console.log(item)
    var customerId = sessionStorage.getItem("customerId");
    const increaseQuantity = () => {
        if (quantity < item.productQuantity.availableQuantity) {
            setQuantity(quantity + 1);
            props.recalculateTotal();
        } else {
            alert('Cannot add more items. Maximum available quantity reached.');
        }
    };

    // const decreaseQuantity = () => {
    //     if (quantity > 1) {
    //         setQuantity(quantity - 1);
    //         props.recalculateTotal();
    //     } else {
    //         alert('Cannot reduce quantity below 1.');
    //     }
    // };

    // const handleQuantityChange = (event) => {
    //     if (event.target.value <= item.productQuantity.availableQuantity && event.target.value > 0) {
    //         setQuantity(event.target.value);
    //         props.recalculateTotal();
    //     } else {
    //         alert('Invalid quantity. Please enter a value between 1 and ' + item.productQuantity.availableQuantity);
    //     }
    // };


    const removeFromCart = async () => {
        const response = await fetch(`http://localhost:8080/removeFromCart?customerId=${customerId}&itemId=${props.itemId}`);
        if (response.ok) {
            // If the request is successful, remove the item from the cart in the frontend
            props.removeItemFromCart(props.itemId);
        } else {
            throw new Error('Error: ' + response.statusText);
        }
    };


    return <div className="Cart-Item-Contaner">

        <div className="Cart-Item-Name">
            <div className="Item-name">{item.name}</div>
            <div className="category-name">
                <span className="def">Item Type</span><br />
                {item.type}
            </div>
            <div className="remove-Item">
                <button onClick={removeFromCart}><img src="https://cdn-icons-png.flaticon.com/128/5820/5820979.png" height='20px' alt='remove'></img></button>
            </div>
        </div>
        <div className="item-cost">
            <div className="price">
                <span className="def">Price</span><br />
                {/* <span className="currency-symbol"></span> */}
                <div>₹{item.productCost.sellingPrice}</div>
            </div>
            {/* <div className='add-cart-contaner'>
                <div className='quantity-contaner'>
                    <button className='adjust-quanity' onClick={decreaseQuantity}>-</button>
                    <input className='quntity' type='number' value={quantity} onChange={handleQuantityChange}/>
                    <button className='adjust-quanity' onClick={increaseQuantity}>+</button>
                </div>
            </div> */}
            <div className="quantity-variation">
                <div className="cart-item-quantity">

                    <span className="def">Quantity : </span>
                    {/* <span className="currency-symbol">₹</span> */}
                    {quantity}

                </div>
                <div className="variation">
                    <span className="def">Variation : </span>
                    {/* <span className="currency-symbol">₹</span> */}
                    {variation.color + " " + variation.size}
                </div>
            </div>
            <div className="total-price">
                <span className="def">Total Price</span><br />
                <span className="currency-symbol">₹</span>
                {item.productCost.sellingPrice * quantity}
            </div>
        </div>

    </div>
}
