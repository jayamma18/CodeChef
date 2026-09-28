# OJJAR172

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Prop Delegation in React

Now that we've worked on several components in React, we're comfortable with how props are passed to share data. However, as our components become more reusable and flexible, we might encounter a challenge: repeatedly passing multiple props can become tedious—especially when we're simply forwarding them to another component.

For example, imagine you're building a small React app and creating a  **`UserMessage`**  component that displays a message, but only if the user is logged in. You might start by defining it like this:

```
function UserMessage({ isLoggedIn, color, fontSize, children }) {
  if (!isLoggedIn) {
    return null;
  }

  return <Message color={color} fontSize={fontSize}>{children}</Message>;
}

```

This works just fine! But… as your design grows, the `Message` component supports  **more and more props**. First 2, then 5, maybe even 10+!

Every time you use a new feature in `<Message />`, you have to go back to `UserMessage` and update the props list. This is  **repetitive**, error-prone, and unnecessary.

#### So is there a way we can avoid repeating ourselves?

YES! ✨  **There’s a powerful trick in JavaScript called “rest” and “spread” syntax**  that helps us collect and pass these props easily.

### Learn the Concept: Rest & Spread with Props

In modern JavaScript, we can use the `...` operator to:

 **1) Collect leftover properties (Rest)** 
 **2) Pass properties to another component or element (Spread)** 

Let’s simplify our code using this idea:

```
function UserMessage({ isLoggedIn,...otherProps }) {
  if (!isLoggedIn) {
    return null;
  }

  return <Message {...otherProps} />;
}

```

Now,  **any extra props**  passed into `UserMessage` (like `color`, `fontSize`, or even `children`) will be  **automatically passed down**  to the `Message` component! 🎉

#### What's actually happening here?

Let’s break it down!

```
<UserMessage 
  isLoggedIn={true}
  color="green"
  fontSize="20px"
>
  Welcome back!
</UserMessage>

```

Behind the scenes:

- isLoggedIn is used only by UserMessage.
- The rest (color, fontSize, and children) go into the...otherProps object.
- These props then get spread onto the Message component.

It’s almost like we’re saying:
💬 " **Hey, I don’t care what all those props are — just send them to the next component.** "

And yes, you can name `otherProps` anything you like: `rest`, `delegated`, `propsToPass`, etc. It’s just a variable.

#### Small Warning: Trailing Comma ❌

If you write this:

```
function SomeComponent({ name,...rest, abc}) {
  // ❌ This COMMA will throw an error
}

```

You'll get an error because  **a rest parameter (`...rest`) must always be last**  in destructuring.

✅  **Fix it by either:** 

- Moving abc before...rest:

```
function SomeComponent({ name, abc,...rest }) { }

```

- Including abc inside...rest:

```
function SomeComponent({ name,...rest }) {
  // abc will be part of rest
}

```

#### Real-World Use Case: Reusable Input Component

Let’s say you’re building an input field that looks stylish and connects a label automatically.

You define `CustomInput`:

```
function CustomInput({ label, id,...inputProps }) {
  const generatedId = React.useId();
  const finalId = id || generatedId;

  return (
    <div className="custom-input">
      <label htmlFor={finalId}>{label}</label>
      <input
        id={finalId}
        {...inputProps}
      />
    </div>
 );
}

```

Now, from your login form, you can use it like this:

```
<CustomInput
  label="Email"
  type="email"
  value={email}
  required
  maxLength={50}
  onChange={(e) => setEmail(e.target.value)}
/>

```

Even attributes like `required`, `maxLength`, and `data-*` props will be passed to the `<input>`. You didn’t need to list them inside `CustomInput`.
That’s the  **magic of delegation** ! 🪄

#### Now, let’s put this knowledge into practice!

 **Task**  – In our IDE, you can see the `CustomInput` component, but right now, it explicitly lists each prop (`type`, `value`, `required`, etc.). Refactor it using the  **rest & spread syntax**  so that it automatically forwards any additional props to the `<input>` element without manually specifying them. Then, test your updated component by adding a `placeholder`, `aria-label`, or `data-test-id` prop in `App.jsx` and verifying that they appear in the rendered input field.
Now just  **submit**  and check you solution is correct or not

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T10:29:33.686Z  

```cpp
import React from 'react';
import './App.css';

function CustomInput({ label, id, ...rest }) {
  const generatedId = React.useId();
    const finalId = id || generatedId;

      return (
          <div className="custom-input">
                <label htmlFor={finalId}>{label}</label>
                      <input 
                              id={finalId}
                                      {...rest}
                                            />
                                                </div>
                                                  );
                                                  }

                                                  export default CustomInput;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR172)