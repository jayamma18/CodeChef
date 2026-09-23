# OJJAR56

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Inline Styles in JSX

In JSX, styles are applied using an object with camelCase property names, differing from regular HTML, where styles are written as strings.

#### 1. Inline Styles in JSX

In  **HTML**, styles are written as a string:

```
<h1 style="color: red;">Hello World!</h1>

```

In  **JSX**, styles are passed as an object inside double curly brackets `{ { } }`:

```
<h1 style={{ color: 'red' }}>Hello World!</h1>

```

🔹 The first `{}` tells React you're writing JavaScript.
🔹 The second `{}` contains the style object with key-value pairs.

#### 2. CamelCase for CSS Properties

Notice `background-color` in HTML became `backgroundColor` in JSX? In JavaScript objects, you can't have hyphens in property names. So, CSS properties like `font-size` or `text-align` become `fontSize` and `textAlign` in JSX style objects. This "camelCase" naming is standard.

#### 3. React Automatically Appends "px"

For certain properties, React assumes `"px"` if you pass a number:

```
<div style={{ width: 200 }}>Hello</div>  
// React interprets this as width: 200px

```

However, some properties (e.g., `lineHeight` and `opacity`) do not assume `"px"`:

```
<p style={{ lineHeight: 20 }}>Hello</p>  
// React treats this as 20, not 20px

```

To explicitly ensure `"px"`, provide the value as a  **string** :

```
<p style={{ lineHeight: '20px', backgroundColor: 'lightblue' }}>Hello</p>

```

### Task: Apply Inline Styles in JSX

In this task, you will create a React component that applies inline styles to a `<div>`.

 **Task Requirements:** 
Update the component named `StyledBox` that:

- Has a width of 200px.
- Has a height of 100px.

Click "Submit" to check your solution!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:04:38.659Z  

```cpp
import React from 'react';
export default function App() {
return (
<div
style={{
width: '200px',
height: '100px',
backgroundColor: 'lightblue',
color: 'white',
display: 'flex',
justifyContent: 'center',
alignItems: 'center',
fontSize: '18px'
}}
>
Styled Box
</div>
);
}

```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR56)