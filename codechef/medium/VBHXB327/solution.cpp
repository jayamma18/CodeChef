import { Link } from 'react-router-dom';
import './Navbar.css'; // Create this file for basic styling

const Navbar = () => {

    return (
        <nav className="navbar">
            <div className="navbar-left">
                <Link to="/" className="navbar-brand">MERN Blog</Link>
            </div>
            <div className="navbar-right">
                <Link className="nav-link">Login</Link>
                <Link className="nav-link">Create Account</Link>
            </div>
        </nav>
    );
};

export default Navbar;