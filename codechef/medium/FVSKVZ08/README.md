# FVSKVZ08

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Book Inventory: Update Price & Delete Book

Alright, you've learned the theory behind updating and deleting records in MongoDB using Mongoose. Now, let's see it in action with a practical example!

Imagine we're building a simple inventory system for a small online bookstore. We'll need to:

- Update the price of a book.
- Remove a book that's no longer in stock.

We'll write a Node.js script that connects to a MongoDB database, defines a `Book` model, adds some initial books, then performs an update and a delete operation. We'll log the changes to the console so you can see what's happening at each step.

This example will use concepts we've covered:

- Connecting to MongoDB with Mongoose (Mongoose Fundamentals).
- Defining a Mongoose schema and model (Mongoose Fundamentals).
- Using async/await for database operations (Asynchronous JavaScript Basics).
- Creating, updating, and deleting documents.

Let's get started!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T09:14:10.221Z  

```cpp
const express = require('express');
const app = express();

app.set('view engine', 'ejs');

app.get('/', (req, res) => {
```

---

[View on CodeChef](https://www.codechef.com/problems/FVSKVZ08)