# FYAOAZ05

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Display Product Details

Let’s bring what we’ve learned about rendering dynamic content into action. In this example, we’ll build a simple webpage that displays product details like its name and price using Node.js, Express, and EJS.

### Purpose

The goal is to pass a product object from the server to the frontend and render it dynamically using EJS. This helps you understand how server-side data can be displayed on a webpage in real time.

### Passing Data to the Template

To display the product on a webpage, we use the `res.render` method to pass the `product` object to the EJS template. This makes the data available inside the HTML, allowing us to insert it wherever needed using EJS syntax.

### Creating the EJS Template

Now it’s time to create the `product.ejs` file inside the `views` folder. In this file:

- Use an <h1> tag to display the product name
- Use a <p> tag to show the product price

To insert the dynamic values, use the EJS placeholders:

- <%= product.name %> for the product name
- <%= product.price %> for the price

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T05:51:19.938Z  

```cpp
const express = require('express');
const app = express();
const port = 3000;

app.set('view engine', 'ejs');

app.get('/', (req, res) => {
  const product = {
    name: "Awesome T-Shirt",
    price: 40
  };
  res.render('product', { product: product });
});

app.listen(port, () => {
  console.log(`Server listening at http://localhost:${port}`);
});

```

---

[View on CodeChef](https://www.codechef.com/problems/FYAOAZ05)