# VBHXB95

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Handling Division by Zero Error

This example demonstrates how to build an Express application with robust error handling, focusing specifically on managing division by zero errors gracefully. The key aspect is to catch runtime errors in your route handler and pass them to centralized error handling middleware, which then sends clear, appropriate responses to the client.

The application exposes a `/divide` route that accepts two query parameters: `numerator` and `denominator`. The route performs division and returns the result. However, division by zero is an invalid operation, so the app must detect this case and respond accordingly without crashing.

Here’s how the error handling flow works in detail:

- Route Handler with try...catch: Inside the /divide route handler, the inputs are converted to numbers and validated. If either value is not a valid number, an error is thrown. Specifically, if the denominator is zero, a custom error is created with a unique type (DIV_ZERO) and thrown immediately. Wrapping this logic in a try...catch block ensures synchronous errors during the division attempt are caught.
- Passing Errors to Middleware: When an error is caught, it is passed to the next middleware function using next(err). This mechanism signals Express to skip the normal route handlers and invoke error handling middleware instead.
- Error Handling Middleware: Defined after all routes, the error middleware receives the error object along with the request and response. It logs the full error stack trace using console.error(err.stack) for debugging purposes. Then, it checks if the error type is the specific division-by-zero error. If so, it responds with HTTP status 400 Bad Request and a clear message "Cannot divide by zero." For all other errors, it sends a generic 500 Internal Server Error response with "Something went wrong." to avoid leaking sensitive details to the client.
- Server Initialization: The Express app listens on port 3000 and logs a startup message.

This structured error handling approach improves the reliability and user experience of your application by:

- Preventing crashes on invalid input or runtime errors.
- Providing meaningful HTTP status codes and messages to clients.
- Centralizing error logic for easier maintenance and scalability.

You can test the application by accessing URLs like:

- /divide?numerator=10&denominator=0 to see the handled division-by-zero error response.
- /divide?numerator=10&denominator=2 for a valid division result.
- /divide?numerator=abc&denominator=2 to test the generic error handler for invalid input.

This pattern of combining route-level `try...catch` with error-handling middleware is essential for building resilient Express applications that gracefully handle errors and communicate effectively with clients.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-17T10:52:07.661Z  

```cpp
const express = require('express');
const app = express();
const port = 3000;

// Route /divide that accepts numerator and denominator as query parameters
app.get('/divide', (req, res, next) => {
  try {
    const numerator = Number(req.query.numerator);
    const denominator = Number(req.query.denominator);

    if (isNaN(numerator) || isNaN(denominator)) {
      throw new Error('Numerator and denominator must be numbers');
    }

    if (denominator === 0) {
      // Explicitly throw error for division by zero
      const err = new Error('Division by zero');
      err.type = 'DIV_ZERO';
      throw err;
    }

    const result = numerator / denominator;
    res.send(`Result: ${result}`);
  } catch (err) {
    // Pass any error to the error handling middleware
    next(err);
  }
});

// Error handling middleware
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB95)