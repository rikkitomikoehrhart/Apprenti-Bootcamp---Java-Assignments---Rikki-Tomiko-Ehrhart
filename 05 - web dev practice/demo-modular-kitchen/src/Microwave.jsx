import React, { useState } from "react";

function Microwave({ initialTime }) {
    const [timeLeft, setTimeLeft] = useState(initialTime);

    return (
        <div style={{border: "1px solid #ccc", padding: "10px"}}>
            <h2>Microwave</h2>
            <p>Time Remaining: {timeLeft} seconds</p>
            <button onClick={() => setTimeLeft(timeLeft-1)} disabled={timeLeft <= 0}>
                Heat 1 second
            </button>
            <button onClick={() => setTimeLeft(initialTime)}>
                Reset
            </button>
        </div>
    );
}

export default Microwave;