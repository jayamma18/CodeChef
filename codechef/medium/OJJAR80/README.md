# OJJAR80

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Understanding State and Re-Renders in React

Predict the Outcome of our `IDE` code

 **What Do You Expect?** 

- When you click the button, should the counter increase?
- Will the number 0 change to 1, 2, etc., with each click?

 **Now Run the Code and see What Happens?** 

- The counter starts at 0.
- You click the button... once, twice, ten times...
- Nothing changes! The number stays at 0 😱.

🤯  **Why Isn’t It Working?** 
Let’s imagine your component is like a photo.

- When you first take a photo, count is 0.
- If you scribble count++ on the photo (like drawing on paper), the real count in your app hasn’t changed.
- React only shows the original photo (the initial render) – it doesn’t see your scribbles!

👉  **Regular variables (like `let count`) don’t tell React: `“Hey, I changed! Update the screen!”`** 

### The Fix – useState to the Rescue!

 **Replace Your Code With This:** 

```
import { useState } from 'react';

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>
        Click me
      </button>
    </>
 );
}

export default App;

```

Now, run the updated code and watch the magic happen!

With every click, the number updates instantly—just like it should. 🎉 React  **sees**  the change, updates the UI, and everything works as expected!

This is the power of state in React. Instead of just scribbling on a static photo, we’re now telling React: 👉  **"Hey, something changed! Re-render the screen!"** 

Now that you've seen it in action, click Submit and move on to the next question. We’ll dive deeper into this in the next tab!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:07:37.183Z  

```cpp
import React, { useState } from 'react';

function App() {
  const [count, setCount] = useState(0);

    return (
        <>
              <p>You clicked {count} times</p>
                    <button onClick={() => setCount(count + 1)}>
                            Click me
                                  </button>
                                      </>
                                        );
                                        }

                                        export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR80)