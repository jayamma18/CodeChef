# TJEKQL12

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Time Logger Middleware

Let's build a "Time Logger Middleware". This middleware will log the time of each incoming request to your Express application. This can be helpful for debugging or monitoring the performance of your application.

#### Task:

You need to create an Express application with two routes: `/`. You'll also create a custom middleware called `timeLogger` that does the following:

- For each incoming request, it should: Get the current date and time using new Date(). Log the route and the current time to the console in the format: Route: [route], Time: [time]. Call next() to pass control to the next middleware or route handler.
#### Expected output:
#### Note:

The server should run on port 3000.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-03T06:30:27.406Z  

```cpp
const express = require('express');
const app = express();
const port = 3000;

```

---

[View on CodeChef](https://www.codechef.com/problems/TJEKQL12)