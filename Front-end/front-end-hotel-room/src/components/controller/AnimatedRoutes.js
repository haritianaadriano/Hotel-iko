import React from "react";
import { Route, Routes , useLocation } from 'react-router-dom';
import AboutPage from "../pages/AboutPage";
import HomePage from "../pages/HomePage";
import HotelPage from "../pages/HotelPage";
import VillePage from "../pages/VillePage";

import { AnimatePresence } from "framer-motion";

const AnimatedRoutes = () => {
  const location = useLocation();
    return(
      <AnimatePresence>
        <Routes location={location} key={location.pathname}>
          <Route path='/' element={<HomePage />}/>
          <Route path='/hotel' element={<HotelPage />}/>
          <Route path='/ville' element={<VillePage />}/>
          <Route path='/about' element={<AboutPage />}/>
        </Routes>
      </AnimatePresence>
    );
}

export default AnimatedRoutes;