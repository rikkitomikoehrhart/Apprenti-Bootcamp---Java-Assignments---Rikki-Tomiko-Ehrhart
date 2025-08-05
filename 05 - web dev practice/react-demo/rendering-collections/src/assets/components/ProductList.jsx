import { useState } from "react";
import { products } from "../data/sampleData";

function ProductList() {
    const [nameFilter, setNameFilter] = useState('');

    const filteredProducts = products.filter(p =>
        p.name.toLowerCase().includes(nameFilter.toLowerCase()));


    return(
        <>
            <div>
                <h2>Product Inventory</h2>
                <div className="mb-3">
                    <label htmlFor="productFilter" className="form-label">
                        Filter by Product Name:
                    </label>
                    <input id="productFilter" name="productFilter" type="text" className="form-control" placeholder="Type here to filter the product list..." value={nameFilter} onChange={(e) => setNameFilter(e.target.value)} />
                </div>
                <p className="text-muted">
                    Showing {filteredProducts.length} of {products.length} products.
                </p>
                {
                    filteredProducts.length > 0 ? (
                        <table className="table table-striped table-hover">
                            <thead className="table-dark">
                                <tr>
                                    <th>ID</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Stock Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                {filteredProducts.map(p => (
                                    <tr key={p.id}>
                                        <td>{p.id}</td>
                                        <td>{p.name}</td>
                                        <td>${p.price}</td>
                                        <td>
                                            <span className={`badge ${p.inStock ? 'bg-success' : 'bg-danger'}`}>
                                                {p.inStock ? 'In Stock' : 'Out of Stock'}
                                            </span>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>

                        </table>
                    ) : (
                        <div className="alert alert-info text-center">
                            <h5>No products found</h5>
                            <p className="mb-0">No products match your search for <strong>"{nameFilter}"</strong></p>
                            <small className="text-muted">Try a different search term.</small>
                        </div>
                    )
                }
            </div>
        </>
    );
};

export default ProductList;