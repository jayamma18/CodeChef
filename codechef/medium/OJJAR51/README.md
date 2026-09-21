# OJJAR51

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Introduction to jsx

In the last lesson, we saw how to create a React element using plain JavaScript. While this works, most developers prefer a special syntax called  **JSX (JavaScript XML)**  to make writing React components easier and more readable.

### JSX vs JavaScript

Using `JavaScript` alone, we would write something like this:

```
export function App() {
  return (
    'h1',
    { id: 'greeting' },
    'Hello, React!'
 );
}

```

Now, let's see the same example written in `JSX`:

```
export function App() {
  return (
    <h1 id="greeting">
        Hello, React!
    </h1>
 );
}

```

`JSX` makes the code much easier to read and write. Instead of multiple function calls, we use an `HTML`-like syntax to define our elements.

### Why JSX is Useful

`JSX` is not required to write React, but it makes development much more efficient. Here are a few reasons why `JSX` is widely used:

- Readability: JSX looks much like HTML, making it easier to understand.
- Better Structure: JSX allows us to create complex UI structures in an easier-to-follow format.

Now that you understand `JSX`, try creating your own `JSX` element.

### Task:
- Update the App function in App.jsx.
- Add a <p> tag with the text "I am learning JSX!".

The render part of the app is written in main.jsx. This follows the standard structure of a React project.

Once you’ve completed the  **task**, click the Submit button and proceed to the next lesson.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T10:38:27.935Z  

```cpp
// update the function 
export function App() {
  return (
    // write you code here 
  );
    <h1 id="greeting">Hello, React!</h1>
}
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR51)