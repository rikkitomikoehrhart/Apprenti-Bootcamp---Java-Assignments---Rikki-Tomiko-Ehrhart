import Weather from './components/weather/Weather'

function App() {
  return (
    <>
      <h1>Weather Forecast</h1>
      <div className="weather-grid">
        <Weather city="Miami" temperature={85}/>
        <Weather city="London" temperature={58} condition="Cloudy" />
        <Weather city="Seattle" temperature={65} condition="Rainy" />
        <Weather city="Denver" temperature={45} condition="Stormy" />
      </div>
    </>
  )
}

export default App
