import NavBar from "../../controller/Navbar";
import { motion } from "framer-motion";


function HotelPage() {
    return (
        <motion.div
            initial={{width: 0}}
            animate={{width: "100%"}}
            exit={{x: window.innerWidth}}
        >
            <NavBar />
            Hotel
        </motion.div>
    )
}
 export default HotelPage;