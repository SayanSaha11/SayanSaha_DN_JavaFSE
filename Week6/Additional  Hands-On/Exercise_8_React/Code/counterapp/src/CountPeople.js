import React from "react";

class CountPeople extends React.Component{
    constructor(){
        super()
        this.state= {
            entrycount:0,
            exitcount:0,
            c:0
        };
    }
    updateEntry = () =>{
        this.setState((prevState,props)=>({
            entrycount:prevState.entrycount+1,
        }));
    };
    updateExit = () => {
        const { entrycount, exitcount } = this.state;

        if (exitcount + 1 > entrycount) {
        alert("Something is wrong! Exit count cannot exceed entry count.");
        return;
        }

        this.setState({
        exitcount: exitcount + 1,
        });
    };
    render(){
        return(
            <div className="mypage">
                <div className="mybox1">
                    <button onClick={this.updateEntry}>Entry</button>
                    {this.state.entrycount} People Entered!!!
                </div>
                <div className="mybox2">
                    <button onClick={this.updateExit}>Exit</button>
                    {this.state.exitcount} People Left!!!
                </div>
            </div>
        );
    }
}

export default CountPeople;