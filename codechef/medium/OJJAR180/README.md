# OJJAR180

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Implement Theme Switching and User Greeting

Welcome to this hands-on exercise where you'll harness the power of React Context to build dynamic features for a learning platform interface! We'll focus on managing application-wide state for theme preferences and user information without complex prop drilling.

#### Your Mission

Complete the provided React component structure to enable two key features:

- Theme Toggling: Implement a button that allows users to switch between a 'light' and 'dark' visual theme for the application.
- Personalized Greeting: Display a welcoming message that dynamically includes the logged-in user's name.
#### The Scenario: Our Learning Platform UI

Imagine you're building this interface:

- The button in the header will control the theme (light/dark).
- The greeting text will personalize the welcome using user data.
- React Context will manage both the theme state and user data behind the scenes.
#### Key Components & Their Roles

Here's a breakdown of the files you'll be working with:

- App.jsx : The main application container. It's responsible for setting up the global ThemeContext and UserContext providers, making shared data available throughout the component tree.
- Header.jsx : Represents the top navigation bar. This component will contain the theme toggle button and needs access to the ThemeContext to function correctly.
- Greeting.jsx : Responsible for displaying the personalized welcome message. It needs to fetch the user's name from the UserContext.
- ThemeContext : A dedicated Context object to store and share the current theme ('light' or 'dark') and the function used to toggle it.
- UserContext : Another Context object designed to hold and share information about the currently logged-in user (like their name).
#### Where You'll Make Changes (What's Missing?)

You need to complete the implementation in these specific areas:

- App.jsx: The state logic for tracking the current theme and the function to toggle it are incomplete. You'll need to set up useState and define the toggle logic.
- Header.jsx: The theme toggle button isn't yet connected to the ThemeContext. You'll use useContext to access the theme state and the toggle function.
- Greeting.jsx: This component isn't currently fetching the user's name from the UserContext. You'll use useContext here as well to access the user data.
#### Step-by-Step Guide

Follow these steps to bring the features to life:

 **Step 1: Configure Theme Context in `App.jsx`** 

- Goal: Initialize the theme state and create a working theme toggle function within the main App component. Initialize Theme State: Use the useState hook inside App.jsx to create a state variable for the theme, setting its default value to 'light'. Define Toggle Function: Create a function (toggleTheme) within App.jsx. This function should update the theme state, switching it between 'light' and 'dark' each time it's called. Provide Context Value: Pass both the current theme state variable and the toggleTheme function as the value prop to the ThemeContext.Provider. This makes them available to consuming components.

 **Step 2: Implement Theme Toggle Button in `Header.jsx`** 

- Goal: Make the button in the Header component functional, allowing users to switch themes using the context. Access Theme Context: Inside Header.jsx, use the useContext hook with ThemeContext to retrieve the current theme value and the toggleTheme function. Set Dynamic Button Text: Modify the button's text content so it dynamically shows the action based on the current theme (e.g., display "Switch to Dark Theme" if the current theme is 'light', and "Switch to Light Theme" if it's 'dark'). Connect Toggle Function: Add an onClick handler to the button that calls the toggleTheme function obtained from the context.

 **Step 3: Display User Greeting in `Greeting.jsx`** 

- Goal: Fetch the user's name from the UserContext and display a personalized welcome message. Access User Context: Inside Greeting.jsx, use the useContext hook with UserContext to retrieve the user object containing the user's data (e.g., { name: 'Sarah' }). Render Personalized Greeting: Update the component's returned JSX to display a message like "Welcome back, [User's Name]!", dynamically inserting the name property from the user object obtained via context.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-03T05:31:19.790Z  

```cpp
import { useState } from 'react';
import './App.css';
import Layout from './components/Layout';
import UserContext from './UserContext';
import ThemeContext from './ThemeContext';

function App() {
const [theme, setTheme] = useState('light');
const [user] = useState({ name: 'Sarah' });

const toggleTheme = () => {
setTheme((prevTheme) => (prevTheme === 'light' ? 'dark' : 'light'));
};

return (
<UserContext.Provider value={user}>
<ThemeContext.Provider value={{ theme, toggleTheme }}>
<div className={`app ${theme}`}>
<Layout />
</div>
</ThemeContext.Provider>
</UserContext.Provider>
);
}

export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR180)