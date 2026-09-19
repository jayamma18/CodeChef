# FYAOAZ02

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Display Welcome Message with EJS

Alright, let's dive into setting up EJS (Embedded JavaScript templates) in our Node.js application! We've already learned how to create servers using the `http` module and, more recently, how to streamline our workflow with Express. Now, we'll use EJS to make our web pages dynamic by embedding JavaScript within our HTML.

Think of it this way: so far, we've been sending static HTML files or simple text responses. But what if we want to display data from our server, like a user's name or a list of items? That's where template engines like EJS come in.

EJS allows us to create HTML templates that can include JavaScript code. This code can then be executed when the server renders the page, allowing us to insert dynamic content.

Here's how we set it up using Express, building on our previous knowledge:

 **1. Configure Express to Use EJS:** 

Next, we need to tell our Express application to use EJS as its view engine. We do this in our main application file (usually `app.js` or `index.js`).

Let's break down the important lines:

- app.set('view engine', 'ejs');: This line tells Express to use EJS for rendering views.
- app.set('views', path.join(__dirname, 'views'));: This line (optional but recommended) specifies the directory where our EJS template files will be stored. path.join(__dirname, 'views') constructs an absolute path to a directory named "views" in our project's root directory. We are using the path module here.

 **2. Create a `views` Directory (if you haven't already):** 

If you included the `app.set('views',...)` line, you'll need to create a directory named `views` in the root of your project. This is where we'll put our EJS files.

 **3. Create an EJS Template File:** 

Inside the `views` directory, let's create our first EJS file. We'll call it `index.ejs`.

This is a basic HTML file. Notice the `.ejs` extension. This tells Express that it's an EJS template.

 **4. Render the View:** 

Now, let's go back to our route handler in `app.js` and use `res.render()` to render the `index.ejs` file.

The `res.render()` function is provided by Express. It takes the name of the view file (without the `.ejs` extension) as its first argument. Express will look for this file in the `views` directory (or the directory we specified using `app.set('views')`).

 **Putting it all together:** 

- We configured Express to use EJS as the view engine using app.set('view engine', 'ejs');.
- We optionally set the views directory using app.set('views', path.join(__dirname, 'views'));.
- We created a views directory and an index.ejs file.
- We used res.render('index') in our route handler to render the view.
#### Task:

Install the ejs dependency using the terminal.(Shortcut for terminal is  **crtl+`**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T05:38:19.806Z  

```cpp
<!DOCTYPE html>
<html>
<head>
    <title>My First EJS Page</title>
</head>
<body>
    <h1>Welcome to my website!</h1>
</body>
</html>

```

---

[View on CodeChef](https://www.codechef.com/problems/FYAOAZ02)