# OJJAR95

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Build a Simple To-Do List App

Follow these steps to complete the to-do list app. Don't worry - we'll take it step by step!

- Set Up the Tasks State In the App component, create a state variable called tasks using useState. Initialize it with an empty array.
- Create Add Task Function Complete the addTask function: it should take a new task as input and add it to the tasks array. Make sure empty tasks can't be added.
- Create Remove Task Function Complete the removeTask function: it should take an index (position number) and remove that task from the tasks array.
- Build the Input Component In TaskInput, add a state to track the input value using useState. Connect this state to the input field (when you type, it should update the state). When the "Add" button is clicked: Pass the current input value to addTask Clear the input field
- Display the Task List In TaskList, use the tasks array passed via props. Use.map() to display each task as a list item. For each task, add a "Remove" button that uses the task's index to call removeTask.
#### Tips:
- Remember to pass props between components (like tasks and removeTask)
- Use the array index to help remove the correct task
- Use filter() method when removing tasks
- You'll know it's working when you can add new tasks and remove them by clicking the buttons!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:26:08.793Z  

```cpp
import React, { useState } from "react";
export function TaskInput({ addTask }) {
const [inputValue, setInputValue] = useState("");
const handleAdd = () => {
if (inputValue.trim() !== "") {
addTask(inputValue.trim());
setInputValue("");
}
};
return (
<div>
<input
type="text"
placeholder="Enter a task..."
value={inputValue}
onChange={(e) => setInputValue(e.target.value)}
/>
<button onClick={handleAdd}>Add</button>
</div>
);
}
export function TaskList({ tasks, removeTask }) {
return (
<ul>
{tasks.map((task, index) => (
<li key={index}>
{task}
<button onClick={() => removeTask(index)}>Remove</button>
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR95)