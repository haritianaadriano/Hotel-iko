import NavBar from "../controller/Navbar";
import { motion } from "framer-motion";


function HomePage() {
    return (
        <motion.div
            initial={{opacity: 0}}
            animate={{opacity: 1}}
            exit={{opacity: 0}}
        >
            <NavBar />
            Home
        </motion.div>
    );
}

export default HomePage;