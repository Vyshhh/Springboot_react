import logo from './logo.svg';
import './App.css';
import Home from './Home';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import Navbar from './Navbar';
import {BrowserRouter as Router,Routes,Route} from "react-router-dom"
import AddingUser from './AddingUser';
import EditUser from './EditUser';

function App() {
  return (
    <div className="App">
     < Router>
     < Navbar/>

    < Routes>
    <Route exact path="/" element={<Home/>}/>
    <Route exact  path="/adduser" element={<AddingUser/>}/>
    <Route  path="/edituser/:id" element={<EditUser/>}/>
    </Routes>

    </Router>
    

    </div>
  );
}

export default App;
