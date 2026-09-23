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