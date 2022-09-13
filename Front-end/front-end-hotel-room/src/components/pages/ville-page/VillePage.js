import NavBar from "../../controller/Navbar";
import { motion } from "framer-motion";


function VillePage() {
    return (
        <motion.div
            initial={{width: 0}}
            animate={{width: "100%"}}
            exit={{x: window.innerWidth}}
        >
            <NavBar />
            Ville
        </motion.div>
    )
}
 export default VillePage;