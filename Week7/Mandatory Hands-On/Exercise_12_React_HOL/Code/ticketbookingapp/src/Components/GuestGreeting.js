import React from "react";

const GuestGreeting = ({onLogin}) =>{

    return(
        <div>
            <h1>Please Sign Up</h1>
            <button onClick={onLogin}>Login</button>
        </div>
    )
}

export default GuestGreeting;