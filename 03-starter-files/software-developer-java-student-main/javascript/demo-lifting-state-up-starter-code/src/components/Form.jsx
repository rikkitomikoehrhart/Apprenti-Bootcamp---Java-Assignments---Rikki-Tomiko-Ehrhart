import React from "react";

export default function Form() {
  const [inputName, setInputName] = React.useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(inputName);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="name">Name:</label>
      <input
        type="text"
        name="name"
        id="name"
        value={inputName}
        onChange={(event) => setInputName(event.target.value)}
        placeholder="Enter your name"
        className="rounded border border-gray-400 p-2"
      />
      <button
        type="submit"
        className="rounded bg-green-500 px-4 py-2 text-white"
      >
        Submit
      </button>
    </form>
  );
}
