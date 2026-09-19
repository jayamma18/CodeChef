# VBHXB330

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Frontend Login and Registration Forms

Okay, you've brilliantly identified the need for a reusable component in our previous discussion!

Now, it's time to put that decision into action!

 **Objective:**  To build the user interface for the login and account creation pages. This involves creating dedicated page components (`Login.jsx`, `Register.jsx`) and a reusable form component (`AuthForm.jsx`) that handles the input fields, without implementing any authentication logic or API calls yet.

 **Context:** 

- As you observed by clicking the links previously, the forms for Login and Registration share common elements (username, password, submit button). We're now building them based on our decision to use a reusable component.

 **Task:** 

Using the provided template code, complete the following:

- Create a Reusable Authentication Form Component (frontend/src/components/AuthForm.jsx): This component will be designed to handle both login and registration forms. It should accept a type prop, which will be either "login" or "register". Use this type prop to dynamically set: The heading of the form (e.g., "Login" or "Create Account"). The text of the submit button (e.g., "Login" or "Register"). Use React's useState hook to manage the input values for username and password. Create a basic HTML <form> structure with two input fields: one for username (type text) and one for password (type password). Both should be required. Add a submit button. For now, the onSubmit handler for the form should simply prevent the default form submission behavior (e.g., e.preventDefault();). No actual login/registration logic is needed yet. If you are using our provided CSS, wrap the entire form content inside a div with className="auth-container".
- Create Login Page Component (frontend/src/pages/Login.jsx): This component will be very simple. It should primarily import and render the AuthForm component, passing the appropriate type prop (e.g., type="login").
- Create Register Page Component (frontend/src/pages/Register.jsx): Similar to Login.jsx, this component will import and render the AuthForm component, passing type="register".
- Update frontend/src/App.jsx: Import the new Login and Register components. Add two new Route elements within the <Routes> block: One for path="/login" that renders the Login component. One for path="/register" that renders the Register component.
- Update the Navigation Bar (frontend/src/components/Navbar.jsx): Modify the Link components in your Navbar to navigate to the correct pages. The "Login" link should point to="/login". The "Create Account" link should point to="/register".
- Styling: Create frontend/src/components/AuthForm.css and use the provided CSS. You can, of course, write your own styles if you prefer. Navbar.css remain unchanged.
 **Click to get the AuthForm.css!** 

 **Your App should be work like this at the end**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:50:24.229Z  

```cpp
.auth-form input[type="text"],
.auth-form input[type="password"] {
    width: calc(100% - 20px); /* Adjust for padding */
    padding: 10px;
    border: 1px solid  #ccc;
    border-radius: 5px;
    font-size: 1em;
    box-sizing: border-box; /* Include padding in width */
}

.auth-form button {
    width: 100%;
    padding: 12px;
    background-color:  #007bff;
    color:  white;
    border: none;
    border-radius: 5px;
    font-size: 1.1em;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.auth-form button:hover {
    background-color:  #0056b3;
}

.auth-form button:disabled { /* For future use with loading states */
    background-color:  #cccccc;
    cursor: not-allowed;
}

.error-message { /* For future use with error display */
    color:  #dc3545;
    margin-top: 15px;
    font-size: 0.9em;
}

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB330)