
function Button({ btnText, idText, clickHandler }) {

    return (
        <button id={idText} onClick={clickHandler}>{btnText}</button>
    );
}

export default Button;