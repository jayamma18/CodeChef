# FYAOAZ11

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Dynamic Page Titles and Reusable Navigation

Okay, let's solidify our understanding of layouts and partials with a practical example. We'll build upon the previous example and add a dynamic page title and a reusable navigation bar partial.

Imagine we want to display different titles on each page (like "Home", "About", "Contact") and we want a consistent navigation bar across our site. We can achieve this using layouts and partials. Sure! Here’s the full theory explanation  **in the exact format you gave**, showing  **which file is being explained**  and explaining only the important parts — no code, no steps, just clear understanding:

### What the Whole Code Is Doing

This project creates a multi-page website (Home, About, Contact) using EJS templates in Express. It uses a  **layout**  to provide a shared HTML structure and includes a  **navigation bar partial**  so the menu is consistent across pages.

Each page’s unique content is placed in separate view files. The layout wraps this content with the common structure and injects a  **dynamic page title**  sent from the server, allowing each page to have its own title shown in the browser tab.

This setup keeps the code modular, clean, and easy to maintain.

### layout.ejs

Defines the overall HTML structure common to all pages. It dynamically sets the page title based on data passed from Express. It includes the navigation bar partial so it appears on every page, and has a placeholder where unique page content is inserted.

### partials/navbar.ejs

Contains the navigation bar markup with links to Home, About, and Contact. Because it is included in the layout, this navigation menu is shared and consistent across all pages, reducing duplication and easing updates.

### index.ejs, about.ejs, contact.ejs

Each of these files contains the unique content for that specific page only. They do not repeat layout or navigation code. When rendered, their content is injected into the layout’s placeholder area.

### index.js

Handles the Express routes. Each route renders a specific view and passes a title variable for the layout to use dynamically. This connects the routes, views, and layout so each page has its own URL, content, and page title while sharing navigation and structure.

This approach enables:

- Reusable layouts and navigation partials
- Clean separation of page-specific content
- Dynamic page titles for better UX and SEO
- Easier maintenance and scalability

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:21:22.160Z  

```cpp
<footer>
    <p>© <%= currentYear %> My Website</p>
  </footer>
  
```

---

[View on CodeChef](https://www.codechef.com/problems/FYAOAZ11)