# OJJAR79

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Complete the Product List App

Here's what you need to do step by step:

- Product Cards Display Make each product card show: Product name in an <h3> tag Price in a <p> tag showing "Price: $X" (X = actual price) A "Select" button at the bottom
- Click Alert Functionality When clicking the "Select" button: Show an alert message that says "Product Selected: [ProductName]" Example: Clicking Laptop's button should show "Product Selected: Laptop"
- Conditional Border Styling Add a border style to product cards: Red border (2px solid rgb(255, 0, 0)) if price > $50 Gray border (2px solid rgb(128, 128, 128)) if price ≤ $50
- Display All Products In the App component, show all products from the products array Use the.map() method to create ProductCards for all items Remember to add a unique key prop for each product card

 **Tips to solve the problem:** 

- All product data is available in the products array (already provided)
- You'll work mainly in two components: ProductCard and App
- Use props.product to access individual product data in ProductCard
- For styling, you can use inline style={{}} with the conditional (ternary) operator
- Example of an alert in JavaScript: alert("Hello! This is a simple alert message.");

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:05:25.781Z  

```cpp
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
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR79)