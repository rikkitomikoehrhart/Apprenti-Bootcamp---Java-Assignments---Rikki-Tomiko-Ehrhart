import RectangleCalculatorButton from "./assets/components/RectangleCaculatorButton"
import RectangleCalculatorLive from "./assets/components/RectangleCalculatorLive"

function App() {

  return (
    <>
    <div className="container mt-4">
      <h1 className="text-center mb-5">Rectangle Area Calculator</h1>
      <div className="row">
        <div className="col-md-6">
          <RectangleCalculatorButton /> 
        </div>
        <div className="col-md-6">
          <RectangleCalculatorLive /> 
        </div>
      </div>

    </div>
           
    </>
  )
}

export default App
