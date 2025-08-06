import React, { useState } from "react";

function WeatherApp() {
    const [city, setCity] = useState("");
    const [weather, setWeather] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const API_KEY = import.meta.env.VITE_API_KEY;

    // Debug: Log the URL and API key
    console.log('API Key:', API_KEY);
    console.log('Fetching URL:', `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${API_KEY}&units=metric`);
    

    const fetchWeather = () => {
        setLoading(true);
        setError(null);
        setWeather(null);

        fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${API_KEY}&units=metric`)
            .then((res) => {
                if (!res.ok) throw new Error("City not found.");
                return res.json();
            })
            .then((data) => {
                setWeather(data);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    };
        
    return (
        <div style={{ padding: "20px", maxWidth: "400px", margin: "auto" }}>
            <h2>Weather App</h2>
            <input
                type="text"
                placeholder="Enter city"
                value={city}
                onChange={(e) => setCity(e.target.value)}
                style={{ width: "100%", padding: "8px" }}
            />
            <button onClick={fetchWeather} style={{ marginTop: "10px", padding: "8px", width: "100%" }}>
                Get Weather
            </button>
    
            {loading && <p>Loading...</p>}
            {error && <p style={{ color: "red" }}>{error}</p>}
            {weather && (
                <div style={{ marginTop: "20px" }}>
                    <h3>{weather.name}</h3>
                    <p>{weather.weather[0].description}</p>
                    <p>Temperature: {weather.main.temp}°C</p>
                    <p>Humidity: {weather.main.humidity}%</p>
                </div>
            )}
        </div>
    );
}
export default WeatherApp;