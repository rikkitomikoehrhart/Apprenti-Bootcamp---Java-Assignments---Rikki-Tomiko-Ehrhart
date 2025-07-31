import './SpoilerButton.css';

function SpoilerButton() {
    function handleSpoilerFunction() {
        const spoilerEvent = document.getElementById("spoiler");
        spoilerEvent.style.display = 'block';
    }


    return (
        <div class="spoiler-container">
            <p>The movie's plot twist is...</p>
            <button className="spoiler-button" onClick={handleSpoilerFunction}>Show Spoiler</button>
            <p id="spoiler" className='spoiler-text' style={{display: 'none'}}>
                Darth Vader is Luke's Father!
            </p>
        </div>
    );
};

export default SpoilerButton;