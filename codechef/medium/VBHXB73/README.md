# VBHXB73

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Create routes for "home" and "products" pages

Okay, let's solidify your understanding of basic routing in Express with a worked-out example. We'll build on the previous example and create an application with routes for a "home" page and a "products" page.

Think of this as expanding a basic website with more pages. We'll be using the `app.get()` method again to define these routes. Remember that `app.get()` takes the path as the first argument and a handler function as the second argument. The handler function takes the `req` (request) and `res` (response) objects as arguments. We'll use `res.send()` to send a string back to the client.

#### Task:
- Define a route for GET requests to the root path ("/") that responds with "Welcome to the homepage!"

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T07:17:49.767Z  

```cpp
const express = require('express');

const app = express();

const PORT = 3000;

// Define a route for GET requests to the root path ("/") that responds with "Welcome to the homepage!"
app.get('/', (req, res) => {
res.send('Welcome to the homepage!');
});

// Define a route for GET requests to the path "/products" that responds with "Our products are coming soon!"
app.get('/products', (req, res) => {
res.send('Our products are coming soon!');
});

app.listen(PORT, () => {
console.log(`Server is running on port ${PORT}`);
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB73)