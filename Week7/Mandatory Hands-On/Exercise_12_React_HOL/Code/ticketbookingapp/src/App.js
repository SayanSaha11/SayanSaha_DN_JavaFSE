import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import UserGreeting from './Components/UserGreeting';
import GuestGreeting from './Components/GuestGreeting';

function App() {

  const[isloggedIn,setIsLoggedin] = useState(false);

  const handleLogin = () =>{
    setIsLoggedin(true);
  }

  const handleLogout = () =>{
    setIsLoggedin(false);
  }

  return (
    <div className="App">
      {isloggedIn ? (
        <UserGreeting onLogout={handleLogout}/>
      ) : (
        <GuestGreeting onLogin={handleLogin}/>
      )}
    </div>
  );
}

export default App;
