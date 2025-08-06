import React from "react";

function Sink({ isRunning }) {
    return (
        <div style={{ border: "1px solid #ccc", padding: "10px"}}>
            <h2>Sink</h2>
            <p>Water: {isRunning? "Running" : "Off"}</p>
        </div>
    );
}

export default Sink;