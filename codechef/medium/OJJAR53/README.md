# OJJAR53

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### JSX Expressions and Attributes in React

`JSX` (JavaScript XML) is a syntax extension for `JavaScript` that allows us to write `HTML` inside our `JavaScript` code, which is particularly useful when working with React. However, `JSX` doesn’t treat everything like standard `JavaScript`. Let’s break down some essential features of `JSX` in an easy-to-understand way.

#### Rendering Dynamic Data in JSX

When you place content inside HTML-like tags in JSX, it is treated as a  **static string**. If you try to insert a variable, JSX will print the variable name instead of its value.

To include  **dynamic content**, you need to use  **curly brackets `{}`**. This tells JSX to evaluate the expression inside.

 **Example: Using Expressions in JSX** 

```
const topics = ["Code", "Chef", "React"]; 

const element = (
  <div> 
    Learning {topics[2]} with {topics[0] + topics[1]},  
    Random Number: {Math.floor(Math.random() * 100)} 
  </div> 
);

```

 **JSX Converts This To:** 

```
const compiledElement = React.createElement(
  "div", 
  {}, 
  "Learning ", topics[2], 
  " with ", topics[0] + topics[1], 
  ", Random Number: ", Math.floor(Math.random() * 100)
);

```

 **What Happens Here?** 
We can write `JavaScript` inside of `JSX`, so:

- We access topics[2], which gives "React".
- We concatenate topics[1] + topics[2], resulting in "CodeChef".
- We call Math.floor(Math.random() * 100), generating a random number (0-99).
### Task

Write a `React` `JSX` expression that displays a dynamic welcome message using a `username` stored in a variable. Additionally, include the  **current year**  in the message dynamically using `JavaScript`. Only use one `<div></div>` and write everything inside it.

#### Example Output:

If the username is `"Alex"`, and the current year is `2025`, the JSX should render:
 **"Welcome, Alex! Happy 2025!"** 

Submit your code to check if it's correct or not

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:02:19.892Z  

```cpp
import React from 'react';
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR53)