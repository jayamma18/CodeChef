import './App.css';

const products = [
  { id: 1, name: "Laptop", price: 900 },
    { id: 2, name: "Mouse", price: 20 },
      { id: 3, name: "Keyboard", price: 40 },
        { id: 4, name: "Monitor", price: 150 },
          { id: 5, name: "USB Cable", price: 10 },
          ];

          function ProductCard(props) {
            function handleClick() {
                alert(`Product Selected: ${props.product.name}`);
                  }

                    return (
                        <div
                              className="product-card"
                                    role="article"
                                          style={{
                                                  border: props.product.price > 50 
                                                            ? "2px solid rgb(255, 0, 0)" 
                                                                      : "2px solid rgb(128, 128, 128)"
                                                                            }}
                                                                                >
                                                                                      <h3>{props.product.name}</h3>
                                                                                            <p>Price: ${props.product.price}</p>
                                                                                                  <button onClick={handleClick}>Select</button>
                                                                                                      </div>
                                                                                                        );
                                                                                                        }

                                                                                                        function App() {
                                                                                                          return (
                                                                                                              <div className="container">