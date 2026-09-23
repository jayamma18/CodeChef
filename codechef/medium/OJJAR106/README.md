# OJJAR106

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Cleanup in React

When working with side effects in React (like timers, event listeners, or API calls), it's crucial to clean up after them to prevent memory leaks and unexpected behavior. Let's explore this with a practical example.

#### The Problem: Lingering Effects

Imagine a timer component that counts up every second. If we toggle this component's visibility, what happens to the timer?

 **Starter Code (Problematic):** 

```
import React, { useState, useEffect } from 'react';

function Timer() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    const timerID = setInterval(() => {
      setCount(c => c + 1);
    }, 1000);
  }, []); // No cleanup

  return <h2>Count: {count}</h2>;
}

function App() {
  const [showTimer, setShowTimer] = useState(true);

  return (
    <div>
      <button onClick={() => setShowTimer(!showTimer)}>
        Toggle Timer
      </button>
      {showTimer && <Timer />}
    </div>
 );
}

```

 **The Issue:**  When you click "Toggle Timer" to hide the component, the timer keeps running! This leads to:

- Memory leaks (unused timers consuming resources)
- Potential errors (updating state of an unmounted component)
#### The Solution: Cleanup Functions

React's  **`useEffect`**  hook lets us return a cleanup function that runs:

- Before the component unmounts
- Before re-running the effect (if dependencies change)

 **Fixed Code:** 

```
useEffect(() => {
  const timerID = setInterval(() => {
    setCount(c => c + 1);
  }, 1000);

  // Cleanup function
  return () => {
    clearInterval(timerID);
  };
}, []);

```

#### How It Works
- Mounting: When <Timer> appears, React: Runs the effect (starts timer) Stores the cleanup function
- Unmounting: When toggled off: Calls the cleanup function (stops timer) Removes the component
- Re-renders: If dependencies change: Runs cleanup first (old effect) Runs new effect

 **Key Takeaways:** 

- Always clean up event listeners, timers, and subscriptions
- Cleanup functions prevent memory leaks and errors
- React handles cleanup automatically when you return a function from useEffect
- Dependency arrays control when effects re-run (and cleanup happens before each re-run)
### Task

Now, go ahead and update the code to add a cleanup function as given in the above example.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T10:22:06.280Z  

```cpp
import React, { useState, useEffect } from 'react';

function Timer() {
const [count, setCount] = useState(0);

useEffect(() => {
const timerID = setInterval(() => {
setCount(c => c + 1);
}, 1000);

return () => {
clearInterval(timerID);
};
}, []);

return <h2>Count: {count}</h2>;
}

export default function App() {
const [showTimer, setShowTimer] = useState(true);

return (
<div>
<button onClick={() => setShowTimer(!showTimer)}>
Toggle Timer
</button>
{showTimer && <Timer />}
</div>
);
}
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR106)