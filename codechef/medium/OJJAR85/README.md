# OJJAR85

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Forms in React

 **Your goal** : Complete this React component to create a live typing display that also responds to button clicks. When finished:

- Whatever users type should instantly appear in both the input field AND the display below
- Clicking the button should update BOTH the input field and displayed text with random characters

Certainly! Let's simplify it:

### Steps to Create a Live Typing Display in React
- Setup State Use useState to create a value variable and setValue function. Start value as an empty string ("").
- Input Field Add value={value} to the <input> to show the current value. Use onChange={(e) => setValue(e.target.value)} to update value as you type. Add a placeholder like "Type something...".
- Random Text Generator Complete the generateRandomString function with: const randomStr = Math.random().toString(36).substring(2, 8); Then use setValue(randomStr) to update both the input and display
- Display Value Use <p>Live Display: {value}</p> inside a div to show the current text.
- Button Add onClick={generateRandomString} to the button. Label the button "Generate Random String".

Now you have a component that displays what you type and can generate random text with a click!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:16:13.076Z  

```cpp
const [value, setValue] = useState("");
const generateRandomString = () => {
const randomStr = Math.random().toString(36).substring(2, 8);
setValue(randomStr);
};
return (
<div className="container">
<input
type="text"
value={value}
onChange={(e) => setValue(e.target.value)}
placeholder="Type something..."
/>
<div className="output-box">
<h3>Live Display: {value}</h3>
</div>
<button className="btn" onClick={generateRandomString}>
Generate Random String
</button>
</div>
);
}

```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR85)