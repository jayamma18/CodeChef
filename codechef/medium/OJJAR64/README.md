# OJJAR64

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### React Fragments

When building a React application, you often need to return multiple elements from a component. However, React requires that all returned elements be wrapped in a single parent element. This is where  **Fragments**  come in handy.

### Why Use Fragments?

Without fragments, you might wrap elements inside a `div`, like this:

```
const UserInfo = () => {
  return (
    <div>
      <h2>John Doe</h2>
      <p>Software Developer</p>
    </div>
 );
};

```

While this approach works, it introduces an extra `div` into the DOM, which may affect styling and layout. In some cases, this unnecessary wrapper could interfere with CSS styles or cause unwanted nesting issues.

#### Using Fragments

Fragments allow you to return multiple elements  **without adding extra nodes to the DOM** :

```
import React from "react";

const UserInfo = () => {
  return (
    <>
      <h2>John Doe</h2>
      <p>Software Developer</p>
    </>
 );
};

```

#### Why This is Better
- Removes the unnecessary div, keeping the DOM cleaner.
- Prevents potential CSS styling issues caused by extra wrappers.
- Improves readability and structure.
### Task: Convert a Component to Use Fragments

Let's practice using fragments in a real example.

Given an `App` component that currently wraps its content inside a `div`. Your task is to convert it to use  **React Fragments**  instead.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T05:42:26.920Z  

```cpp
function App() {
  return (
  <>
  <h3>Laptop</h3>
  <p>Price: $1000</p>
  <p>High-performance laptop with 16GB RAM and 512GB SSD.</p>
  </>
  );
  }

  export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR64)