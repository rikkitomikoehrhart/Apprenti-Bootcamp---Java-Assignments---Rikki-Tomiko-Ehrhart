import PropTypes from "prop-types";
import todo from "@/types/todo";

function List({ todos }) {
  return (
    <ol>
      {todos.map((todo) => (
        <li key={todo.id}>{todo.text}</li>
      ))}
    </ol>
  );
}

List.propTypes = {
  todos: PropTypes.arrayOf(todo),
};

export default List;
