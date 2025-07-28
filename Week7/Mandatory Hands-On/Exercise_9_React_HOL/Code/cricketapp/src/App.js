import logo from './logo.svg';
import './App.css';
import ListOfPlayers from './Components/ListofPlayers';
import IndianPlayers from './Components/IndianPlayers';

function App() {
  const flag = false;
  return (
    <div className="App">
      {flag? <ListOfPlayers/> : <IndianPlayers/>}
    </div>
  );
}

export default App;
