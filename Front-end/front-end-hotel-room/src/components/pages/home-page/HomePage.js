import NavBar from "../../controller/Navbar";
import { motion } from "framer-motion";
import axios from "axios";
import "./Home.css"
import { useEffect, useState } from "react";


function HomePage() {
    //variable sector
    const [hotelName, setHotelName] = useState("");
    const [typeLocation, setTypeLocation] = useState("");
    const [hotelLogo, setHotelLogo] = useState("");
    const [reserved, setReserved] = useState(true);
    const [price, setPrice] = useState(0);
    const [page, setPage] = useState(0);
    let test = 0;

    function pagination(number){
        number ++;
        setPage(number);
    }

    const hotelRoomData = async () => {
        try{
            const response = await axios.get("http://localhost:8080/hotel-room/"+page);

            setReserved(response.data[page].reserved)
            console.log(response.data[page].reserved);
            console.log(reserved);

            setHotelName(response.data[page].hotel);
            console.log(response.data[page].hotel);
            console.log(hotelName);
            ////////////////////////////////////////////////
            setTypeLocation(response.data[page].typeLocation.locationType);
            console.log(response.data[page].typeLocation.locationType);
            console.log(typeLocation);

            ////////////////////////////////////////////////
            setHotelLogo(response.data[page].hotelLogo);
            console.log(response.data[page].hotelLogo);
            console.log(hotelLogo);
            ////////////////////////////////////////////////

            setPrice(response.data[page].locationPrice);
            console.log(response.data[page].locationPrice);
            console.log(price);
            
        }catch(error){
            console.log(error);
        }
    }

    useEffect(() => {
        hotelRoomData()
    })

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
                            <img src={"http://localhost:8080/image/"+hotelLogo} alt="carlton"/>
                        </div>
                        <div className="content">
                            <div className="details">
                                <h2>{hotelName}<br/><span>chambre avec terasse</span></h2>
                                <div className="data">
                                    <h3>location type:<br/><span>{typeLocation}</span></h3>
                                    <h3>hotel-room type:<br/><span>PRENIUM</span></h3>
                                    <h3>price:<br/><span>{price} Ar</span></h3>
                                </div>
                                <div className="reservation-btn">
                                    <button>Book</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="next">
                        <button className="button-next" onClick={pagination(test)}>View next</button>
                    </div>
                </div>
            </div>
        </motion.div>
    );
}

export default HomePage;