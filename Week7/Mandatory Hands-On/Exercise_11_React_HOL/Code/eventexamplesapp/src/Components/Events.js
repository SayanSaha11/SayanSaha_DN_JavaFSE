import React, { useState } from "react";

const Events = () => {
    const [count,setCount] = useState(0);

    const sayHello = () =>{
        alert("Hello! Member1")
    }

    const increment = () =>{
        setCount(prev => prev + 1);
        sayHello();
    }

    const decrement = () =>{
        setCount(prev => prev - 1);
    }

    const sayWelcome = () =>{
        alert("Welcome!");
    }

    const sayClick = () =>{
        alert("I was clicked");
    }

    return(
        <div>
            <h2>Count : {count}</h2>
            <button onClick={increment}>Increment</button>
            <br/>
            <button onClick={decrement}>Decrement</button>
            <br/>
            <button onClick={sayWelcome}>Say Welcome</button>
            <br/>
            <button onClick={sayClick}>Click on me</button>
            <br/>
        </div>
    )
}

export default Events;