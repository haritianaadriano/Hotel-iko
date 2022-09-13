import NavBar from "../../controller/Navbar";
import { motion } from "framer-motion";


function AboutPage() {
    return (
        <motion.div
            initial={{width: 0}}
            animate={{width: "100%"}}
            exit={{x: window.innerWidth}}
        >
            <NavBar />
            About
        </motion.div>
    )
}
 export default AboutPage;