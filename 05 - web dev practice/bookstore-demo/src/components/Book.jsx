function Book({ title, author, onAddToCart, isFeatured }) {
    
    return (
        <div className={`book ${isFeatured ? "featured" : ""}`}>
            <h3>{title}</h3>
            <p>by {author}</p>
            <button onClick={onAddToCart}>Add to Cart</button>
        </div>
    );
}

export default Book;