# FYAOAZ15

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Name and Age Form

Great! You've just built a form to capture a user's favorite color. Now, let's try another one to solidify your understanding.

Here's the problem: We want to create a webpage with a form that asks the user for their name and age. When the user submits the form, we want to display a message on the page saying, "Hello, [name]! You are [age] years old."

Let's break this down step-by-step:

- Create the EJS Template: First, we need to create an EJS template that contains the form. This form will have two input fields: one for the name and one for the age, and a submit button. Create a new file named nameAgeForm.ejs inside your views folder.
- Write the HTML Form: Inside nameAgeForm.ejs, add the following HTML code:

```
<!DOCTYPE html>
<html>
<head>
    <title>Name and Age Form</title>
</head>
<body>
    <h1>Please enter your name and age:</h1>
    <form action="/submit-name-age" method="POST">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br><br>
        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age"><br><br>
        <button type="submit">Submit</button>
    </form>
    <% if (locals.greeting) { %>
        <p><%= greeting %></p>
    <% } %>
</body>
</html>

```

Notice a few key things:

- action="/submit-name-age": This tells the form to send the data to the /submit-name-age route.
- method="POST": We're using the POST method to send the data.
- name="name" and name="age": These are the names of the input fields, which we'll use to access the data on the server.
- <% if (locals.greeting) { %>... <% } %>: This EJS code checks if a variable named greeting exists in the template's scope. If it does (meaning the form has been submitted and we've passed the greeting back to the template), it displays the message.
- Set up the Express Routes: Now, let's set up the Express routes to handle the form. We need two routes: one to display the form and one to handle the form submission. Open your app.js (or whatever file you're using for your Express app) and add the following code: A route to render the form A route to handle form submission. This route should extract the name and age from req.body, construct the greeting message, and re-render the template passing the greeting message to the template.
- Run the Application and Test: Save both nameAgeForm.ejs and app.js. Run your Node.js application (e.g., using node app.js in your terminal). Open your web browser and go to http://localhost:3000/name-age. You should see the form. Enter your name and age and click "Submit". Observe the output in the browser.

Now, it's your turn! Try to write the code for the Express routes and modify your `app.js` file to handle the form submission and display the greeting message. Good luck!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:23:51.301Z  

```cpp
<!DOCTYPE html>
<html>
<head>
    <title>Name and Age Form</title>
</head>
<body>
    <h1>Please enter your name and age:</h1>
    <form action="/submit-name-age" method="POST">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br><br>
        
        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age"><br><br>
        
        <button type="submit">Submit</button>
    </form>

    <% if (locals.greeting) { %>
        <p><%= greeting %></p>
    <% } %>
</body>
</html>

```

---

[View on CodeChef](https://www.codechef.com/problems/FYAOAZ15)