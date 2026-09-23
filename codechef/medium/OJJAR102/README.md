# OJJAR102

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Side Effects and the useEffect Hook

So far, we have learned about `useState`, `useRef`, and managing state in React. Now, let's talk about  **side effects**  and how we handle them using the `useEffect` hook.

#### What is a Side Effect?

In React, a  **side effect**  is anything that happens  **outside the main component logic**.

Here are some examples of side effects:
✅ Fetching data from an API
✅ Updating the document title
✅ Setting up event listeners (like keyboard or mouse events)
✅ Using `setTimeout` or `setInterval`

React components should focus on displaying UI, but sometimes we need to perform tasks  *beyond*  rendering—this is where  **side effects**  come in.

### What is useEffect?

React provides a special hook called `useEffect` to  **handle side effects**  inside functional components.

 **Syntax:** 

```
import { useEffect } from "react";

useEffect(() => {
  // Run your side effect here
});

```

The function inside `useEffect` runs  **after the component renders**.

### Example 1: Running useEffect on Every Render

The following example  **changes the document title**  whenever the component renders.

```
import { useState, useEffect } from "react";

function Example() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    document.title = `Clicked ${count} times`;
  });

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>Click Me</button>
    </div>
 );
}

export default Example;

```

 **To experience this**, simply run the code and click on the marked button:
and now you are in new page now, When you click the button, you will notice that as the number changes, the page title updates accordingly.

### Explanation:
- Every time count changes, useEffect runs and updates the page title.
- This happens on every render because we did not specify any dependencies (more on that next).
### Controlling When useEffect Runs

By  **default**, `useEffect` runs after every render, but we can control when it runs by using a  **dependency array**  (`[]`).

##### 1️⃣ Run only once (on mount)

Sometimes, we only want `useEffect` to run  **once**, like when setting up event listeners or fetching data.
To do that, we  **pass an empty dependency array `[]`** :

```
useEffect(() => {
  console.log("Component Mounted!");
}, []); // Runs only once when the component is first rendered

```

##### 2️⃣ Run only when a specific value changes

If we want `useEffect` to run  **only when a certain variable changes**, we pass that variable inside the array:

```
useEffect(() => {
  console.log("Count changed:", count);
}, [count]); // Runs only when `count` changes

```

### Example 2: Fetching Data with useEffect

Imagine we want to  **fetch data from an API**  when the component loads.

```
import { useState, useEffect } from "react";

function FetchData() {
  const [data, setData] = useState(null);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts/1")
     .then(response => response.json())
     .then(json => setData(json));
  }, []); // Runs only once when the component mounts

  return (
    <div>
      <h1>Fetched Data</h1>
      {data ? <p>{data.title}</p> : <p>Loading...</p>}
    </div>
 );
}

export default FetchData;

```

### Explanation:
- We use fetch() to get data from an API when the component mounts.
- The empty [] array makes sure the effect runs only once.
- The component first shows "Loading...", then updates when data is fetched.

Now, try running the code in our IDE to see how it works.

In the next section, we'll work on a practice problem to strengthen our hands-on experience with this topic.

Click the  **Submit"**  button to continue!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T09:59:10.646Z  

```cpp
import { useState, useEffect } from "react";

function Example() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    document.title = `Clicked ${count} times`;
  });

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>Click Me</button>
    </div>
  );
}

export default Example;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR102)