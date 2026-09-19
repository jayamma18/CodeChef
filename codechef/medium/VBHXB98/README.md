# VBHXB98

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Feedback Form Processor

Let’s build a simple feedback form processor using Express. This example demonstrates how to process both HTML form data and JSON data using the same backend logic.

### Problem:

We need a server that can:

- Receive feedback via an HTML form.
- Accept feedback as JSON through API clients like Postman or curl.
- Log both types of data to the console and return confirmation responses.
### Let’s walk through the solution:
### Parsing Form and JSON Data

```
app.use(express.urlencoded({ extended: false }));
app.use(express.json());

```

These two middlewares are essential:

- express.urlencoded({ extended: false }) allows Express to parse URL-encoded form data (like from <form> tags).
- express.json() parses JSON payloads in incoming requests, enabling the server to read data sent via tools like Postman.

Without these, `req.body` would be undefined in the routes that process submissions.

### Handling Form Submissions

```
app.post('/submit-feedback-form', (req, res) => {
  console.log('Form data received:');
  console.log(req.body);
  res.send('Feedback form data received!');
});

```

This route handles form submissions sent using `method="POST"` in HTML. It logs the received form fields (name, email, comment) from `req.body` and confirms receipt with a simple message.

### Handling JSON Submissions

```
app.post('/submit-feedback-json', (req, res) => {
  console.log('JSON data received:');
  console.log(req.body);
  res.json({ message: 'Feedback JSON data received!' });
});

```

This route is built to accept JSON payloads. When a client sends a JSON object with feedback details, it logs them and replies with a JSON confirmation.

#### Task:

Find the missing code and complete it to run the file.

This structure supports both browser-based and API-based feedback collection — all in a clean, unified Express app.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T05:26:34.789Z  

```cpp
const express = require('express');
const path = require('path');

const app = express();

// Middleware to parse URL-encoded form data
app.use(express.urlencoded({ extended: false }));

// Middleware to parse JSON data
app.use(express.json());

// Serve static files (like feedback.html)



app.post('/submit-feedback-form', (req, res) => {
  console.log('Form data received:');
  console.log(req.body);
  res.send('Feedback form data received!');
});

app.post('/submit-feedback-json', (req, res) => {
  console.log('JSON data received:');
  console.log(req.body);
  res.json({ message: 'Feedback JSON data received!' });
});

const PORT = 3000;

app.listen(PORT, () => {
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB98)