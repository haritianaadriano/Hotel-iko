import { motion } from "framer-motion";
import Backdrop from "../backdrop";
import "./index.css"

const dropIn = {
    hidden: {
        y: "-100vh"
    },
    visible: {
        y: "0",
        opacity: 1,
        transition: {
            duration: 0.1,
            type: "spring",
            damping: 100,
            stiffness: 500,
        }
    },
    exit: {
        y: "100vh",
        opacity: 0
    }
};

const UserModal = ({handleClose}) => {
    return(
        <Backdrop onClick={handleClose}>
            <motion.div
                onClick={(e) => e.stopPropagation}
                className="modal"
                variants={dropIn}
                initial="hidden"
                animate="visible"
                exit="exit"
            >
                <form>
                    <h3>Enter this formular</h3>
                    <table>
                        <tr>
                            <td>Name: </td><td><input type="text"/></td>
                        </tr>
                        <tr>
                            <td>Adress: </td><td><input type="text"/></td>
                        </tr>
                        <tr>
                            <td>Email: </td><td><input type="email"/></td>
                        </tr>
                        <tr>
                            <td>N° telephone: </td><td><input type="tel"/></td>
                        </tr>
                        <tr>
                            <td colSpan="2"><motion.button 
                                whileHover={{scale: 1.1}}
                                whileTap={{scale: 0.9}}>
                                    send
                                </motion.button></td>
                        </tr>
                    </table>
                </form>
            </motion.div>

        </Backdrop>
    )
}
export default UserModal;