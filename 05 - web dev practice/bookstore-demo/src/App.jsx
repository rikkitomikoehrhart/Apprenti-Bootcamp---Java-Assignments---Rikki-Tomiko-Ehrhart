import Book from './components/Book';
import { useState } from 'react';
import './App.css';

function App() {
  const [books, setBooks] = useState([
    { id: 1, title: "The Pragmatic Programmer", author: "Andy Hunt" },
    { id: 2, title: "Clean Code", author: "Robert C. Martin" },
    { id: 3, title: "Refactoring", author: "Martin Fowler" }
  ]);
  const [cartCount, setCartCount] = useState(0);

  const handleAddToCart = () => {
    setCartCount(cartCount + 1);
  };

  return (
    <div>
      <h1>Bookstore</h1>
      <p>Cart: {cartCount} item(s)</p>
      {books.map(({ id, title, author }) => (
        <Book key={id} title={title} author={author} onAddToCart={handleAddToCart} isFeatured={id === 1}/>
      ))}
    </div>
  );
}

export default App;
