# OJJAR188

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Header Component

Okay, fantastic! You've laid the groundwork by creating all our component files.

Now, let's make our very first component, the  **Header**, actually show up on a webpage!

 **Problem Statement:** 

Your application requires a navigation header.

In this project, we will build our Header component.

You need to create five `<a>` tag-based headings. Each heading should act as a navigation link that points to a specific section on the same webpage.

Example:

- A link with the text 'Home' that navigates to #hero.
- A link with the text 'About' that navigates to #about.
- A link with the text 'Projects' that navigates to #projects.
- A link with the text 'Blog' that navigates to #blog.
- A link with the text 'Contact' that navigates to #contact.

All of these links must be placed inside a `<header></header>`, `<nav></nav>` element with the class name `"app-header"`.
 **Example** 

```
<header className="app-header">
  <nav>
    <a href="#home">Home</a>
    <a href="#about">About</a>
   ...
  </nav>
</header>

```

 **Your app should be look like this**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-03T05:56:08.464Z  

```cpp

function Header() { 
  return (
    <div>
      <p>This is the Header component.</p> 
    </div>
  );
}

export default Header;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR188)