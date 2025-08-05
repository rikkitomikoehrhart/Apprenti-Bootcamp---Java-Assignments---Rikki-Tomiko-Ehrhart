import PropTypes from "prop-types";

function Button({ className, text, isDisabled, clickHandler }) {
  return (
    <button
      className={isDisabled ? null : className}
      disabled={isDisabled}
      onClick={clickHandler}
    >
      {text}
    </button>
  );
}

Button.propTypes = {
  className: PropTypes.string,
  clickHandler: PropTypes.func,
  isDisabled: PropTypes.bool,
  text: PropTypes.string.isRequired,
};

Button.defaultProps = {
  isDisabled: false,
};

export default Button;
