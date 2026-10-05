# OJJAR128

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Finalizing Application Submission

Excellent work! You've successfully refactored our form so that `Tabs.js` now manages the state and individual change handlers for  *all*  input fields, including Full Name and Email. The "Review & Submit" tab correctly displays all the data entered by the user.

We're at the final stage of our form! It's time to implement the submission functionality. When the user is on the "Review & Submit" tab and clicks a "Submit Application" button, we want to:

- Simulate a form submission (for now, we'll just log the data to the console).
- Display a success message to the user, confirming their application has been "received."

All of this logic will be handled  **within the `Tabs.jsx` component**.

#### Your Task: Implementing Form Submission and Success

Your mission is to add a "Submit Application" button to the "Review & Submit" tab. When this button is clicked, the form should "submit" (log data), and then the UI should change to show a success message.

 **Specifically, within `Tabs.jsx` you need to:** 

- Add a new state variable for submission status: Create a state variable (e.g., isSubmitted, setIsSubmitted), initialized to false. This will control whether we show the form or the success message.
- Create a form submission handler function: Define a function (e.g., handleFormSubmit). Inside this function: Log all the current form data (fullName, email, phone, address, jobTitle, company, yearsExperience, skills, agreeTerms) to the console. You can log them as an object. Update the isSubmitted state variable to true.
- Modify the "Review & Submit" tab's content (when activeTabIndex === 2): Add a "Submit Application" button. This button should only be visible if isSubmitted is false. When clicked, this button should call your handleFormSubmit function.
- Conditionally render the success message OR the tab content: Modify the main return statement of the Tabs component. If isSubmitted is true, display a success message section. This section should: Have a heading like "Application Submitted Successfully!" Display a personalized message, for example: "Thank you, {fullName}. Your application has been received." Mention how they'll be contacted, e.g., "We will review your details and contact you via email ({email}) if you are shortlisted." If isSubmitted is false, display the existing tab structure (headers, content, navigation).
- Modify the tab-navigation div: Keep the "Previous" button as is, using the onPrevious prop. For the second button in this div: If isLastTab is true: Display a button with the text "Submit Application". Its onClick event should call your local handleFormSubmit function. You can give it a specific class like submit-button for styling if desired. If isLastTab is false: Display a button with the text "Next". Its onClick event should call the onNext prop passed from App.js.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T08:56:08.163Z  

```cpp
import React, { useState } from 'react';
import Tabs from './Tabs';
import './App.css';

function App() {
const [activeTabIndex, setActiveTabIndex] = useState(0);
const totalTabs = 3;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR128)