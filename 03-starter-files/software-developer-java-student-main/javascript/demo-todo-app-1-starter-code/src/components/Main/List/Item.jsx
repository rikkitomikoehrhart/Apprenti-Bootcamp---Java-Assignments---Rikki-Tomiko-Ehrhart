import todo from "@/types/todo";
import Button from "@components/Button";

function Item({ todo }) {
  return (
    <li>
      {todo.text}
      <input type="checkbox" className={todo.completed ? "completed" : null} />
      <Button className="button-del" text="Delete" />
    </li>
  );
}

Item.propTypes = {
  todo: todo.isRequired,
};

export default Item;
