# OJJAR221

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Portal-Based Toast Notification

Understand how and why to use React Portals to render UI elements outside their parent component's DOM hierarchy.

 **Task Statement** 

You are given a simple feedback form. Currently, when you submit the form, nothing happens visually besides a console log.

Your task is to:

- Identify the Portal Target: In public/index.html, notice the <div id="toast-root"></div>. This is where we want our toast notifications to appear in the final HTML, separate from the main application in <div id="root">.
- Modify the Toast Component (src/Toast.js): Import createPortal from react-dom. (Look here: // TASK 1:...) Get a reference to the <div id="toast-root"> DOM element. (Look here: // TASK 2:...) Modify the Toast component's return statement to use createPortal. You need to wrap the existing JSX (or the JSX you create for the toast) inside createPortal, telling it to render into the #toast-root element you found. (Look here: // TASK 3:...)
- Style the Toast: Add CSS rules in src/index.css to make the div with the class toast-notification (which you'll use inside Toast.js) look like a toast (e.g., fixed position at the bottom-right, background color, padding). (Look near: / *--- TASK 4: Add Toast Styles Below ---* /)
- Observe: After implementing the portal and CSS, submit the form. The toast should appear floating in the bottom-right corner, even though the <Toast> component is rendered conditionally within the App component in your React code. Inspect the browser's Elements panel to see the toast's HTML inside <div id="toast-root">.

 **Why Portals Here?**  Imagine the main `#root` container had some weird `transform` or `z-index` CSS applied. A normally positioned toast  *inside*  `#root` might get clipped or hidden unexpectedly. By porting the toast to `#toast-root` (a direct child of `<body>`), we ensure it renders in its own stacking context, avoiding potential CSS conflicts with the main app structure.

 **Your App should be look like this at the end**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T08:58:06.737Z  

```cpp
import { useState, useEffect } from 'react';
import Toast from './Toast.jsx';

function App() {
const [name, setName] = useState('');
const [message, setMessage] = useState('');
const [showToast, setShowToast] = useState(false);
const [toastMessage, setToastMessage] = useState('');

const handleSubmit = (event) => {
event.preventDefault();
console.log('Form Submitted:', { name, message });

setToastMessage(`Thanks, ${name}! Your message was sent.`);
setShowToast(true);

setName('');
setMessage('');
};

useEffect(() => {
let timer;
if (showToast) {
timer = setTimeout(() => {
setShowToast(false);
}, 3000);
}

return () => clearTimeout(timer);
}, [showToast]);

return (
<div>
<h1>Feedback Form</h1>
<form onSubmit={handleSubmit} className="feedback-form">
<div>
<label htmlFor="nameInput">Name:</label>
<input
id="nameInput"
type="text"
value={name}
onChange={(e) => setName(e.target.value)}
required
/>
</div>
<div>
<label htmlFor="messageInput">Message:</label>
<textarea
id="messageInput"
value={message}
onChange={(e) => setMessage(e.target.value)}
required
/>
</div>
<button type="submit">Submit Feedback</button>
</form>

{showToast && (
<Toast
message={toastMessage}
onClose={() => setShowToast(false)}
/>
)}
</div>
);
}

export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR221)