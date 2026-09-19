# VBHXB105

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Serving Book Data as JSON and HTML

Great! Now, let's solidify your understanding of response formatting. We'll create another Express application, this time focusing on serving book data.

Here's the scenario: We want to build an API endpoint `/books` that returns a list of books as JSON. The book data should include the `id`, `title`, and `author` of each book.

```
[
  { "id": 1, "title": "The Hitchhiker's Guide to the Galaxy", "author": "Douglas Adams" },
  { "id": 2, "title": "Pride and Prejudice", "author": "Jane Austen" },
  { "id": 3, "title": "1984", "author": "George Orwell" }
]

```

Additionally, we want the root route (`/`) to display a simple HTML message: `<h1>Welcome to the Book Store!</h1>`.

Your task is to create an Express application that:

- Defines a /books route that sends the book data as JSON using res.json().
- Defines the root route (/) that sends the HTML welcome message using res.send().

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T05:37:43.102Z  

```cpp
const express = require('express');
const app = express();

// Root route returning HTML message
app.get('/', (req, res) => {
    res.send('<h1>Welcome to the Book Store!</h1>');
    });
    
    // /books route returning JSON data
    app.get('/books', (req, res) => {
        const books = [
                { "id": 1, "title": "The Hitchhiker's Guide to the Galaxy", "author": "Douglas Adams" },
                        { "id": 2, "title": "Pride and Prejudice", "author": "Jane Austen" },
                                { "id": 3, "title": "1984", "author": "George Orwell" }
                                    ];
                                    
                                        res.json(books);
                                        });
                                        
                                        // Start server
                                        const PORT = 3000;
                                        app.listen(PORT, () => {
                                            console.log(`Server is running on port ${PORT}`);
                                            });// write your code here

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB105)