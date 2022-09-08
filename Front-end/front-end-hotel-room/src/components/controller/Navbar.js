import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css"

const NavBar = () => {
    return (
        <div className="navbar">
            <label className="logo">
            Hoteliko
            </label>
            <nav>
                <ul>
                    <li>
                        <Link className="link" to='/'>Home</Link>
                    </li>
                    <li>
                        <Link className="link" to='/hotel'>Hotel</Link>
                    </li>
                    <li>
                        <Link className="link" to='/ville'>Ville</Link>
                    </li>
                    <li>
                        <Link className="link" to='/about'>About</Link>
                    </li>
                </ul>
            </nav>
        </div>
    )
}
export default NavBar;