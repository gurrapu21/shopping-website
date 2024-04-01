import Product from "../components/Product";
import '../css/Home.css'
import { useEffect, useState } from "react";

export default function Home(props) {

    const [products,setProducts] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const [categories, setCategories] = useState({saree: false, cloth: false, towel: false});
    const [error, setError] = useState(null);
    const [filteredProducts, setFilteredProducts] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/getProducts").then(
            data => {
                if (!data.ok) { throw Error(data.statusText); }
                return data.json();
            }
        ).then(
            data => setProducts(data)
        ).catch(
            error => setError(error)
        );
    },[])

    useEffect(() => {
        setFilteredProducts(products.filter((product) => {
           return product.name.toLowerCase().includes(searchTerm.toLowerCase()) && 
                   (Object.keys(categories).every(key => categories[key] === false) || categories[product.type.toLowerCase()]);
        }));
        
            
       
    }, [products, searchTerm, categories]);

    const handleCategoryChange = (event) => {
        setCategories({...categories, [event.target.name.toLowerCase()]: event.target.checked});
    };

    return <div className="home-contaner">

        <div className="categories">
            <div className="title-category">Categories</div>
            <div className="checkbox-buttons">
                <div>
                    <input type='checkbox' name='Saree' onChange={handleCategoryChange} /> 
                    <label>Sarees</label>
                    
                </div>
                <div>
                    <input type='checkbox' name='Cloth' onChange={handleCategoryChange} /> 
                    <label>Cloths</label>
                    
                </div>
                <div>
                    <input type='checkbox' name='Towel' onChange={handleCategoryChange} /> 
                    <label>Towels</label>
                    
                </div>
            </div>
        </div>
        <div className="display-products">
            <div className="search">
                <input type='text' placeholder="search product" onChange={(e) => setSearchTerm(e.target.value)}/>
                <button>Search</button>
            </div>
            <div className="products">
                {error && <div>Error: {error.message}</div>}
                {!error && filteredProducts ? filteredProducts.map(p => <Product product={p}/>) : "No Products please come again later"}
                
            </div>
        </div>
        
    </div>
}
