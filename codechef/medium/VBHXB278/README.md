# VBHXB278

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Typescript- Example

Now let’s build an Express + TypeScript application, there is a GET route at / that sends a welcome message and a POST route at /greet that sends a personalized greeting using the name from the request body.

 **Understanding `(req: Request, res: Response) => {... }` in Express + TypeScript** 

```
app.get("/", (req: Request, res: Response) => {
  res.send("Hello from Express + TypeScript!");
});

```

- req → Represents the incoming HTTP request.
- res → Represents the HTTP response that will be sent back.
- Request and Response are TypeScript type annotations imported from Express.

 **Why We Add Type Annotations** 

- TypeScript uses Request and Response types to check your code at compile time.
- It ensures you only access valid properties and methods on req and res.

 **Example Benefits:** 

```
const { name } = req.body; // TypeScript knows req.body exists
res.send(`Hello, ${name}!`); // TypeScript ensures send() is a valid method

```

- Without types, you might accidentally write res.sned() or req.bdy, which would fail at runtime.
- With types, TypeScript catches mistakes before running the code.

 **How It Works in a Route** 

- Client sends a request → browser, Postman, or frontend app.
- Express calls the route handler (req: Request, res: Response) => {... }.
- req contains request info like headers, query params, or body.
- You process the request and use res to send back a response.
- TypeScript ensures the request and response objects are used correctly throughout this process.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T07:10:41.028Z  

```cpp
import type { Request, Response } from "express";
const express = require("express");

const app = express();
const port = 8080;

app.use(express.json());

app.get("/", (req: Request, res: Response) => {
  res.send("Hello from Express + TypeScript!");
});

app.post("/greet", (req: Request, res: Response) => {
  const { name } = req.body;
  res.send(`Hello, ${name || "stranger"}!`);
});


```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB278)