# VBHXB71

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Simple HTML Server

Your task is to create a simple Express application that serves an HTML file.

### Tasks:
- Import the important libraries like express, fs, and path.
- Declare the variables used, including creating an Express app.
- Finally, start the server on a specified port so it listens for incoming requests.

Complete the code by filling in these parts!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T07:16:42.518Z  

```cpp
const express = require('express');
const fs = require('fs');
const path = require('path');

const app = express();
const PORT = 3000;

// Root route to serve the HTML file
app.get('/', (req, res) => {
const filePath = path.join(__dirname, 'index.html');

fs.readFile(filePath, 'utf8', (err, data) => {
if (err) {
res.status(500).send('Error loading HTML file.');
} else {
res.setHeader('Content-Type', 'text/html');
res.send(data);
}
});
});

app.listen(PORT, () => {
console.log(`Server is running at http://localhost:${PORT}`);
});


```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB71)