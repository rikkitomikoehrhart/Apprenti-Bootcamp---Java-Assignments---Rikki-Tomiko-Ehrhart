import SpoilerButton from "./components/spoilerbutton/SpoilerButton";
import ColorButton1 from "./components/color1/ColorButton1";

function App() {
  function setBackgroundRed() {
    document.body.style.backgroundColor = "lightcoral";
  };

  function setBackgroundBlue() {
    document.body.style.backgroundColor = "lightblue";
  };

  function setBackgroundGreen() {
    document.body.style.backgroundColor = "lightgreen";
  };

  function setBackgroundColor(color) {
    document.body.style.backgroundColor = color;
  }

  return (
    <>
      <SpoilerButton />

      <h2>Choose a Background Color</h2>
      <ColorButton1 color="Red" handleColorSelect={() => setBackgroundColor("lightcoral")}/>
      <ColorButton1 color="Blue" handleColorSelect={() => setBackgroundColor("lightblue")}/>
      <ColorButton1 color="Green" handleColorSelect={() => setBackgroundColor("lightgreen")}/>
    </>
  )
}

export default App
