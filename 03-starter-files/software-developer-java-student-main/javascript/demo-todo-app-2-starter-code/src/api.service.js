import ky from "ky";

const BASE_URL = "http://localhost:3000/todos";

export default {
  index() {
    return ky.get(BASE_URL).json();
  },
  create(todo) {
    return ky.post(BASE_URL, { json: todo }).json();
  },
  update(todo) {
    return ky.patch(`${BASE_URL}/${todo.id}`, { json: todo }).json();
  },
  delete(todo) {
    return ky.delete(`${BASE_URL}/${todo.id}`).json();
  },
};
