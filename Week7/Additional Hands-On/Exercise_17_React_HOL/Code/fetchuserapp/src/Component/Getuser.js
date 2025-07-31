import React from "react";

class Getuser extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            user:null
        };
    }

    async componentDidMount(){
        const url="https://api.randomuser.me/";
        const response = await fetch(url);
        const data = await response.json();
        this.setState({user:data.results[0]});
    }

    render(){
        const {user} = this.state;
        if(!user){
            return <p>Loading User...</p>
        }

        return(
            <div style={{textAlign:"center",marginTop:"50px"}}>
                <h1>Mr {user.name.first} {user.name.last}</h1>
                <img src={user.picture.large} alt="User"/>
            </div>
        );
    }
}

export default Getuser;