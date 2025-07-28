import React, { useState } from "react";

const CurrencyConvertor = () =>{
    const[rupees,setRupees] = useState("");
    const[euros,setEuros] = useState("");

    const handleSubmit = (e) =>{
        e.preventDefault();
        const euroValue = parseFloat(rupees) / 80;
        setEuros(euroValue.toFixed(2));
    }

    return(
        <div>
            <h2>Currency Convertor!!!</h2>
            <form onSubmit={handleSubmit}>
                <label>Amount : </label>
                <input type="number" value={rupees} onChange={(e)=>setRupees(e.target.value)} />
                <br/>
                <label>Currency : </label>
                <input type="string" />
                <br/>
                <button type="submit">Submit</button>
            </form>
            {euros && <h3>Converted Amount : {euros} Euros</h3>}
        </div>
    )
}

export default CurrencyConvertor;