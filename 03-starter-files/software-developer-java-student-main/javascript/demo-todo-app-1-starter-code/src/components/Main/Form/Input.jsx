import PropTypes from "prop-types";

function Input({ changeHandler }) {
  return (
    <div>
      <label htmlFor="todo">What needs to be done?</label>
      <input
        type="text"
        placeholder="What needs to be done?"
        id="todo"
        onChange={changeHandler}
      />
    </div>
  );
}

Input.propTypes = {
  changeHandler: PropTypes.func,
};

export default Input;
