import React from 'react';
import logo from './logo.svg';
import './App.css';
import {Signup, WrappedRegistrationForm} from './signup';
import { BrowserRouter } from 'react-router-dom';


function App() {
  return (
      <BrowserRouter>
    <div className="App">
        <WrappedRegistrationForm/>
    </div>
      </BrowserRouter>
  );
}

export default App;
