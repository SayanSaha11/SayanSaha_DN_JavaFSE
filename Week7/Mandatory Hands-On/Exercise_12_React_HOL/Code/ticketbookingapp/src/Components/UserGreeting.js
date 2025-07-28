import React from "react";

const UserGreeting = ({onLogout}) =>{

    return(
        <div>
            <h1>Welcome Back</h1>
            <button onClick={onLogout}>Logout</button>
        </div>
    )

}

export default UserGreeting;