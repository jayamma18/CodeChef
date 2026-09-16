# VBHXB82

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Book Details and Chapter

Let's create a simple application that displays book details and a specific chapter if requested. This will demonstrate the use of both route parameters and query strings.

We'll use a route parameter to specify the book ID and a query string to optionally specify the chapter number.

```
app.get('/books/:bookId', (req, res) => {
  const bookId = req.params.bookId;
  let responseText = `Book ID: ${bookId}`;
  res.send(responseText);
});

```

This code defines a route `/books/:bookId`. When a user visits a URL like `/books/123`, the `bookId` variable will be set to "123".

```
const chapter = req.query.chapter;
if (chapter) {
    responseText += `, Chapter: ${chapter}`;
  }

```

Here, `req.query.chapter` will give us the value of the `chapter` query parameter, if it's provided in the URL (e.g., `/books/123?chapter=5`).

#### Task:

Complete blanks in the code.

Now, "RUN" and open your web browser and try the following URLs:

- /books/12
- /books/12?chapter=12

Observe the output in your browser for both URLs.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T07:23:51.971Z  

```cpp
const express = require('express');
const app = express();
const port = 3000;

app.get('/books/:bookId', (req, res) => {
const bookId = req.params.bookId;
const chapter = req.query.chapter;

let responseText = `Book ID: ${bookId}`;
if (chapter) {
responseText += `, Chapter: ${chapter}`;
}

res.send(responseText);
});

app.listen(port, () => {
console.log(`Server listening on port ${port}`);
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB82)