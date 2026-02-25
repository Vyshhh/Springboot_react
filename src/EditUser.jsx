import axios from 'axios';
import React , {useEffect, useState} from 'react'
import { Link, useNavigate ,useParams } from 'react-router-dom';

export default function EditUser() {

  let navigate = useNavigate();
  const [user,setUser] = useState({
    name:"",
    username:"",
    email:""
  })
const { id } = useParams();
  const {name,username,email} = user;

  const OnInputChange = (e) => {
    setUser({...user,[e.target.name]:e.target.value})
  }

  useEffect(() => {
    loadUser();
  },[])
  const OnSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8080/details/name/${id}`,user);
    navigate("/");
  }

  const loadUser = async () => {
   const result = await axios.get(`http://localhost:8080/details/${id}`);
    setUser(result.data);
  }

  return (
    <div className='container'>
      <div className='row'>
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className='text-center mb-4'>Edit User</h2>

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
