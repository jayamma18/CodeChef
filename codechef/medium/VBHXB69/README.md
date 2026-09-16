# VBHXB69

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Express Server with Environment Variable Port

Okay, let's solidify our understanding of setting up an Express server by creating a slightly more dynamic setup.

We'll create an Express server that reads the port number variable named `PORT`.

```
const express = require('express');
const app = express();

```

- First, we import the Express library and create an instance of the Express application using express(). This app object will be used to define routes and start the server.

```
const PORT = 3000;

```

- Here, we define a constant PORT with the value 3000. This is the port our server will listen on. In a more dynamic setup, this could come from process.env.PORT to support environment-based configuration (e.g., for deployment).

```
app.get('/', (req, res) => {
  res.send('Hello from Express!');
});

```

- We set up a simple route that listens for GET requests to the root URL (/). When this route is accessed, the server responds with the plain text message 'Hello from Express!'.

```
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});

```

#### Task:

Complete the code to connect to the PORT 3000.

- Finally, we start the server using app.listen(). This tells Express to start listening for incoming connections on the specified port. Once the server is running, it logs a message to the console confirming the port.

This setup forms the basic foundation of any Express application: initializing the app, defining routes, and starting the server.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T07:14:22.137Z  

```cpp
const express = require('express');
const app = express();

// Use PORT to set the port number as 3000
const PORT = 3000;

// Simple route
app.get('/', (req, res) => {
    res.send('Hello from Express!');
    });

    // Start the server
    app.listen(PORT, () => {
        console.log(`Server is running on port ${PORT}`);
        });

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB69)