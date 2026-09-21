# VBHXB334

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Integrating Frontend Registration with Backend API

Alright, your backend is now ready to receive new user registrations! This is a huge step. Now, let's connect our frontend registration form to this backend API, allowing users to actually create accounts.

#### Objective

To connect the frontend's "Create Account" form to the backend's user registration API. This involves creating a global authentication context and updating our UI components to send data to the server and reflect the user's login status.

#### Context

 **Quick update:**  I made a change to the project by creating an essential utility file for API communication: `frontend/src/utils/api.js`. This file configures a reusable `axios` instance to interact with the backend.

 **Please check the `api.js` file once.**  The `getBackendDomain()` function it contains is specifically designed to work in a production-like environment and is not configured for `localhost`. Keep this in mind during development.

When you need to call an endpoint like `/api/auth/register`, you can import the `API` object and use it directly. For example:

```
import API from '../utils/api';

const res = await API.post('/auth/register', { username, password });

```

Additionally, the main application structure in `frontend/src/App.jsx` has been set up for you. The `<Router>` is already wrapped with the `<AuthProvider>` component you will create. This ensures that the authentication context will be globally available to all components within the application.

```
// In App.jsx
<AuthProvider>
  <Router>
    {/ *... your application routes...* /}
  </Router>
</AuthProvider>

```

Alright, your backend is now ready to receive new user registrations! This is a huge step. Now, let's connect our frontend registration form to this backend API, allowing users to actually create accounts.

#### Task

Your task is to integrate the frontend registration flow with the backend API by completing the following steps:

- Create an Authentication Context (frontend/src/context/AuthContext.jsx): Update the AuthProvider component that will: Manage user state (to store logged-in user info) and loading state. Implement a register asynchronous function that: Accepts username and password. Uses your API utility to make a POST request to /auth/register. On success, stores the received token in localStorage and sets the user state. It should also set the Authorization header for all future API requests (API.defaults.headers.common['Authorization']). Returns a { success: true } or { success: false, message: '...' } object. Includes try...catch blocks for error handling. For now, implement a basic logout function that clears localStorage and resets user state. (Login will be added later). Use useEffect to check for an existing token and user data in localStorage on component mount, and if found, set the user state and Authorization header. This will keep the user logged in across page refreshes. Provide user, register, and logout through the AuthContext.Provider. Export the AuthProvider and a custom useAuth hook (useContext(AuthContext)).
- Update Authentication Form (frontend/src/components/AuthForm.jsx): Import useAuth from../context/AuthContext. Import useNavigate from react-router-dom to redirect the user after successful registration. Modify the handleSubmit function: When type is "register", call the register function from useAuth. Handle loading states (e.g., using a loading state and disabling the submit button). Handle success: If registration is successful, navigate the user to a new path (e.g., /my-blogs or /). Handle errors: If registration fails, display an error message (e.g., using an error state and rendering it in a <p> tag).
- Update Navigation Bar (frontend/src/components/Navbar.jsx): Import useAuth from../context/AuthContext. Conditionally render the "Login" and "Create Account" links OR a "Welcome, [username]!" message and a "Logout" button, based on the user state from useAuth. Add an onClick handler to the "Logout" button that calls the logout function from useAuth.

 **Your app should work like this in the end**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T10:31:43.285Z  

```cpp
MONGO_URI=mongodb+srv://sakajayamma2007_db_user:Jaya@cluster0.pjfd3i8.mongodb.net/?appName=cluster0 # <-- rpaste-your-mongo-uri-hereeplace with your actual URI
PORT=8080
JWT_SECRET=your_super_secret_jwt_key # <--- Make sure this is a strong, random string!


```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB334)