import { Link } from 'react-router-dom'
import '../css/Navbar.css'

export default function LoginNavbar(props) {



    return <header className="header">

        <div className="title-bar">
           
            <div className="website-name"> Cloth Store</div>
            
            <div className="cart-icon">
                <Link to='/Login' title='Cart'>
                {/* <img className='icon' src="https://cdn-icons-png.flaticon.com/128/833/833314.png" alt='cart'></img> */}
                Login
                </Link>
            </div>
            <div className='profile-icon'>
                <Link to='/Registration' title='Profile'>
                {/* <img className='icon' src="https://cdn-icons-png.flaticon.com/128/3033/3033143.png" alt='profile'></img> */}
                Registration
                </Link>
            </div>
        </div>
        {/* <nav className="nav-bar">
            <div className="home-button"><Link to='/' title='Home'>HOME</Link></div>
            <div className="myorders"><Link to='/orders' title='Home'>MY ORDERS</Link></div>
        </nav> */}

        
    </header>

}