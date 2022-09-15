import NavBar from "../../controller/Navbar";
import { motion } from "framer-motion";
import axios from "axios";
import "./Home.css"
import { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import UserModal from "./modal";

function HomePage() {
    //variable sector
    const [hotelName, setHotelName] = useState("");
    const [typeLocation, setTypeLocation] = useState("");
    const [hotelLogo, setHotelLogo] = useState("");
    const [reserved, setReserved] =useState(false);
    const [price, setPrice] = useState(0);
    const [modalOpen, setModalOpen] = useState(false);

    const close = () => setModalOpen(false);
    const open = () => setModalOpen(true);

    const hotelRoomData = async (page) => {
        try{
            const response = await axios.get("http://localhost:8080/hotel-room/"+page);
            console.log(response);

            setHotelName(response.data.hotel);
            ////////////////////////////////////////////////

            setReserved(response.data.reserved);
            ////////////////////////////////////////////////
            setTypeLocation(response.data.typeLocation.locationType);

            ////////////////////////////////////////////////
            setHotelLogo(response.data.hotelLogo);
            ////////////////////////////////////////////////

            setPrice(response.data.locationPrice);            
        }catch(error){
            console.log(error);
        }
    }

    const handleClick = async (data) => {
        console.log(data.selected);

        let currentPage = data.selected +1;
        hotelRoomData(currentPage);
    }

    useEffect(() => {
        handleClick()
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
                                    <h3>reserved:<br/><span>{reserved.toString()}</span></h3>
                                    <h3>price:<br/><span>{price} Ar</span></h3>
                                </div>
                                <div className="reservation-btn">
                                    <motion.button
                                        whileHover={{scale: 1.1}}
                                        whileTap={{scale: 0.9}}
                                        onClick={() => (modalOpen ? close() : open())}
                                    >
                                        Book
                                    </motion.button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="next">
                        <ReactPaginate 
                            nextLabel={"next"}
                            previousLabel={"previous"}
                            onPageChange={handleClick}
                            pageCount={10}
                            containerClassName={"pagination"}
                            pageClassName={"page-item"}
                            pageLinkClassName={"page-link"}
                            previousLinkClassName={"page-link"}
                            previousClassName={"page-item"}
                            nextClassName={"page-item"}
                            nextLinkClassName={"page-link"}
                            breakClassName={"page-item"}
                            breakLinkClassName={"page-link"}
                        />
                    </div>
                </div>
                {modalOpen && <UserModal modalOpen={modalOpen} handleClose={close} />}
            </div>
        </motion.div>
    );
}

export default HomePage;