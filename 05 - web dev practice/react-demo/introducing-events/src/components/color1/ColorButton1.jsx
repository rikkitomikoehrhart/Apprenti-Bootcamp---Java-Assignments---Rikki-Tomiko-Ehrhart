function ColorButton1({color, handleColorSelect}) {
    return(
        <>
            <button onClick={handleColorSelect}>
                {color}
            </button>
        </>
    );
};

export default ColorButton1;