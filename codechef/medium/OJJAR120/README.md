# OJJAR120

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Displaying Tab Headers and Conditional Content

Let's use this information to achieve two things:

- Display the actual titles for our three tabs ("Personal Info", "Experience", "Review") as headers.
- Highlight the header of the currently active tab using the active CSS class.
- Show only the content relevant to the active tab inside the tab-content area. We won't use an array for now; we'll handle the logic directly inside Tabs.jsx.

To show content conditionally, we can use a common JavaScript trick within JSX: the logical AND (`&&`) operator. The pattern `condition && <JSXElement />` means: "If the `condition` is true, render the `<JSXElement />`; otherwise, render nothing."
 **for example -** 

```
{currentActiveTab === 0 && (
    <div> {/ *Wrap content in a div or Fragment* /}
         <h2>Personal Information</h2>
         <p>Content for the personal info tab goes here.</p>
    </div>
)}

```

 **Template Update** 
We’ve updated the template to support tab-based navigation. Here's what's already done for you:

- In App.jsx, we are now passing a prop to the Tabs component: <Tabs currentActiveTab={0} /> This sets the active tab to the first one (index 0) by default.
- In Tabs.jsx, we modified the component definition to receive this prop: function Tabs({ currentActiveTab }) { This allows the Tabs component to access which tab is currently active and update the UI accordingly.

Now it’s your turn — update the Tabs.jsx component to complete the tab logic:

 **Task** 

Your goal is to modify `Tabs.jsx` so it uses the `currentActiveTab` prop to control which content is visible and which header is highlighted.

- Create Tab Headers: Inside the div with className="tab-headers" in Tabs.jsx, Add three <button> elements. Give them the text content: "1. Personal Info", "2. Experience", "3. Review & Submit". For each button, assign a dynamic className. Use a template literal (backticks `) for the class string. Start with the base class: tab-header. Add a space, then use a JavaScript expression: ${currentActiveTab === INDEX ? 'active' : ''}. Replace INDEX with 0 for the first button, 1 for the second, and 2 for the third. This will add the active class only to the button whose index matches the currentActiveTab prop.
- Implement Conditional Content: Inside the div with className="tab-content" in Tabs.jsx, remove the placeholder paragraph(s). Add three separate sections using the && conditional rendering pattern: Section 1: {currentActiveTab === 0 && (... JSX for Tab 1...)} Section 2: {currentActiveTab === 1 && (... JSX for Tab 2...)} Section 3: {currentActiveTab === 2 && (... JSX for Tab 3...)} Inside the parentheses (...) for each section, add a <div> containing: An <h2> with the corresponding tab title (e.g., "Personal Information", "Work Experience & Skills", "Review Your Application"). A placeholder <p> tag with some text like: "Content for [Tab Name] will go here."

Now try changing the value of `currentActiveTab` to see if everything is working correctly

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T10:34:30.808Z  

```cpp
import React from 'react';

function Tabs({ currentActiveTab }) {
return (
<div className="tabs-container">
<div className="tab-headers">
<button className={`tab-header ${currentActiveTab === 0 ? 'active' : ''}`}>1. Personal Info</button>
<button className={`tab-header ${currentActiveTab === 1 ? 'active' : ''}`}>2. Experience</button>
<button className={`tab-header ${currentActiveTab === 2 ? 'active' : ''}`}>3. Review & Submit</button>
</div>

<div className="tab-content">
{currentActiveTab === 0 && (
<div>
<h2>Personal Information</h2>
<p>Content for the personal info goes here.</p>
</div>
)}
{currentActiveTab === 1 && (
<div>
<h2>Experience</h2>
<p>Content for experience goes here.</p>
</div>
)}
{currentActiveTab === 2 && (
<div>
<h2>Review & Submit</h2>
<p>Content for review & submit goes here.</p>
</div>
)}
</div>

<div className="tab-navigation">
<button>Previous</button>
<button>Next</button>
</div>
</div>
);
}

export default Tabs;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR120)