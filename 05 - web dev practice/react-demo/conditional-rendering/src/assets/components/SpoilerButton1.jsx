import { useState } from "react";


function SpoilerButton1(){
    const [isVisible, setIsVisible] = useState(false);

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
                {
                    isVisible ? (
                        <p className="spoiler-text">Darth Vader is Luke's Father</p>
                    ) : <p>Click the button to review the spoiler</p>
                }
            </div>
        </>
    );
};

export default SpoilerButton1;