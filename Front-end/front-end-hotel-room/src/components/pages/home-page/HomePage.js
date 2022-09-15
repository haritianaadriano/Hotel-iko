import NavBar from "../../controller/Navbar";
import { motion } from "framer-motion";
import image from "../../assets/tana/hotel_radisson_tana_logo.jpg";
import axios from "axios";
import "./Home.css"
import { useEffect, useState } from "react";


function HomePage() {
    //variable sector
    const [hotelName, setHotelName] = useState("");
    const [typeHotelRoom, setTypeHotelRoom] = useState("");
    const [typeHotel, setTypeHotel] = useState("");
    const [hotelLogo, setHotelLogo] = useState("");
    const [price, setPrice] = useState(0);

    const hotelRoomData = async () => {
        try{
            const response = await axios.get("http://localhost:8080/hotel-rooms");
            console.log(response);
        }catch(error){
            console.log(error);
        }
    }

    useEffect(() => {
        hotelRoomData()
    }, [])

    return (
        <motion.div
            initial={{width: 0}}
            animate={{width: "100%"}}
            exit={{x: window.innerWidth}}
        >
            <NavBar />
            <div className="body">
            <h2 className="title">All lists of hotel-room</h2>
                <div className="section">
                    <div className="card">
                        <div className="imageBx">
                            <img src={image} alt="carlton"/>
                        </div>
                        <div className="content">
                            <div className="details">
                                <h2>Radisson<br/><span>chambre avec terasse</span></h2>
                                <div className="data">
                                    <h3>location type:<br/><span>PRENIUM</span></h3>
                                    <h3>hotel-room type:<br/><span>PRENIUM</span></h3>
                                    <h3>price:<br/><span>275 000 Ar</span></h3>
                                </div>
                                <div className="reservation-btn">
                                    <button>Book</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </motion.div>
    );
}

export default HomePage;