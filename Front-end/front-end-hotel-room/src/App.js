import './App.css';
import React from "react";
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HomePage from './components/pages/HomePage';
import HotelPage from './components/pages/HotelPage';
import VillePage from './components/pages/VillePage';
import AboutPage from './components/pages/AboutPage';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<HomePage />}/>
          <Route path='/hotel' element={<HotelPage />}/>
          <Route path='/ville' element={<VillePage />}/>
          <Route path='/about' element={<AboutPage />}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
