import PropTypes from "prop-types";

function Form({ submitHandler, children }) {
  return <form onSubmit={submitHandler}>{children}</form>;
}

Form.propTypes = {
  submitHandler: PropTypes.func.isRequired,
  children: PropTypes.node.isRequired,
};

export default Form;
