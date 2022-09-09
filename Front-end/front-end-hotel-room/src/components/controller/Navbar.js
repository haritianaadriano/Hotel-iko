import React from "react";
import { Link } from "react-router-dom";
import './Logo.css'

const NavBar = () => {
    return (
        <div classNameName="navbar">
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <label className="logo">HOTEL-iko</label>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                    <li className="nav-item active">
                        <Link className="nav-link" to='/'>Home</Link>
                    </li>
                    <li className="nav-item active">
                        <Link className="nav-link" to='/hotel'>Hotel</Link>
                    </li>
                    <li className="nav-item active">
                        <Link className="nav-link" to='/ville'>Ville</Link>
                    </li>
                    <li className="nav-item active">
                        <Link className="nav-link" to='/about'>About</Link>
                    </li>
                    </ul>
                    <form className="form-inline my-2 my-lg-0">
                    <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"/>
                    <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    )
}
export default NavBar;