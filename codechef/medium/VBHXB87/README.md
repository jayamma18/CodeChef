# VBHXB87

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Serving a Basic Website

Let's explore how a basic website is served using `express.static()` in an Express application. This setup includes an HTML page, CSS styling, and JavaScript interactivity — all served as static files from a `public` directory.

### Folder and File Structure
- server.js: This is the main Express server file. It initializes the server and uses Express middleware to serve static files.
- public/: This folder contains all the static assets — HTML, CSS, and JavaScript files. index.html: The main webpage loaded by the browser. style.css: Provides styling for the webpage elements. script.js: Adds interactivity, like responding to button clicks.
### File Explanations

 **`index.html`**  This is the entry point of the website. It defines the structure and content of the web page, such as:

- A heading welcoming users.
- A paragraph explaining the page purpose.
- A button with an id to which JavaScript is later attached.
- References to the CSS and JavaScript files to apply styling and behavior.

 **`style.css`**  This file contains CSS rules that style the HTML elements. It:

- Applies a sans-serif font to the page.
- Adds a light background color.
- Centers the text.
- Changes the color of the <h1> heading to a dark shade.

 **`script.js`**  This JavaScript file handles simple interactivity. It:

- Waits for a user to click the button on the page.
- When the button is clicked, it shows an alert with the message "Button Clicked!".

 **`server.js`**  This file sets up the Express server. It:

- Imports the express and path modules.
- Creates an Express application.
- Uses express.static() to serve any files in the public directory.
- Listens for incoming requests on port 3000, logging a message once the server is running.
### How It All Works Together

When the browser is shown, the server serves `index.html` from the `public` folder.

- The browser loads the HTML, applies styles from style.css, and executes the script in script.js.
- When you click the button, the browser triggers the event listener and shows an alert.

Visiting `http://localhost:3000/index.html` directly serves the same file, so you'll see identical output.

This example demonstrates the power of `express.static()` for serving front-end assets in a backend project.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-17T10:44:18.904Z  

```cpp
const express = require('express');
const path = require('path');
const app = express();
const port = 3000;

// Serve static files from the 'public' directory
app.use(express.static(path.join(__dirname, 'public')));

app.listen(port, () => {
    console.log(`Server listening on port ${port}`);
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB87)