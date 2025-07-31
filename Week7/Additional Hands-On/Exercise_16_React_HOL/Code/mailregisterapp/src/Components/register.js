import React, { useState } from "react";
import '../Styles/register.css'

const Register = () =>{
    const[formdata,setFormdata] = useState({
        name:"",
        email:"",
        password:"",
    })

    const handleChange = (e) =>{
        setFormdata({...formdata,[e.target.name]:e.target.value});
    };

    const validateForm = (e) =>{
        if(formdata.name.trim().length<5){
            alert("Full Name should be atleast 5 characters long!")
            return false;
        }
        if(!formdata.email.includes('@')){
            alert("Email must include : @")
            return false;
        }
        if(formdata.password.length<8){
            alert("Password should contain atleast 8 characters!")
            return false;
        }
        return true;
    }

    const handleSubmit = (e) =>{
        e.preventDefault();
        if(validateForm()){
            alert("Registration successful!");
            setFormdata({name:"",email:"",password:""});
        }
    }
    return(
        <div className="registerForm">
            <h1>Register Here!!!</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Name: </label>
                    <input type="text" name="name" value={formdata.name} onChange={handleChange}/>
                </div>
                <div>
                    <label>Email: </label>
                    <input type="text" name="email" value={formdata.email} onChange={handleChange}/>
                </div>
                <div>
                    <label>Password: </label>
                    <input type="text" name="password" value={formdata.password} onChange={handleChange}/>
                </div>
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}

export default Register;