import { useState, useEffect } from 'react';
import '../css/Product.css'

export default function Product(props) {

    var item = props.product;
    


    const [quantity, setQuantity] = useState(1); // Initialize quantity state
    const [selectedVariation, setSelectedVariation] = useState(item.productVariation[0]);
    
    useEffect(() => {
        setSelectedVariation(item.productVariation[0]);
    }, [item]);
    
    const addToCart = () => {

        // console.log(item.productQuantity.availableQuantity);
        if (quantity > selectedVariation.productQuantity.availableQuantity && quantity < 1) {
            alert('The requested quantity exceeds the available quantity. Please lower the quantity. avalilable Quantity : ' + selectedVariation.productQuantity.availableQuantity);
            return;
        }

        console.log('Adding to cart: ', item.id, selectedVariation.id, quantity);

        fetch('http://localhost:8080/addToCart', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                customerId: sessionStorage.getItem("customerId"),
                productId: item.id,
                productVariationId: selectedVariation.id,
                quantity: quantity,
            }),
        })
            .then(response => {
                if (response.ok) {
                    alert('Item added to cart successfully!');
                    return response.json();
                } else {
                    throw new Error('Error: ' + response.statusText);
                }
            })
            .then(data => {
                console.log('Success:', data);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }



    // Function to increase quantity
    const increaseQuantity = () => {
        setQuantity(quantity + 1);
    }

    // Function to decrease quantity
    const decreaseQuantity = () => {
        if (quantity > 1) {
            setQuantity(quantity - 1);
        }
    }

    return <div className="product-contaner">
        <div className="product-name">
            <div>{item.name}</div>
        </div>


        <div className="cost">

            <span className="discount">
                -{item.productCost.discount}%
            </span>

            <span className="selling-cost">

                <span className="currency-symbol">₹</span>

                <span className="cost"> {item.productCost.sellingPrice} </span>

            </span>

            <div className="mrp">
                M.R.P.: {item.productCost.mrp}
            </div>

        </div>

        <div className='add-cart-contaner'>


            <div className='quantity-contaner'>

                <div className='dropdown'>
                <select onChange={(e) => setSelectedVariation(item.productVariation.find(variation => variation.id === Number(e.target.value)))}>

                        {item.productVariation.map(variation => (
                            <option value={variation.id}>{variation.color} - {variation.size}</option>
                        ))}
                    </select>

                </div>

                <div>
                    <button className='adjust-quantity' onClick={decreaseQuantity}>-</button>
                    <input className='quntity' type='number' value={quantity} onChange={(e) => setQuantity(e.target.value)} />
                    <button className='adjust-quantity' onClick={increaseQuantity}>+</button>
                </div>

            </div>
            <div className='add-to-cart-button'>
                <button onClick={addToCart}>Add To Cart</button>
            </div>
        </div>
    </div>
}