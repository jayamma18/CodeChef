# VBHXB85

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Simple Product Catalog API

Let's build a simplified product catalog API using Express Router. We'll have two main sections: products and categories. We'll create separate routers for each.

Here's the problem:

We want to create an Express application that handles requests for products and categories. We'll define routes to:

- List all products (/products)
- Get a specific product by ID (/products/:id)
- List all categories (/categories)
- Get a specific category by ID (/categories/:id)

We'll use Express Router to keep our code organized.

- Two files are already created: products.js and categories.js. These files are meant to contain the routes for products and categories respectively. The user simply needs to complete the routing logic inside them.
- In each file, an Express Router instance is created using express.Router(). This allows grouping related route definitions for products and categories.
- Define the routes within their respective router files: / should respond with a simple message like "Products Route" or "Categories Route". /:id should respond with something like "Product with ID: <id>" or "Category with ID: <id>".
- The main application file (app.js) already imports both routers.
- The products router is mounted at the /products path and the categories router is mounted at the /categories path using app.use(). This means any route inside products.js will be available under /products, and similarly for categories.
- A basic route is already defined at the root path (/) in the main application to display a welcome message like "Welcome to the Product Catalog API!".
- The server is already started using http.createServer() and listening on a specific port.
### Expected Outputs:
- /products:
- /products/10:
- /categories:
- /categories/24:

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T10:12:30.757Z  

```cpp
const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
  res.send('Categories Route');
  });

  router.get('/:id', (req, res) => {
    res.send(`Category with ID ${req.params.id}`);
    });

    module.exports = router;
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB85)