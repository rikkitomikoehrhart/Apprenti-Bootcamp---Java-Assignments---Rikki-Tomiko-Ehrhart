import todo from "@/types/todo";

function Item({ todo }) {
  return <li>${todo.text}</li>;
}

Item.propTypes = {
  todo,
};

export default Item;
