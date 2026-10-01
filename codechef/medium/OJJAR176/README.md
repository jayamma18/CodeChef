# OJJAR176

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Polymorphic Components

In our real world of development, we often come across something that looks like a link but doesn’t actually navigate anywhere when clicked.

Maybe it downloads a file, submits a form, or opens a modal.

In those situations, should you use an `<a>` tag (link) or a `<button>` element (button)? 🤔

Let’s learn how to choose the right HTML element for  **best accessibility and usability** —and how to build a  **React component**  that adjusts  **automatically** !

#### Use the Right Tag for the Right Job

Let’s understand the  **difference**  between a link and a button.

- Use an <a> anchor link when clicking it navigates to another location — either a different page or even a section in the current page.
- Use a <button> element when clicking it performs an action without changing the URL — like submitting a form, opening a modal, or running JavaScript.
#### Why It Matters

Screen readers and keyboards rely on the  **semantics**  (meaning) of HTML tags. If we use the wrong element, such tools might confuse the user. Also, we lose out on built-in accessibility features, keyboard navigation, and interaction behavior provided by the browser.

So simply saying,  **don’t pretend a `div` is a button**, or style an `<a>` to look like a button “just because”.

#### The Design Problem

Let’s say our designer gave us this screen:

All of these look like styled text links. But should they really be links?
Let's think:

- “Export Data" likely triggers a CSV download → that’s an action → 🟢 Button
- “Download PDF” maybe opens a new file tab → still an action → 🟢 Button
- “Add Transaction” maybe takes you to a form page → 🟢 Link!

So... they all look the same 🔵 but behave differently.

#### The React Solution — A Smart LinkButton Component

Wouldn't it be cool if we had a  **reusable React component**  that:

- Always looks like a link (same CSS styling),
- But automatically uses the right tag under the hood?

Let’s build it! ✨

### Step by Step: Build the Component
#### 1. Define the component

```
import React from "react";

function LinkButton({ href, children,...props }) {
  const Tag = typeof href === "string" ? "a" : "button";

  return (
    <Tag
      href={href}
      className={styles.button}
      {...props}
    >
      {children}
    </Tag>
 );
}

export default LinkButton;

```

#### Breaking It Down:
- We create a variable Tag.
- If we receive a href string, we assume the developer wants a real <a href="..."> link.
- If not, we default to a <button>.

This is called  **polymorphism**  — the component  **changes form**  depending on how it's used!

#### Why We Use typeof href === "string" Instead of href ?

Let’s say you pass an  **empty string** :

```
<LinkButton href="">Refresh Page</LinkButton>

```

This is still a  **valid link**  to the current page. But `""` is  **falsy**  in JavaScript.
So if we wrote:

```
const Tag = href ? 'a' : 'button';

```

It would incorrectly use `<button>` — even though we really wanted an `<a>`!
By checking `typeof href === "string"`, we make sure that we're dealing with a string,  **even if it's empty**.
This is called a  **precise check**, and it saves us from weird edge cases.

Now try this out in our `IDE` yourself for hands-on clarity!

#### Common Mistake: Capital vs Lowercase Components

In JSX, lowercase tag names like `<div>` or `<button>` are treated as native HTML elements. But when you use a variable to define a tag—like choosing `"a"` or `"button"` based on a condition—you  **must capitalize**  the variable name (e.g., `Tag`). This tells React it's a component, not a literal tag.

Example:

```
const Tag = condition ? "a" : "button"; // Capitalized variable name
<Tag>Click Me</Tag> // Works as expected

```

If you used `<tag>`, React would look for an actual HTML tag called `<tag>`, which doesn't exist.

✅ Give it a try in our `IDE` for a hands-on experience!
Once you've completed this lesson, simply  **submit your work**, head over to the next tab, and  **keep learning**  at your own pace.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-01T10:49:27.123Z  

```cpp
function LinkButton({ href, children, className, ...props }) {
  const Tag = typeof href === "string" ? "a" : "button";

  return (
    <Tag
      href={href}
      className={className}
      {...props}
    >
      {children}
    </Tag>
  );
}

export default LinkButton;

```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR176)