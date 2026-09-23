import "./App.css";

// Our list of products - you don't need to change this
const products = [
  { id: 1, name: "Laptop", price: 900 },
    { id: 2, name: "Mouse", price: 20 },
      { id: 3, name: "Keyboard", price: 40 },
        { id: 4, name: "Monitor", price: 150 },
          { id: 5, name: "USB Cable", price: 10 },
          ];

          function ProductCard(props) {
            function handleClick() {
                // STEP 2: Make this show alert with product name
                    alert(`Product Selected: ${props.product.name}`);
                      }

                        return (
                            <div
                                  className="product-card"
                                        role="article"
                                              // STEP 3: Add inline style for border based on price
                                                    style={{
                                                            border: props.product.price > 50 
                                                                      ? "2px solid rgb(255, 0, 0)" 
                                                                                : "2px solid rgb(128, 128, 128)"
                                                                                      }}
                                                                                          >
                                                                                                {/* STEP 1: Add product information here */}
                                                                                                      <h3>{props.product.name}</h3>
                                                                                                            <p>Price: ${props.product.price}</p>

                                                                                                                  {/* STEP 2: Add button that triggers handleClick */}
                                                                                                                        <button onClick={handleClick}>Select</button>
                                                                                                                            </div>
                                                                                                                              );
                                                                                                                              }

                                                                                                                              function App() {
                                                                                                                                return (
                                                                                                                                    <div className="container">
                                                                                                                                          <h1>Product List</h1>
                                                                                                                                                <div className="product-list">
                                                                                                                                                        {/* STEP 4: Display all products using .map() */}
                                                                                                                                                                {products.map((product) => (
                                                                                                                                                                          <ProductCard key={product.id} product={product} />
                                                                                                                                                                                  ))}
                                                                                                                                                                                        </div>
                                                                                                                                                                                            </div>
                                                                                                                                                                                              );
                                                                                                                                                                                              }

                                                                                                                                                                                              export default App;