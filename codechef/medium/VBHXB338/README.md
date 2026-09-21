# VBHXB338

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Implementing the Create Blog Feature

Okay, we're making excellent progress! We've got user authentication handled, and now we can distinguish between logged-in and logged-out users, even protecting routes for authenticated access.

The next logical step is to allow logged-in users to  **create new blog posts**. This will involve building the form on the frontend and, for the first time, creating an API endpoint on the backend specifically for blog post creation, which will require authentication.

 **Objective:**  To build the complete functionality for creating a new blog post, from the frontend form submission to the backend API that saves the post to the database under the logged-in user's name.

 **Note:**  In backend/server.js, the route is already mounted:

```
// Mount blog routes
app.use('/api/blogs', blogRoutes);

```

So no need to add this again.

 **Task:** 
Your task is to implement the "Create Blog" functionality across both frontend and backend:

 **Part 1: Backend API for Blog Creation** 

- Create Authentication Middleware (backend/middleware/authMiddleware.js): Create a new directory backend/middleware/. Inside backend/middleware/, create a file named authMiddleware.js. Import jsonwebtoken and your User model. Define an authenticateToken middleware function that: Extracts the JWT from the Authorization header (Bearer TOKEN). If no token is found, sends a 401 (Unauthorized) status. Verifies the token using jwt.verify() with process.env.JWT_SECRET. If the token is invalid or expired, sends a 403 (Forbidden) status. If valid, decodes the token payload (which contains the userId) and attaches the user object (e.g., { id: userId }) to req.user. Calls next() to proceed to the next middleware/route handler.
- Create Blog Routes File (backend/routes/blog.js): Create a new directory backend/routes/. Inside backend/routes/, create a file named blog.js. Import express, your Blog model, and your new authenticateToken middleware. Define a POST route for the root path (/). This route will be for creating a new blog post. Apply the authenticateToken middleware to this route. This ensures only logged-in users can create blogs. Extract title and content from req.body. Perform validation: ensure title and content are provided. Send a 400 status if missing. Create a new Blog instance. The author field should be set to req.user.id (which is the ID of the authenticated user from the JWT). Save the new blog post to the database. Upon successful creation, send a 201 (Created) status response with the saved blog data. Include a try...catch block for error handling.
- Update Main Server File (backend/server.js): Import the new blogRoutes from backend/routes/blog.js. Mount these blogRoutes under the /api/blogs path using app.use('/api/blogs', blogRoutes).

 **Part 2: Frontend "Create Blog" Page** 

- Implement "Create Blog" Page (frontend/src/pages/CreateBlog.jsx): Remove the placeholder content. Use React's useState hook to manage the input values for title and content. Include state for error messages and loading status for the form submission. Create a basic HTML <form> structure with input fields for title (type text) and content (a textarea). Both should be required. Add a submit button. Implement an async handleSubmit function: Prevent default form submission. Set loading to true and clear any previous error. Use your API utility (API.post('/blogs', { title, content })) to send the new blog data to your backend API. On successful creation, use useNavigate from react-router-dom to redirect the user (e.g., to /my-blogs). On failure, catch the error and set an error message. Ensure loading is set back to false in a finally block. If you are using our provided CSS, wrap the form content in a div with className="form-container", and the form itself with className="blog-form".
- Styling for Forms (frontend/src/pages/FormPage.css): Create frontend/src/pages/FormPage.css and use the provided CSS. You can, of course, write your own styles if you prefer.
 **Click to get the FormPage.css!** 

 **Your App should be work like this**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T08:44:18.267Z  

```cpp
.error-message {
    color:  #dc3545; /* Red color for error messages */
    margin-top: 15px;
    font-size: 0.9em;
    text-align: center;
}
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB338)