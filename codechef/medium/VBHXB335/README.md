# VBHXB335

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Building & Integrating the User Login API

Alright, we've successfully implemented user registration and connected it to our backend! Now, it's time to complete the authentication loop by building the login functionality. This involves creating the login API on the backend and integrating it with our existing frontend `AuthForm` and `AuthContext`.

 **Objective:**  To enable users to log into our application. This requires implementing the login API endpoint on the backend and connecting it to our reusable frontend `AuthForm` and the global `AuthContext`.

 **Task:** 
Your task is to build the backend login API and integrate it with the frontend.

- Add Login Route (backend/routes/auth.js): Inside backend/routes/auth.js, define a new POST route for /login. This route should: Extract username and password from req.body. Perform basic validation: ensure both are provided. If not, send a 400 status. Find the user by username in the database. If no user is found, send a 400 status (e.g., "Invalid credentials"). If a user is found, use the user.matchPassword() method (from step 1) to compare the provided password with the stored hashed password. If they don't match, send a 400 status ("Invalid credentials"). If credentials are valid, generate a JSON Web Token (JWT) using jsonwebtoken.sign(). The payload should include the user's _id. Use process.env.JWT_SECRET and set an expiration (e.g., expiresIn: '1h'). Send a 200 (OK) status response with a success message, the generated token, and the user's id and username. Include a try...catch block for error handling.
- Update Authentication Context (frontend/src/context/AuthContext.jsx): Implement an async login function within your AuthProvider. This function should: Accept username and password. Use your API utility to make a POST request to /auth/login. On success, store the received token in localStorage, update the user state, and set the Authorization header for all future API requests (API.defaults.headers.common['Authorization']). Return a { success: true } or { success: false, message: '...' } object. Include try...catch blocks for robust error handling. Make sure to pass this new login function in the AuthContext.Provider value prop.
- Update Authentication Form (frontend/src/components/AuthForm.jsx): In the handleSubmit function, add logic to call the login function from useAuth when the type prop is "login". Ensure that the loading and error state management (already implemented for registration) also applies correctly to the login process. On successful login, use navigate to redirect the user (e.g., to /my-blogs or back to /).

 **Your app should work like this in the end**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:54:01.678Z  

```cpp
        </AuthContext.Provider>
    );
};

// Custom hook to easily consume the authentication context
export const useAuth = () => useContext(AuthContext);
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB335)