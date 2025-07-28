import React from "react";

const IndianPlayers = () =>{
    const players = ["Sachin1","Dhoni2","Virat3","Rohit4","Yuvraj5","Raina6"];
    
    const oddPlayers = players.filter((_,index)=> index%2 === 0);
    const evenPlayers = players.filter((_,index)=> index%2 !==0);

    const T20Players = ["First Player","Second Player","Third Player"];
    const RanjiPlayers = ["Fourth Player","Fifth Player","Sixth Player"];
    const mergedPlayers = [...T20Players,...RanjiPlayers];

    const getOrdinal = (index) =>{
        const ordinals = ["First","Second","Third","Fourth","Fifth","Sixth"];
        return ordinals[index];
    }

    return(
        <div>
            <h2>Odd Players</h2>
            {oddPlayers.map((player,index)=>(
                <li key={index}>
                    {getOrdinal(index*2)} : {player}
                </li>
            ))}
            <hr/>
            <h2>Even Players</h2>
            {evenPlayers.map((player,index)=>(
                <li key={index}>
                    {getOrdinal(index*2 + 1)} : {player}
                </li>
            ))}
            <hr/>
            <h2>List of Indian Players Merged:</h2>
            {mergedPlayers.map((player,index)=>(
                <li key={index}>
                    Mr. {player}
                </li>
            ))}
        </div>
    )
}

export default IndianPlayers;