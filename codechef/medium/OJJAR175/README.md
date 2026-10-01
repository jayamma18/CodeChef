# OJJAR175

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Forward-Ref in React

In React, the `ref` system gives you a powerful way to directly interact with specific DOM elements. It's incredibly useful for certain cases where declarative approaches fall short. We already cover about `ref` here.

Now let’s imagine we built a custom component to “package” an input with some extra fancy styles or labels. Let’s call this custom component `InputWithLabel`.

```
function InputWithLabel({ label,...props }) {
  return (
    <div>
      <label>{label}</label>
      <input {...props} />
    </div>
 );
}

```

We want to use it like this:

```
function App() {
  const usernameRef = useRef(null);

  useEffect(() => {
    usernameRef.current.focus(); // ❌ breaks!
  }, []);

  return <InputWithLabel ref={usernameRef} label="Username" />;
}

```

In our IDE, this code is already written. You can run the code, and in App.jsx, simply uncomment the 10th line: `// console.log(usernameRef);` and check the `usernameRef.current` value in our console
Oops it is null, code doesn't work as expected. But why is usernameRef.current null/undefined?

 **The issue with `ref` on custom components (in React 18 and earlier)** 

In versions of React before 19, a `ref` only works on  **native elements**  like `<input>`, `<button>`, or `<div>`. When you apply a `ref` to your own custom component (like `InputWithLabel`), React treats it differently — it gives you a reference to the  **component function itself**, not the real DOM node inside.

Function components like `InputWithLabel` don’t have any `.focus()` method — so calling it throws an error.

#### How to solve it: React.forwardRef

To make a custom component accept a `ref` and forward it to one of its inner DOM elements, we use `React.forwardRef`.
Here’s how we fix the `InputWithLabel` component:

```
import React from 'react';

const InputWithLabel = React.forwardRef(function InputWithLabel({ label,...rest }, ref) {
  return (
    <div>
      <label>{label}</label>
      <input ref={ref} {...rest} />
    </div>
 );
});

```

Now the `ref` is passed into this component as a second argument, and we decide where to forward it. Here, we’re forwarding it to the `<input>` inside.

And back in the main app:

```
function App() {
  const usernameRef = useRef(null);

  useEffect(() => {
    usernameRef.current.focus(); // ✅ works!
  }, []);

  return <InputWithLabel ref={usernameRef} label="Username" />;
}

```

And boom — now everything works as expected!

 **Why not make this the default behavior?** 

You might wonder: if this is such a common thing, why doesn’t React just make it default?

Well, in earlier versions of React, `ref` could be used to get entire class-based component instances — and changing how refs behave by default would have broken a lot of old code. Instead, React decided to require  **explicit opt-in**  using `forwardRef`.

But good news…

#### In React 19: Refs Just Work™️

React 19 improves this! With the new version, you can  **pass a `ref` just like any other prop**, without needing `forwardRef`. Much simpler!
Here’s how your component would look in React 19:

```
function InputWithLabel({ label, ref,...props }) {
  return (
    <div>
      <label>{label}</label>
      <input ref={ref} {...props} />
    </div>
 );
}

```

And then you use it like so:

```
<inputWithLabel ref={usernameRef} label="Username" />

```

Done. No `forwardRef`. No confusion. Everything works out of the box.

 **Important:**  This will only work in  **React 19**  and  **newer**. But we are using  **React 18**, as you can see in our `package.json` file.

#### Task

When you run the code, you'll notice that it doesn't focus on the input field as expected.
Your task is to  **fix this issue in the code provided in our IDE.** 

- We are using React 18, and the current implementation is not compatible.
- Use what you've learned in this lesson to update and correct the code.
- After making the necessary changes, submit the code and test it to ensure it works correctly.
#### One more thing: Combining with React.memo

Sometimes, you might also want to make your component “smart” — meaning it should skip re-rendering if the props haven't really changed. This is a performance trick using `React.memo`.

You can  **combine**  `memo` and `forwardRef` like this:

```
const FancyInput = React.memo(
  React.forwardRef(function FancyInput({ label,...props }, ref) {
    return (
      <div>
        <label>{label}</label>
        <input ref={ref} {...props} />
      </div>
   );
  })
);

```

The order matters:

- First wrap it in React.forwardRef to allow ref passing.
- Then wrap it in React.memo to prevent unnecessary rendering.

This concept might seem technical, but once you’ve used it once or twice, it becomes second nature. Just remember the goal: `ref` is your tool for talking directly to the DOM — and sometimes you need a little help to make sure it gets passed along the chain.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-01T10:43:11.197Z  

```cpp
import { useEffect, useRef } from "react";
import "./App.css";
import InputWithLabel from "./InputWithLabel";

export default function App() {
  const usernameRef = useRef(null);

    useEffect(() => {
        // console.log(usernameRef);
            if (usernameRef.current) {
                  usernameRef.current.focus();
                      }
                        }, []);

                          return (
                              <div className="container">
                                    <h1>Login</h1>
                                          <InputWithLabel ref={usernameRef} label="Username" />
                                              </div>
                                                );
                                                }
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR175)