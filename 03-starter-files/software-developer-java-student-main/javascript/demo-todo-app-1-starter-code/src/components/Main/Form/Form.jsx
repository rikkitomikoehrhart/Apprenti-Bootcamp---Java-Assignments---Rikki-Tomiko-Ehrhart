import Button from "@components/Button";
import PropTypes from "prop-types";
import React from "react";
import Input from "./Input";

function Form({ submitHandler }) {
  const [isDisabled, setIsDisabled] = React.useState(true);

  function handleChange(event) {
    if (event.target.value.length > 0) {
      setIsDisabled(false);
    } else {
      setIsDisabled(true);
    }
  }

  return (
    <form onSubmit={submitHandler}>
      <Input changeHandler={handleChange} />{" "}
      <Button text="Add" className="button-add" isDisabled={isDisabled} />
    </form>
  );
}

Form.propTypes = {
  submitHandler: PropTypes.func.isRequired,
};

export default Form;
