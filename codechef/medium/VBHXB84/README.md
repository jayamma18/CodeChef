# VBHXB84

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Organize routes for a simple bookstore application

Let's create a simple bookstore application and organize our routes using Express Router. We'll have two main sections: books and authors. We'll create separate routers for each.

Here's the problem:

We want to create an Express application that handles requests for books and authors. We'll define routes to:

- List all books (/books)
- Get a specific book by ID (/books/:id)
- List all authors (/authors)
- Get a specific author by ID (/authors/:id)

We'll use Express Router to keep our code organized:

- The books.js and authors.js files define the routing logic for books and authors separately. This modular structure keeps the code organized and makes it easier to manage route-specific logic.
- Each file initializes an Express Router instance, which acts as a mini Express application. This allows routing logic to be defined independently of the main app, enabling cleaner separation of concerns.
- Within these router files, two routes are defined: one for listing all resources (/) and another for accessing a specific resource by ID (/:id). These routes handle requests to fetch all books or authors, and to retrieve details for a single book or author respectively.
- In the main application file (app.js), both router modules are imported so that they can be mounted into the main Express app.
- The books router is mounted at the /books path, and the authors router at /authors, meaning that all routes defined in those modules will be prefixed with /books or /authors. For example, a GET request to /books/1 will invoke the route defined in books.js for fetching a book by ID.
- A basic route is also added at the root path /, which responds with a simple welcome message. This serves as a default response for users accessing the base URL of the API.
- The server is started on a specific port, and once running, all defined routes become accessible. Users can test them using a browser or tools like curl or Postman by visiting paths like /books, /books/1, /authors, and /authors/2.
#### Task:

Complete the blanks in the code.

Now, you can "RUN" the code and test out different routes by changing the url in the browser.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T07:24:48.025Z  

```cpp
const express = require('express');
const app = express();
const port = 3000;

// Import routers
const booksRouter = require('./books');
const authorsRouter = require('./authors');

// Root route
app.get('/', (req, res) => {
res.send('Welcome to the Bookstore API!');
});

// Mount routers
app.use('/books', booksRouter);
app.use('/authors', authorsRouter);

// Start the server
app.listen(port, () => {
console.log(`Server listening on port ${port}`);
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB84)