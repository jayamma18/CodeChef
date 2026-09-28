# OJJAR228

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Fix the render

Welcome to your first React challenge in this contest!

- You are given a buggy React component where clicking a button is supposed to increase the score by 1. However, due to a misuse of React's useEffect, the score keeps increasing continuously without any user interaction.
- This is a common issue caused by infinite re-renders in React due to improper use of state or effects.

Your task is to  **find and fix the infinite render bug**  so that:

- The score only increases when the user clicks the button.
- There is no automatic increase of the score on its own.

 **What You Need to Fix** 

The bug is inside the `useEffect` hook. It's currently causing the component to  **update the state every render**, which triggers another render, and so on-resulting in an infinite loop.

Update the component so:

- The score increases only when the button is clicked.
- The page doesn’t hang or crash due to re-rendering.

 **Expected Behavior** 

 **Helpful Resources** 

- React Docs: useEffect
- React Docs: Rendering and Committing

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T10:16:57.051Z  

```cpp
import React, { useState, useEffect } from "react";

function App() {
const [score, setScore] = useState(0);

useEffect(() => {
setScore(score + 1);
}, []);

const handleClick = () => {
setScore(score + 1);
};

return (
<div style={{ textAlign: "center", marginTop: "100px" }}>
<h1>Click Me Game</h1>
<h2>Score: {score}</h2>
<button onClick={handleClick}>Click Me!</button>
</div>
);
}

export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR228)