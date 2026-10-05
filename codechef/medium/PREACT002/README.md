# PREACT002

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Your First React Application

Welcome! Now that you understand  **what React is and why it was created**, it’s time to build your very  **first React application**.

Think of this as the foundation of everything you’ll learn. We’ll build a simple  **"Hello World"**  app using  **pure JavaScript and React**  without any extra setup. This will help you understand how React works behind the scenes.

### Step 1: Setting Up Files

To begin, create two files:

- index.html – The main HTML file (where our React app will run).
- index.js – The JavaScript file to write our React code.
### Step 2: Writing the Code
#### index.html

This file will be a simple HTML structure that includes a placeholder, where our React code will display content.

##### Explanation:
- We create a basic HTML file.
- The <div id="root"></div> acts as a container for our React application.
- We include a script tag to load our index.js file.
#### index.js

This file contains  **React code**  that will run inside our HTML file.

#### Explanation:
- Selecting the Root Element:
- document.querySelector('#root') selects the <div id="root"></div> from index.html.
- Creating a React Element:
- React.createElement("h1", null, "Hello, React World!") creates an <h1> element with the text "Hello, React World!".
- This is a fundamental React concept called the Virtual DOM. Instead of manipulating the real DOM directly, React updates a virtual representation first.
- Rendering the Application:
- ReactDOM.createRoot(root) initializes React inside our root element.
-.render(element) tells React to render our <h1> inside the root div.
### How Does This Work?

When this code runs in the browser:

- The browser loads the index.html file.
- React finds the <div id="root"></div>.
- React creates a virtual <h1> element with "Hello, React World!".
- React updates the DOM and displays our message inside the root div.

Now, go ahead and  **run the code**  to see it in action! 🔥
Click the submit button if you want to go to the next question.

## Solution

**Language:** html  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T09:17:09.445Z  

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My First React App</title>
</head>
<body>
    <!-- The root div where React will render -->
    <div id="root"></div>

    <!-- Load React and ReactDOM CDN (for quick setup without installing anything) -->
    <script src="https://unpkg.com/react@18/umd/react.development.js"></script>
    <script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js"></script>
    
    <!-- Load our JavaScript file -->
    <script src="index.js"></script>
</body>
</html>
```

---

[View on CodeChef](https://www.codechef.com/problems/PREACT002)