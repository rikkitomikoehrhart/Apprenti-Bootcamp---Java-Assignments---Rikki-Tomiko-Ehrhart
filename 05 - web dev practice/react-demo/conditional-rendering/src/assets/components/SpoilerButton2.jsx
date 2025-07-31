import { useState } from "react";

function SpoilerButton2(){
    const [isVisible, setIsVisible] = useState(false);
    const spoilerMessage = (
        <p className="spoiler-text">Darth Vader is Luke's Father</p>
    );

    function handleSpoilerClick() {
        setIsVisible(!isVisible);
    }

    return (
        <>
            <div className="spoiler-container">
                <p>The moive's plot twist is...</p>
                <button className="spoiler-button"
                        onClick={handleSpoilerClick}>
                            Show Spoiler
                        </button>
                {isVisible && spoilerMessage}
            </div>
        </>
    );
};

export default SpoilerButton2;