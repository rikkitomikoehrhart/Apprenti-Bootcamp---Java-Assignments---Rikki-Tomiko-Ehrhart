import About from "./routes/About";
import Contact from "./routes/Contact";
import Home from "./routes/Home";
import NavBar from "./components/NavBar/NavBar";

function App() {
  return (
    <div className="App">
      <NavBar />

      {/* TODO: Use NavBar component to navigate to the routes */}
      <Home />
      <About />
      <Contact />
    </div>
  );
}

export default App;
