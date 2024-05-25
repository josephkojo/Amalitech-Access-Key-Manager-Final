import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navbar from './Navbar';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
        <main className="form-signin w-100 m-auto">
          <Routes>
          
            
            

            
            
          </Routes>
        </main>
      </BrowserRouter>
    </div>
  );
}

export default App;
