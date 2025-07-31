import React, { useState } from "react";
import '../Styles/ComplaintRegister.css'

const ComplaintRegister = () =>{
    
    const[name,setName] = useState("");
    const[complaint,setComplaint] = useState("");
    const[id,setId] = useState(0);

    const handlesubmit = (e) =>{
        e.preventDefault();
        if(!name || !complaint){
            alert("Please enter both the fields.");
            return;
        }
        var msg = "Thanks "+name+"\nYour Complaint was submitted.\nTransaction ID is: "+id;
        setId(prev=>prev+1);
        alert(msg);
    }

    return(
        <div className="container">
            <h1>Register your complaints here!!!</h1>
            <form onSubmit={handlesubmit}>
                <div>
                    <label>Name:</label>
                    <input className="inputname" type="text" value={name} onChange={(e)=>setName(e.target.value)}/>
                </div>
                <div>
                    <label>Complaint:</label>
                    <textarea type="text" value={complaint} onChange={(e)=>setComplaint(e.target.value)}/>
                </div>
                <button type="submit">Submit</button>
            </form>
        </div>
    )
}

export default ComplaintRegister;