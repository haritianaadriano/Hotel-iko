import NavBar from "../../controller/Navbar";
import { motion } from "framer-motion";
import Table from 'react-bootstrap/Table';
import axios from "axios";
import "./Hotel.css"
import { useEffect } from "react";
import { useState } from "react";


function HotelPage() {
    //variable sector
    const [hotel, setHotel] = useState([]);


    const getHotelData = async () => {
        try{
            const data = await axios.get("http://localhost:8080/hotels");
            console.log(data.data);
            setHotel(data.data);
        }catch (error){
            console.log(error)
        }
    }

    useEffect(() => {
        getHotelData()
    });

    return (
        <motion.div
            initial={{width: 0}}
            animate={{width: "100%"}}
            exit={{x: window.innerWidth}}
        >
            <NavBar />
            <h2>Hotels</h2>
            <div>
            <Table striped bordered hover>
                <thead className="th">
                    <tr>
                    <th>#</th>
                    <th>Localisation</th>
                    <th>Type Hotel</th>
                    <th>Name Hotel</th>
                    </tr>
                </thead>
                <tbody className="tb">
                {hotel.map((item)  => {
                    return(
        <tr>
          <td>{item.idHotel}</td>
          <td>{item.location}</td>
          <td>{item.typeHotel.hotelType}</td>
          <td>{item.nameHotel}</td>
        </tr>
                    )
                    })}
                    </tbody>
                </Table>
            </div>
        </motion.div>
    )
}
 export default HotelPage;