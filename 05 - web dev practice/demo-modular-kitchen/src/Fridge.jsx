import React, { useState } from "react";

function Fridge({ temperature }) {
    const [isOpen, setIsOpen] = useState(false);

    return (
        <div style={{ border: "1px solid #ccc", padding: "10px"}}>
            <h2>Fridge</h2>
            <p>Temperature: {temperature}°C</p>
            <p>Status: {isOpen ? "Door Open" : "Door Closed"}</p>
            <button onClick={() => setIsOpen(!isOpen)}>
                {isOpen ? "Close Door" : "Open Door"}
            </button>
        </div>
    );
}

export default Fridge;