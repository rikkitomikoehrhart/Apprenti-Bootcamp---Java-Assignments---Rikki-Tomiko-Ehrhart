import './App.css'
import Header from './components/Header'
import Profile from './components/Profile'
import { useState } from "react";
import Stats from './components/Stats';


function App() {
  let name = "Luna Wells";
  let job = "Frontend Developer";
  let startAge = 28
  let followers = 1204
  let posts = 56

  const [age, setAge] = useState(startAge);

  function incrementAgeHandler() {
    setAge(age + 1);
  }

  return (
    <>
      <Header />

      <main>
        <Profile name={name} job={job} age={age} btnClickHandler={incrementAgeHandler} />
      
        <Stats followers={followers} posts={posts} />
      </main>
    </>
  )
}

export default App
