# VBHXB59

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Simple HTML Page Server

Let's create a server that serves a simple HTML page. This will help you understand how to set the `Content-Type` header and send HTML content in the response.

 **Problem:** 

This `index.js` is a Node.js HTTP server that, when accessed in a browser, displays a simple HTML page with a heading "My First Webpage" and a paragraph "This is a simple webpage served from Node.js".

#### Task:

Complete the code to write the html file on the website.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:43:14.744Z  

```cpp
const http = require('http');

const server = http.createServer((req, res) => {
// Set the Content-Type header to HTML
res.writeHead(200, { 'Content-Type': 'text/html' });

// complete the code to write the HTML content
res.write(`
<!DOCTYPE html>
<html>
<head>
<title>My First Webpage</title>
</head>
<body>
<h1>My First Webpage</h1>
<p>This is a simple webpage served from Node.js</p>
</body>
</html>
`);

// End the response
res.end();
});

// Listen on port 3000
server.listen(3000, () => {
console.log('Server is running at http://localhost:3000');
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB59)