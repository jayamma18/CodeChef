# VBHXB76

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Display User Agent

Okay, let's try a worked example to solidify your understanding of request and response objects in Express.

Remember, the `request` object contains information about the incoming request, like the headers sent by the client (browser). One useful header is the `User-Agent` header, which tells us the client's browser and operating system.

Here's a breakdown of the steps:

- Set up an Express application: You'll need to create an Express application instance and define a route for the root path (/).
- Access the User-Agent header: Inside the route handler, you'll access the User-Agent header from the request.headers object.
- Send the header in the response: Use the response.send() method to send the User-Agent string back to the client.
#### Task:

Complete the code to listen to the PORT.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T07:19:37.904Z  

```cpp
const express = require('express');
const app = express();
const PORT = 3000;

app.get('/', (req, res) => {
const userAgent = req.headers['user-agent'];
res.send(`Your User-Agent is: ${userAgent}`);
});

app.listen(PORT, () => {
console.log(`Server is running on port ${PORT}`);
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB76)