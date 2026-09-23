# OJJAR111

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Custom Hooks in React

Custom hooks are like magic boxes that help you reuse React logic across components. Let's learn how to create them!

#### What Are Custom Hooks?

Custom Hooks in React are reusable JavaScript functions that encapsulate component logic, allowing you to share functionality across multiple components. They start with "use" (e.g.,  **`useWindowSize`**) and can leverage built-in hooks like  **`useState`**  and  **`useEffect`**  to manage state and side effects efficiently. By extracting logic into custom hooks, you keep components clean, improve reusability, and enhance maintainability.

#### Why Use Custom Hooks?
- Reuse logic between components
- Keep components clean and focused
- Share functionality across your app
- Follow the DRY (Don't Repeat Yourself) principle
#### Creating Your First Custom Hook

 **Example: useCounter Hook** 

Let's create a simple counter hook:

```
import { useState } from 'react';

export function useCounter(initialValue = 0) {
  const [count, setCount] = useState(initialValue);

  const increment = () => setCount(c => c + 1);
  const decrement = () => setCount(c => c - 1);
  const reset = () => setCount(initialValue);

  return { count, increment, decrement, reset };
}

```

Using it in a component:

```
function Counter() {
  const { count, increment, decrement, reset } = useCounter(0);

  return (
    <div className="counter">
      <p>Count: {count}</p>
      <button onClick={increment}>+</button>
      <button onClick={decrement}>-</button>
      <button onClick={reset}>Reset</button>
    </div>
 );
}

```

### Task

Update the existing  **`useWindowWidth`**  hook template to track the browser window width with debouncing. Follow these steps  **exactly as they appear in the template comments** :

- Initialize State Create a state variable width using useState Initialize it with the initial window width (window.innerWidth)
- Create Effect for Resize Listener Use useEffect to handle side effects Include delay in the dependency array
- Handle Debouncing Logic Inside the effect, declare timeoutId to track the timeout Create handleResize: Clear existing timeouts Set a new timeout to update width after the delay
- Add/Remove Event Listener Add a window resize listener that triggers handleResize In the cleanup function: Remove the resize listener Clear any pending timeout
- Return Current Width Have the hook return the width value

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T10:02:46.609Z  

```cpp
import { useState, useEffect } from "react";

const useWindowWidth = (delay = 200) => {
const [width, setWidth] = useState(window.innerWidth);

useEffect(() => {
let timeoutId;

const handleResize = () => {
clearTimeout(timeoutId);
timeoutId = setTimeout(() => {
setWidth(window.innerWidth);
}, delay);
};

window.addEventListener("resize", handleResize);

return () => {
window.removeEventListener("resize", handleResize);
clearTimeout(timeoutId);
};
}, [delay]);

return width;
};

const ResponsiveComponent = () => {
const width = useWindowWidth();

return (
<div style={{ padding: "20px", textAlign: "center" }}>
<h2>Current window width:</h2>
<p style={{ fontSize: "24px", fontWeight: "bold", color: "blue" }}>
{width}px
</p>
</div>
);
};

export default ResponsiveComponent;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR111)