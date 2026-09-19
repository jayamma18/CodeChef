# VBHXB327

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Basic Navigation Bar

Okay, so very first we will build the navbar.
Your first task is to create a static navigation bar component for the blog application. This navbar will be purely presentational at this stage, displaying the application title and two navigation links: "Login" and "Create Account". It should be integrated into the main `App` component and should not have any dynamic behavior or logic related to authentication yet.

 **Objectives:** 

- Create a Navbar React component in src/components/Navbar.js.
- Implement the JSX structure for the navigation bar, including a brand link to the home page (/) and two static navigation links for "Login" and "Create Account".
- Apply basic styling in Navbar.css and ensure it is imported correctly. You can use the provided CSS or write your own styles, if you prefer.
 **Click to get the Navbar.css!** 

 **Your App should be look like this (Every text is link in this App)**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:48:18.075Z  

```cpp
import { Link } from 'react-router-dom';
import './Navbar.css'; // Create this file for basic styling

const Navbar = () => {

    return (
        <nav className="navbar">
            <div className="navbar-left">
                <Link to="/" className="navbar-brand">MERN Blog</Link>
            </div>
            <div className="navbar-right">
                <Link className="nav-link">Login</Link>
                <Link className="nav-link">Create Account</Link>
            </div>
        </nav>
    );
};

export default Navbar;
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB327)