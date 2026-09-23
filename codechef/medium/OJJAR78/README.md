# OJJAR78

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Understanding Event Handlers in React

Imagine you're building a game where players can earn or lose points. You have a function that updates the current score. However, when working with event handlers in React, you might run into an issue where you need to pass arguments to a function when a button is clicked.

Let's start with this function:

```
function addPoints(points) {
  // Update the score here
}

```

 **The Problem** 
If you pass `addPoints` directly to the `onClick` event, React will call the function  **without any arguments**, meaning you can't specify how many points to add.

 **Wrong Approach:** 

```
<button onClick={addPoints}>Add Points</button>

```

Since we need to pass arguments (`5` or `10`), a direct reference like `onClick={addPoints}` won't work.

 **The Solution: Using an Arrow Function** 
To ensure arguments are passed correctly  **when**  the button is clicked, wrap the function inside an arrow function:

```
<button onClick={() => addPoints(5)}>+5 Points</button>
<button onClick={() => addPoints(10)}>+10 Points</button>

```

When the button is clicked, the arrow function executes, calling `addPoints(5)` or `addPoints(10)`, updating the score correctly.

### Your Task

In the IDE we have three functions, Each function prints a message  **(in console of your browser)**  when called.  **But**  we need to attach them to buttons  **correctly**  using event handlers so, Create  **three buttons**  and link them to the event handlers above:
1️⃣ A  **"+5 Points"**  button that calls `addPoints(5)` when clicked.
2️⃣ A  **"-3 Points"**  button that calls `subtractPoints(3)` when clicked.
3️⃣ A  **"Reset"**  button that calls `resetScore()` when clicked.

 **⚠️ Remember:** 

- Wrap addPoints(5) and subtractPoints(3) inside an arrow function in the onClick event.
- Do NOT call resetScore inside an arrow function since it has no arguments.

 **About Console** 
The console is a tool in your browser that allows developers to log messages, debug code, and view errors. You can open it by pressing  **F12**  or  **Ctrl + Shift + J**  (Windows) /  **Cmd + Option + J**  (Mac). Any  **`console.log()`**  statements in your JavaScript code will appear here, making it a great tool for testing and debugging your application.

In our CodeChef-friendly interface, you can also track JavaScript outputs in real time using the console at the bottom of your browser.

- Click the button at the bottom to open or close the console.
- When you interact with the buttons in this exercise, messages will appear in the console.
- Use this feature to debug and understand your event handlers.

Try clicking the buttons and see how the console responds!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:03:16.508Z  

```cpp
                                                        <button onClick={resetScore}>Reset Score</button>
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR78)