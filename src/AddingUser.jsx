import axios from 'axios';
import React , {useState} from 'react'
import { Link, useNavigate } from 'react-router-dom';

export default function AddingUser() {

  let navigate = useNavigate();
  const [user,setUser] = useState({
    name:"",
    username:"",
    email:""
  })

  const {name,username,email} = user;
  const OnInputChange = (e) => {
    setUser({...user,[e.target.name]:e.target.value})
  }

  const OnSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/details/add",user);
    navigate("/");
  }

  return (
    <div className='container'>
      <div className='row'>
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className='text-center mb-4'>Add User</h2>

              <form onSubmit={(e) => OnSubmit(e)}> 
              


            <div className='mb-3'>
                <label htmlFor='Name' className='form-label'> Name </label>
                <input type={"text"} className='form-control' placeholder='Enter your name' name='name' value={name} onChange={(e) => OnInputChange(e)}/>

            </div>
             <div className='mb-3'>
                <label htmlFor='Username' className='form-label'> Username </label>
                <input type={"text"} className='form-control' placeholder='Enter your username' name='username' value={username} onChange={(e) => OnInputChange(e)}/>

            </div>
             <div className='mb-3'>
                <label htmlFor='Email' className='form-label'> Email </label>
                <input type={"text"} className='form-control' placeholder='Enter your email' name='email' value={email} onChange={(e) => OnInputChange(e)}/>

            </div>

           
                <button type='submit' className='btn btn-outline-primary'>Submit</button>
             
                <Link to="/" className='btn btn-outline-danger mx-2'>Cancel</Link>
                </form>
            </div>
            </div>
    </div>
  )
}
