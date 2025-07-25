import React, { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";

const ProductSearch = () => {
  const [searchParams, setSearchParams] = useSearchParams();
  const [query, setQuery] = useState(searchParams.get("q") || "");
  const [products, setProducts] = useState([]);

  useEffect(() => {
    if (!query) {
      setProducts([]);
      return;
    }
    const fetchProducts = async () => {
      try {
        const response = await fetch(
          `https://dummyjson.com/products/search?q=${query}`
        );
        const data = await response.json();
        setProducts(data.products);
      } catch (error) {
        console.error(error);
      }
    };

    fetchProducts();
  }, [query]);

  const handleSearch = (e) => {
    if (query) {
      setSearchParams({ q: query });
    } else {
      setSearchParams({});
    }
  };

  return (
    <div>
      <h1> Search karoooo</h1>
      <form onSubmit={handleSearch}>
        <input
          type="text"
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          placeholder="........"
        />
        <button type="submit">Search</button>
      </form>

      {products.length > 0 ? (
        <div>
          {products.map((product) => (
            <div key={product.id}>
              <h2>{product.title}</h2>
            </div>
          ))}
        </div>
      ) : (
        query && <h1>No products found.</h1>
      )}
    </div>
  );
};

export default ProductSearch;
