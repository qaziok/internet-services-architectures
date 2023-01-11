import './App.css';
import React from "react";
import {BrowserRouter as Router, Routes, Route}
    from 'react-router-dom';
import Directors from "./pages/directors";
import Home from "./pages";
import Navbar from "./components/Navbar";
import DirectorView from "./pages/director_view";
import DirectorForm from "./pages/director_form";
import MovieForm from "./pages/movie_form";
import MovieView from "./pages/movie_view";
import NotFound from "./pages/not_found";

function App() {
  return (
    <Router>
        <Navbar />
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/directors" element={<Directors/>}/>
            <Route path="/director" element={<DirectorView/>}/>
            <Route path="/director/edit" element={<DirectorForm/>}/>
            <Route path="/director/new" element={<DirectorForm/>}/>
            <Route path="/movie/edit" element={<MovieForm/>}/>
            <Route path="/director/movie/new" element={<MovieForm/>}/>
            <Route path="/movie" element={<MovieView/>}/>
        </Routes>
    </Router>
  );
}

export default App;
