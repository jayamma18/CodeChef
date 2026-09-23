# OJJAR60

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Dynamic Greeting Card

Update the given React component to display dynamic values and additional information inside the `<div>`.

- Show dynamic values: Add a <p> tag to display: <p>Hello, my name is {name}.</p> Add another <p> tag to show age: <p>I am {age} years old.</p>
- Display the current year dynamically: Use JavaScript inside JSX to show the year: <p>Year: {new Date().getFullYear()}</p>
- Add a final message: Insert this at the end: <p>Enjoy your day! 🎉</p>

By following these instructions, you will create a structured and dynamic greeting card in React! 🚀

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T05:37:41.297Z  

```cpp
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { App } from './App.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)

```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR60)