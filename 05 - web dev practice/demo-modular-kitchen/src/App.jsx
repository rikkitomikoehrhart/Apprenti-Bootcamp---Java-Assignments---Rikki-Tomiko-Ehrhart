import React from "react";
import Fridge from "./Fridge";
import Microwave from "./Microwave";
import Sink from "./Sink";

function App() {
  return (
    <div>
      <h1>My Modular Kitchen</h1>
      <Fridge temperature={4} />
      <Microwave initialTime={30} />
      <Sink isRunning={false} />
    </div>
  );
}

export default App;