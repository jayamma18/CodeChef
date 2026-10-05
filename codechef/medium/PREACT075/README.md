# PREACT075

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - E-Commerce Product Listing Components

In this task, we’ll create a product listing page for an e-commerce site using React’s component spectrum.

Update the existing components to:

- Fix the reusable Button component
- Complete the medium-reusable ProductItem card
- Implement the product grid in ProductListingPage (CSS is already provided - focus on functionality and structure)
#### Your Task:

 **Step 1: Complete the `Button` Component (Button.jsx)** 

- Add the text between the button tags

 **Step 2: Complete `ProductItem` Component (ProductItem.jsx)** 

- Add product image (<img>) with: src={product.image} alt={product.title}
- Display product title in <h3>
- Show star rating using renderStars(product.rating)
- Display price in <p className="price">
- Add Button with: Text: "Add to Cart" Click handler: () => alert(Added ${product.title} to cart)

 **Step 3: Implement Product Grid (ProductListingPage.jsx)** 
Update the container  **`className="products-grid"`**  to map through the  **`products`**  array:

- Return a <ProductItem> for each product.
- Pass the product as a prop.
- Add a proper key.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T09:47:31.233Z  

```cpp
import '../App.css';

function Button({ text, onClick }) {
  return (
      <button className="btn" onClick={onClick}>
            {text}
                </button>
                  );
                  }

                  export default Button;
```

---

[View on CodeChef](https://www.codechef.com/problems/PREACT075)