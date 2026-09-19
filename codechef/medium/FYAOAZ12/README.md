# FYAOAZ12

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Dynamic Footer Partial

Great! You've learned how to use layouts and partials to create reusable components in your EJS templates. Now, let's practice with another common scenario: creating a dynamic footer.

Imagine you want to display the current year in your website's footer, and you want to avoid manually updating it every year. You can achieve this by creating a footer partial and passing the current year as data from your Express route.

Here's the problem:

- You have an existing layout.ejs file that sets up the basic HTML structure.
- You need to create a footer.ejs partial inside the views/partials directory to hold the footer HTML.
- The footer should display a copyright message including the current year (e.g., "© 2024 My Website").
- You need to modify layout.ejs to include the footer.ejs partial.
- Finally, you need to update your Express routes to pass the current year to the view when rendering pages.

Let's walk through the steps you'll need to take:

 **Step 1: Create the `footer.ejs` Partial** 

Create a new file named `footer.ejs` inside the `views/partials` directory. This file will contain the HTML for your footer.

 **Step 2: Modify `layout.ejs` to Include the Footer Partial** 

Next, modify your `layout.ejs` file to include the `footer.ejs` partial. Place the include statement at the bottom of the `body` tag, where you want the footer to appear.

 **Step 3: Update Express Routes to Pass the Current Year** 

Now, update your Express routes to pass the current year as data to the view when rendering each page. You can use the `Date` object in JavaScript to get the current year.

Remember to test your solution by running your application and viewing the footer on different pages. It should display the current year dynamically.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:22:47.433Z  

```cpp
<footer>
  <p>© <%= currentYear %> My Website</p>
</footer>

```

---

[View on CodeChef](https://www.codechef.com/problems/FYAOAZ12)