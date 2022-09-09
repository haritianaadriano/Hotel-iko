import NavBar from "../controller/Navbar";
import { motion } from "framer-motion";


function VillePage() {
    return (
        <motion.div
        initial={{opacity: 0}}
        animate={{opacity: 1}}
        exit={{opacity: 0}}
        >
            <NavBar />
            Ville
        </motion.div>
    )
}
 export default VillePage;