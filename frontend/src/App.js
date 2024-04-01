import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Footer from './components/Footer';
import Orders from './components/Orders';
import Home from './pages/Home';
import Cart from './pages/Cart';
import Profile from './pages/Profile';
import Login from './pages/Login';
import LoginNavbar from './components/LoginNavbar';
import Registration from './pages/Registration';

function App() {

  const isLogin = sessionStorage.getItem('isLogin');
  const role = sessionStorage.getItem('role');
  sessionStorage.setItem('url', 'http://localhost:8080');

  if (isLogin === null) {
    sessionStorage.setItem('isLogin', 'false');
  }

  console.log(sessionStorage.getItem('isLogin'));

  return (
    <div className="App">

      {isLogin === 'true' ?

         <BrowserRouter>
          <Navbar />
          <div className='page'>
            <Routes>
              <Route path='/' element={<Home></Home>}></Route>
              <Route path='/orders' element={<Orders />}></Route>
              <Route path='/profile' element={<Profile />}></Route>
              <Route path='/cart' element={<Cart />}></Route>
            </Routes>
          </div>

          <Footer />
        </BrowserRouter>

        : 
        
        <BrowserRouter>
          <LoginNavbar />
          <div className='page'>
            <Routes>
              <Route path='/' element={<Login></Login>}></Route>
              <Route path='/Login' element={<Login />}></Route>
              <Route path='/Registration' element={<Registration />}></Route>
            </Routes>
          </div>

          <Footer />
        </BrowserRouter>}


    </div>
  );
}

export default App;

