import NavBar from "../controller/Navbar";
import { motion } from "framer-motion";


function AboutPage() {
    return (
        <motion.div
        initial={{opacity: 0}}
        animate={{opacity: 1}}
        exit={{opacity: 0}}
        >
            <NavBar />
            About
        </motion.div>
    )
}
 export default AboutPage;