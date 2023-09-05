import React from 'react';

import './index.css';
import reportWebVitals from './reportWebVitals';
import User from './components/User/User';
import App from './App';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import { createRoot } from "react-dom/client";

const root = createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/user" element={<User />} />
        
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);

reportWebVitals();
