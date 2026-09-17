# VBHXB90

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Request Counter Middleware

Let's create a "Request Counter Middleware". This middleware will keep track of how many times each route in your Express application has been accessed. We'll store these counts in a simple object and log the route and its count to the console with each request.

Here's the problem:

You need to create an Express application with two routes: `/` and `/about`. You'll also create a custom middleware called `requestCounter` that does the following:

- Maintains a routeCounts object to store the number of times each route is accessed.
- For each incoming request, it should: Increment the counter for the requested route in the routeCounts object. Log the route and its current count to the console in the format: Route: [route], Count: [count]. Call next() to pass control to the next middleware or route handler.
- Apply this middleware to the entire application.
#### Task:

Complete the code for `about` route.

### Note:

You can see the count in the terminal, but it shows two while loading the browser can you think of that reason? You can find the soultion for this question in the next problem.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-17T10:47:38.958Z  

```cpp
const express = require('express');
const app = express();
const port = 3000;

const routeCounts = {};

const requestCounter = (req, res, next) => {
  const route = req.path;

  if (!routeCounts[route]) {
    routeCounts[route] = 0;
  }

  routeCounts[route]++;

  console.log(`Route: ${route}, Count: ${routeCounts[route]}`);

  next();
};

app.use(requestCounter);

app.get('/', (req, res) => {
  res.send('Home Page');
});

___________________________ {
  res.send('About Page');
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB90)