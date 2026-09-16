# VBHXB57

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Greeting Server

You've learned how to create a basic HTTP server and serve content. Now, let's build a "Greeting Server" that displays a personalized greeting based on the current hour of the day.

Here's the problem: You need to create an HTTP server that responds with different greetings depending on the time of day.

- If the current hour is before 12:00 (noon), the server should respond with "Good morning!".
- If the current hour is between 12:00 and 18:00 (6 PM), the server should respond with "Good afternoon!".
- If the current hour is after 18:00, the server should respond with "Good evening!".

The server should listen on port 3000 and the content type should be set to 'text/plain'.

I've provided some code to help you get started. Your task is to complete the `createServer` function to implement the greeting logic.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:41:28.676Z  

```cpp
const http = require('http');

// Function to get the appropriate greeting based on current hour
function getGreeting() {
const now = new Date();
const hour = now.getHours();

if (hour < 12) {
return "Good morning!";
} else if (hour >= 12 && hour < 18) {
return "Good afternoon!";
} else {
return "Good evening!";
}
}

// Create the HTTP server
const server = http.createServer((req, res) => {
res.writeHead(200, { 'Content-Type': 'text/plain' });
res.end(getGreeting());
});

// Start the server on port 3000
server.listen(3000, () => {
console.log('Server running on port 3000');
});

// will be taught in future lessons
module.exports = server;
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB57)