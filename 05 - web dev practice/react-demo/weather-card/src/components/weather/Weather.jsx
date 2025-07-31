import "./Weather.css";


function Weather({city, temperature, condition="Sunny"}) {

    const weatherIcons = {
        'sunny': '/sun.png',
        'partly cloudy': '/sun-clouds.png',
        'cloudy': '/sun-clouds.png',
        'rainy': '/clouds-rain.png',
        'stormy': '/storm.png'
    };

    const iconSrc = weatherIcons[condition.toLowerCase()]

    function getTemperatureColor(temp) {
        if (temp >= 80) return 'hot';
        if (temp >= 65) return 'warm';
        if (temp >= 45) return 'cool';
        return 'cold';
    }


    return(
        <>
            <div className="weather-card">
                <h2>{city}</h2>
                <img src={iconSrc} alt={`${condition} weather icon`} className="weather-icon" />
                <div className={`temperature ${getTemperatureColor(temperature)}`}>
                    {temperature}
                </div>
                <p className="condition">{condition}</p>

            </div>
        </>
    );
}

export default Weather;