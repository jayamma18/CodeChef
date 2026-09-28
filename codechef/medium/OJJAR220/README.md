# OJJAR220

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### HeadlessUI Portals

Imagine your React app is like a big treehouse built inside a single, large tree (`<div id="root">`). Every component you create adds a branch or a room  *inside*  that main treehouse structure.

```
<!-- index.html -->
<body>
  <div id="root">
    <!-- Your entire React app renders here -->
  </div>
</body>

```

 **The Problem: Getting Stuck in the Treehouse** 

Now, let's say you build a `Modal` component. You want this modal to pop up  *above everything else*  on the screen, like a floating balloon tethered to the ground, not just another room  *inside*  the treehouse.

You might use CSS like `position: fixed` to make it float. Usually, this works great.

 *But*, sometimes, one of the  *parent*  components way up the tree (maybe a `Header` or a `Sidebar`) has some specific CSS styles (like `transform`, `filter`, or `will-change`). These styles can unexpectedly create a new boundary, like putting a glass ceiling on one of the treehouse levels.

Even though your modal has `position: fixed`, it gets trapped  *under*  that glass ceiling! It can't float freely relative to the whole window anymore; it's stuck relative to that parent component with the tricky CSS. This breaks the modal's appearance and behavior.

You  *don't*  want to worry about whether some distant ancestor component might accidentally break your modal with an obscure CSS rule. That makes using the `Modal` component fragile and complicated.

 **The Solution: React Portals (Teleportation!)** 

React Portals offer a clever solution: they let you  *teleport*  the  *final HTML output*  of a component to a  *different location*  in the DOM, outside the main React app treehouse.

Think of it like this:

- You still define your Modal component inside its parent (like the Header) in your React code. This keeps your code organized and logical (the button that opens the modal is right next to the modal component itself in the code).
- But when React actually renders the modal to the browser's screen (the DOM), you use a Portal to tell React: "Hey, don't put the HTML for this modal inside the <div id="root"> treehouse. Instead, teleport it over to this other special spot I made."

 **How to Use Portals** 

- Create a Target Spot in HTML: First, you need to create that separate spot in your main index.html file, outside the main <div id="root">. It's common to use an ID like modal-root. <!-- public/index.html --> <!DOCTYPE html> <html> <head> <title>My App</title> </head> <body> <div id="root"></div> <!-- Your main app goes here --> <div id="modal-root"></div> <!-- Portals can target this! --> </body> </html>
- Use createPortal in Your Component: Inside the component you want to teleport (e.g., your Modal component), you import createPortal from react-dom and use it in your return statement. // Modal.js import React from 'react'; import { createPortal } from 'react-dom'; // Import from react-dom! // Find the portal target DOM node (do this once, ideally) const modalRoot = document.getElementById('modal-root'); function Modal({ children, title, handleDismiss }) { // Your modal's JSX structure const modalContent = (<div className="modal-backdrop" onClick={handleDismiss}> <div className="modal-dialog" role="dialog" aria-modal="true" aria-label={title}> {/ *Prevent clicks inside the dialog from closing it* /} <div onClick={(e) => e.stopPropagation()}> <h2>{title}</h2> <button onClick={handleDismiss}>Close</button> <hr /> {children} </div> </div> </div>); // Use createPortal to teleport the modalContent // It takes two arguments: // 1. The React element(s) to render (your JSX) // 2. The actual DOM node where you want to render them return createPortal(modalContent, modalRoot); } export default Modal;

 **What Happens Now?** 

- In your React Code: The <Modal> component still lives logically within its parent (e.g., <Header>). State, props, and context flow normally within the React tree.
- In the Browser's DOM: When you inspect the elements, you'll see the modal's HTML (<div class="modal-backdrop">...</div>) rendered directly inside <div id="modal-root">, completely separate from the main <div id="root"> structure.

 **Now It's Your Turn: Try It in the `IDE`!** 
We’ve already wired up this setup for you in the `IDE`. Go check out the code there—see how the `Modal` is defined and how it's using a portal to render cleanly outside the app root. Try modifying it, break it, fix it again—and watch how it behaves in different situations. This hands-on play will help the concept really click.

 **Why is this Better?** 

Because the modal's HTML is now in `<div id="modal-root">`, it's no longer a descendant of the `<header>` (or any other component inside `<div id="root">`) in the  *DOM tree*. This means those tricky CSS properties on ancestor components inside `<div id="root">` can no longer trap it! The modal is free to be positioned relative to the viewport using `position: fixed` without interference.

 **Key Takeaways:** 

- Problem: Ancestor CSS (like transform) can create stacking contexts that trap position: fixed elements like modals.
- Solution: React Portals let you render a component's HTML output into a different part of the DOM tree.
- How: Add a target <div> (e.g., <div id="modal-root">) in your index.html outside <div id="root">. Use createPortal(jsx, domNode) from react-dom in your component to specify what to render and where to render it in the DOM.
- Benefit: Keeps your React component structure logical while allowing the rendered DOM elements to escape CSS traps, making components like modals more robust.

You won't use `createPortal` directly every day, especially if you use UI libraries (they often use portals internally for their Modals, Dropdowns, Tooltips, etc.), but knowing  *how*  and  *why*  they work is crucial for understanding how these common UI patterns are built reliably in React.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T08:54:20.812Z  

```cpp
import { useState } from 'react';
import Modal from './Modal';

function App() {
const [isModalOpen, setIsModalOpen] = useState(false);

const handleOpenModal = () => {
setIsModalOpen(true);
};

const handleCloseModal = () => {
setIsModalOpen(false);
};

return (
<div>
<h1>React Portal Demo App</h1>
<p>
This button is part of the main application rendered inside #root.
Clicking it will open a modal.
</p>
<button onClick={handleOpenModal}>Open Modal</button>

<p style={{ marginTop: '20px' }}>
Notice the light-gray background? That's the #root div.
If you inspect the elements, the modal will appear OUTSIDE this div,
directly inside the body (in #modal-root).
</p>

{isModalOpen && (
<Modal title="My Teleported Modal" onClose={handleCloseModal}>
<p>Hello from inside the portal!</p>
<p>
Even though this Modal component is written here inside App.js,
its actual HTML is rendered into the <code>#modal-root</code> div
in <code>index.html</code>, thanks to <code>createPortal</code>.
</p>
<button onClick={handleCloseModal}>Close From Inside</button>
</Modal>
)}

<div style={{ marginTop: '300px', border: '2px dashed red', padding: '10px' }}>
This content is lower down in the #root div. The modal appears *above* everything,
not stuck inside the flow here.
</div>
</div>
);
}

export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR220)