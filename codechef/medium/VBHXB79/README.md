# VBHXB79

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Serving a Simple Static Website

Let's create a simple website with an HTML file, a CSS file, and an image, and serve it using Express. This will give you a practical understanding of how `express.static` works.

Now, let's see the Express code to serve these static files. We'll use the `express.static` middleware.

This code does the following:

- Imports the express module.
- Creates an Express application.
- Uses express.static('public') to serve static files from the public directory. This tells Express to look for files (like index.html, style.css, and nodejs.png) inside the public directory when a request is made.
- Starts the server on port 3000.
#### Task:

Complete the missing code.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T07:21:04.068Z  

```cpp
const express = require('express');
const app = express();

const PORT = 3000;

// Serve static files from the "public" directory
app.use(express.static('public'));

// Start the server
app.listen(PORT, () => {
console.log(`Server is running on http://localhost:${PORT}`);
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB79)