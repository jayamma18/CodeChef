# VBHXB337

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Activating & Protecting User-Specific Navbar Links

Excellent! We've completed the core authentication flow – users can now register and log in. The Navbar already dynamically shows "Welcome, [username]!" and "Logout" when a user is authenticated, which is great progress.

Now, let's make those logged-in user options functional and visible. We'll enable the "Create Blog" and "My Blogs" links, and introduce the concept of protected routes to ensure only authenticated users can access them.

 **Objective:**  To make the "Create Blog" and "My Blogs" links in the Navbar functional for authenticated users, and to implement route protection so these pages are only accessible when a user is logged in.

 **Context:** 

- You have a fully functional authentication system (registration, login, logout) with AuthContext managing the user state.
- Your Navbar.jsx already conditionally renders content based on the user's authentication status.

 **Task:** 
Your task is to activate these user-specific features:

- Update Navigation Bar (frontend/src/components/Navbar.jsx): Locate the commented-out Link elements for "Create Blog" and "My Blogs" within the authenticated user block. Uncomment these links. They should point to /create and /my-blogs respectively.
- Create Placeholder Page Components: Create a new file frontend/src/pages/CreateBlog.jsx. For now, it should just be a simple component displaying a heading like "Create New Blog" within a.container div. Create a new file frontend/src/pages/MyBlogs.jsx. Similarly, it should display a heading like "My Blogs" within a.container div.
- Implement a Private Route Component (frontend/src/components/PrivateRoute.jsx): Create a new file frontend/src/components/PrivateRoute.jsx. Import Navigate and Outlet from react-router-dom, and useAuth from your AuthContext. This component should check if useAuth().user is truthy (meaning a user is logged in). If a user is logged in, it should render an Outlet (which will render the nested child routes). If no user is logged in, it should redirect them to the /login page using Navigate (with replace).
- Update Application Routes (frontend/src/App.jsx): Import the new PrivateRoute, CreateBlog, and MyBlogs components. Wrap the routes for /create and /my-blogs within a Route element that uses your PrivateRoute component. This makes these routes "protected".

 **Your App should be work like this**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T08:30:13.638Z  

```cpp

const MyBlogs = () => {
    return (
        <div className="container">
            <h1>My Blogs</h1>
            <p>This page will show only the blogs you have created.</p>
        </div>
    );
};

export default MyBlogs;
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB337)