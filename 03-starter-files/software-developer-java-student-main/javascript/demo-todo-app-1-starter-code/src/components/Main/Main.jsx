import apiService from "@/api.Service";
import React from "react";
import Form from "./Form/Form";
import List from "./List/List";

function reducer(state, action) {
  switch (action.type) {
    case "INIT":
      return action.payload;
    case "CREATE":
      return [
        ...state,
        { id: state.length + 1, text: action.payload, completed: false },
      ];
    case "UPDATE":
      return state.map((item) => {
        if (item.id === action.payload.id) {
          return action.payload;
        }

        return item;
      });
    case "TOGGLE":
      return state.map((item) => {
        if (item.id === action.payload.id) {
          return {
            ...item,
            completed: !item.completed,
          };
        }

        return item;
      });
    case "DELETE":
      return state.filter((item) => item.id !== action.payload.id);
    default:
      return state;
  }
}

function Main() {
  const [state, dispatch] = React.useReducer(reducer, []);

  React.useEffect(() => {
    apiService.index().then((todos) => {
      dispatch({ type: "INIT", payload: todos });
    });
  }, []);

  return (
    <>
      <Form
        submitHandler={(e) => {
          const form = e.target;
          const val = form.elements[0].value;
          e.preventDefault();
          apiService
            .create({ id: state.length + 1, text: val, completed: false })
            .then(() => {
              dispatch({ type: "CREATE", payload: val });
            });
          form.reset();
        }}
      />
      <List todos={state} />
    </>
  );
}

export default Main;
