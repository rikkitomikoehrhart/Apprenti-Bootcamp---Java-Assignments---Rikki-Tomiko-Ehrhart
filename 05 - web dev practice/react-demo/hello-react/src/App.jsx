import writing from './assets/writing.jpg'

function App() {
  // This is where we put variables, functions and other things we need
  const todaysDate = new Date().toLocaleDateString();

  return (
    // jsx code gos here
    // fragment it will not be rendered
    <>
      <h1>Hello World</h1>
      <p>Today's date is: {todaysDate} </p>
      <img src="/samandrikki.jpg" alt="The Ehrharts" />
      <img src={writing} alt="The Ehrharts writing"/>
    </>
    
  );
}

export default App