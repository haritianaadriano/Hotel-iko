import React from "react";
import { Route, Routes , useLocation } from 'react-router-dom';
import AboutPage from "../pages/about-page/AboutPage";
import HomePage from "../pages/home-page/HomePage";
import HotelPage from "../pages/hotel-page/HotelPage";
import VillePage from "../pages/ville-page/VillePage";

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