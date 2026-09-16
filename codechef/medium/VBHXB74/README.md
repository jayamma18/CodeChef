# VBHXB74

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Simple Services Page

Now, let's put your routing skills to the test. Imagine you are building a small website for a service company. The company offers two main services: "Web Development" and "Mobile App Development".

Your task is to create an Express application that does the following:

- Responds with Welcome to our services page! when a user visits the root path (/).
- Responds with We specialize in Web Development. when a user visits the /web path.
- Responds with We also offer Mobile App Development. when a user visits the /mobile path.

This exercise builds upon the previous one by adding another route. You'll be using `app.get()` to define these routes, and `res.send()` to send a string back to the client.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T07:18:55.950Z  

```cpp
// write your code here.
const express = require('express');
const app = express();

const PORT = 3000;

app.get('/', (req, res) => {
res.send('Welcome to our services page!');
});

app.get('/web', (req, res) => {
res.send('We specialize in Web Development.');
});

app.get('/mobile', (req, res) => {
res.send('We also offer Mobile App Development.');
});

app.listen(PORT, () => {
console.log(`Server is running on port ${PORT}`);
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB74)