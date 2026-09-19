# FYAOAZ14

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Favorite Color Form

Okay, let's solidify your understanding of form handling with a worked example. We'll create a simple form where users can submit their favorite color. This will help you see how the different pieces – the EJS template, the form, and the Express route – fit together.

Here's the problem: We want to create a webpage with a form that asks the user for their favorite color. When the user submits the form, we want to display a message on the page saying, "Your favorite color is: [the color they entered]".

Notice a few key things:

- action="/favorite-color": This tells the form to send the data to the /favorite-color route.
- method="POST": We're using the POST method to send the data.
- name="color": This is the name of the input field, which we'll use to access the data on the server.
- <% if (locals.favoriteColor) { %>... <% } %>: This EJS code checks if a variable named favoriteColor exists in the template's scope. If it does (meaning the form has been submitted and we've passed the color back to the template), it displays the message "Your favorite color is: [the color]".

Let's walk through this code:

- We include express.urlencoded({ extended: false }) middleware to parse the form data.
- The app.get('/favorite-color',...) route renders the favoriteColor.ejs template when a user visits /favorite-color.
- The app.post('/favorite-color',...) route handles the form submission: It extracts the value of the color input field from req.body. It renders the favoriteColor.ejs template again, but this time it passes an object { favoriteColor: favoriteColor } as the second argument to res.render(). This makes the favoriteColor variable available inside the template.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:23:28.740Z  

```cpp
const express = require('express');
const path = require('path');

const app = express();

// Middleware to parse form data
app.use(express.urlencoded({ extended: false }));

// Set EJS as the view engine
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

// Route to display the form
app.get('/favorite-color', (req, res) => {
    res.render('FavColor'); // no data passed on initial render
});

// Route to handle form submission
app.post('/favorite-color', (req, res) => {
    const favoriteColor = req.body.color; // extract color from form data
    console.log('The color submitted is:', favoriteColor);
    res.render('FavColor', { favoriteColor }); // re-render with color
});

// Start the server
app.listen(3000, () => {
    console.log('Server is running on http://localhost:3000');
});

```

---

[View on CodeChef](https://www.codechef.com/problems/FYAOAZ14)