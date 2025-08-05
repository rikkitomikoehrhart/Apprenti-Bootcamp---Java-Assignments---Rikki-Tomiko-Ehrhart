import todo from "@/types/todo";
import PropTypes from "prop-types";
import Item from "./Item";

function List({ todos }) {
  return (
    <ol>
      {todos.map((todo) => (
        <Item key={todo.id} todo={todo} />
      ))}
    </ol>
  );
}

List.propTypes = {
  todos: PropTypes.arrayOf(todo),
};

export default List;
