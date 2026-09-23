# OJJAR97

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Rules of Hooks

Hooks in React are special functions that allow us to use features like state and side effects inside function components. They help us interact with React’s internals, but they must follow certain rules to work properly.

 **Why Do We Need Rules for Hooks?** 

Hooks are just JavaScript functions, but React relies on their order to keep track of component behavior. If we don’t follow the rules, React can get confused, leading to unexpected bugs.

#### Rule 1: Only Call Hooks Inside React Components or Custom Hooks

Hooks must always be used inside a function component or a custom hook. If you try to call a hook outside of these, React will show an error.

❌  **Incorrect Usage** 

```
import React from 'react';

// This will cause an error
const id = React.useId();
console.log(id);

```

✅  **Correct Usage** 

```
import React from 'react';

function MyComponent() {
  const id = React.useId();
  return <div id={id}>Hello!</div>;
}

```

#### Rule 2: Always Call Hooks at the Top Level

Hooks must be called in the same order on every render. If we place a hook inside a loop, a condition, or a function, React might call hooks in the wrong order, causing unexpected behavior.

❌  **Incorrect Usage** 

```
function MyComponent({ useUniqueId }) {
  if (useUniqueId) {
    const id = React.useId(); // ❌ Hooks shouldn't be inside conditions
    return <div id={id}>Unique ID</div>;
  }
  return <div>No ID</div>;
}

```

✅  **Correct Usage** 

```
function MyComponent({ useUniqueId }) {
  const id = React.useId();
  const appliedId = useUniqueId ? id : 'default-id';
  return <div id={appliedId}>Hello!</div>;
}

```

#### Why Does This Rule Exist?

React tracks hooks by their order. If a hook is skipped due to a condition, all following hooks shift position, causing React to mix up state values between them. This can lead to unexpected bugs.

For example, if we use useState conditionally, the states could get swapped between renders, causing unpredictable behavior

#### Task: Fix the Hook Usage

In our IDE you are given a component that violates the Rules of Hooks. Identify the mistake and correct the code.

Once done, submit your solution to verify correctness.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:29:23.962Z  

```cpp
import React from "react";

function TextInput({ id, label, type = "text" }) {
  let appliedId;
  
  if (!id) {
    appliedId = React.useId(); // ❌ Hook inside condition (incorrect usage)
  } else {
    appliedId = id;
  }

  return (
    <div className="text-input">
      <label htmlFor={appliedId}>{label}</label>
      <input id={appliedId} type={type} className="input-field" />
    </div>
  );
}

export default function App() {
  return <TextInput id="input-id" label="Enter Text:" />;
}

```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR97)