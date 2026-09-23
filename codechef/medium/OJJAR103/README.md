# OJJAR103

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Change the Background Color

You need to implement a background color changer that turns the page background to  **`lightblue`**  when the counter reaches $5$ or more. When the counter is less than $5,$ the background should return to its default color.

#### Steps to Complete:
- Use useEffect to detect changes in the count state
- When count >= 5, set document.body.style.backgroundColor to "lightblue"
- When count < 5, reset to default background (set to empty string "")
- Add the proper dependency array to ensure the effect runs when needed

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T10:00:32.966Z  

```cpp
import { useState, useEffect } from "react";
import "./App.css";

function BackgroundChanger() {
const [count, setCount] = useState(0);

useEffect(() => {
if (count >= 5) {
document.body.style.backgroundColor = "lightblue";
} else {
document.body.style.backgroundColor = "";
}
}, [count]);

return (
<div className="container">
<h1>Count: {count}</h1>
<button className="btn" onClick={() => setCount(count + 1)}>Increase Count</button>
<button className="btn reset-btn" onClick={() => setCount(0)}>Reset</button>
</div>
);
}

export default BackgroundChanger;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR103)