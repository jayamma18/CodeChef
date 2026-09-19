# FYAOAZ03

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Display a Website Tagline

 **Problem:** 
You need to modify the `index.ejs` file to display a tagline for your website below the main heading. The tagline should be:

 **"The best place to learn web development!"** 
 **Tasks:** 

- Add a <p> tag: Open the index.ejs file inside the views directory. Add a new paragraph (<p>) tag immediately below the existing <h1> tag.
- Insert the tagline: Put the text "The best place to learn web development!" inside the new <p> tag.
- Complete the index.js file: Make sure your index.js (or app.js) file sets up an Express server that: Uses EJS as the templating engine, Sets the views directory correctly, Defines a route for the homepage (/) that renders the index.ejs template, Starts the server on port 3000 and logs a message indicating the server is running.

 **Expected Output:** 

- A heading that says: Welcome to my website!
- Directly below it, the tagline: The best place to learn web development!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T05:50:44.445Z  

```cpp
// write your code here
const express = require('express');
const path = require('path');
const app = express();

// Set EJS as the view engine
app.set('view engine', 'ejs');

// Set the views directory
app.set('views', path.join(__dirname, 'views'));

// Route for homepage
app.get('/', (req, res) => {
    res.render('index');
    });

    // Start the server
    const PORT = 3000;
    app.listen(PORT, () => {
        console.log(`Server is running on port ${PORT}`);
        });
```

---

[View on CodeChef](https://www.codechef.com/problems/FYAOAZ03)