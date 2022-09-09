import NavBar from "../controller/Navbar";
import { motion } from "framer-motion";


function HotelPage() {
    return (
        <motion.div
        initial={{opacity: 0}}
        animate={{opacity: 1}}
        exit={{opacity: 0}}
        >
            <NavBar />
            Hotel
        </motion.div>
    )
}
 export default HotelPage;