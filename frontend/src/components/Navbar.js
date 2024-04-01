import { Link } from 'react-router-dom'
import '../css/Navbar.css'

export default function Navbar(props) {

    const handleLogout = ()=> {
        // sessionStorage.setItem("isLogin","false");
        // location.reload();
        sessionStorage.clear();
        window.location.href = 'http://localhost:3000';

    } 

    return <header className="header">

        <div className="title-bar">
           
            <div className="website-name"> Cloth Store</div>
            
            <div className="cart-icon">
                <Link to='/cart' title='Cart'>
                <img className='icon' src="https://cdn-icons-png.flaticon.com/128/833/833314.png" alt='cart'></img>
                </Link>
            </div>
            <div className='dropdown'>
                <button className='dropbtn'>
                    <img src="https://cdn-icons-png.flaticon.com/128/2976/2976215.png" loading="lazy" alt="Menu " title="Menu " width="24" height="24"/>
                </button>
                <div className='dropdown-content'>
                    <Link to='/profile' title='Profile'>
                        <img className='icon' src="https://cdn-icons-png.flaticon.com/128/3033/3033143.png" alt='profile'></img>
                    </Link>
                    <Link onClick={handleLogout} title='logout'>Logout</Link>
                </div>
            </div>
            {/* <div className='profile-icon'>
                <Link to='/profile' title='Profile'>
                <img className='icon' src="https://cdn-icons-png.flaticon.com/128/3033/3033143.png" alt='profile'></img>
                </Link>
            </div>
            <div className='profile-icon'>
                <Link onClick={handleLogout} title='logout'>
                    Logout
                </Link>
            </div> */}
        </div>
        <nav className="nav-bar">
            <div className="home-button"><Link to='/' title='Home'>HOME</Link></div>
            <div className="myorders"><Link to='/orders' title='Home'>MY ORDERS</Link></div>
        </nav>

        
    </header>

}