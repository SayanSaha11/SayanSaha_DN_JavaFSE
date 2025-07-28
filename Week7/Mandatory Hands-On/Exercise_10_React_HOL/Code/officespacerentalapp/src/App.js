
import './App.css';

function App() {

  const itemName = {
    Name: "DBS",
    Rent: 50000,
    Location: "Chennai",
    Image: "https://img.freepik.com/free-photo/luxury-modern-style-decorated-meeting-room_105762-1817.jpg"
  };

  let colors = [];
  if(itemName.Rent<=60000){
    colors.push("textRed");
  }else{
    colors.push("textGreen");
  }

  const element = "Office space"

  return (
    <div className="App">
      <h1>{element} , at Affordable Range</h1>
      <img src={itemName.Image} alt='Office Space' width="25%" height="25%"/>
      <h1>
        Name: {itemName.Name}
      </h1>
      <h3 className={colors}>
        Rent: Rs. {itemName.Rent}
      </h3>
      <h3>
        Address : {itemName.Location}
      </h3>
    </div>
  );
}

export default App;
