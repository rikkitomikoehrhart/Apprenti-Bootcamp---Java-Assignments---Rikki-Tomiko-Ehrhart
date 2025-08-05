import apiService from "@/api.service";
import React from "react";
import List from "./List/List";

function reducer(state, action) {
  switch (action.type) {
    case "INIT":
      return action.payload;
    case "CREATE":
      return [...state, action.payload];
    case "UPDATE":
      return state.map((item) => {
        if (item.id === action.payload.id) {
          return action.payload;
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

  return <List todos={state} />;
}

export default Main;
