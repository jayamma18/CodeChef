# OJJAR230

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Tab Switch

In this task, you'll build a  **Switch Tab Interface**  using React. Tabs are a common UI pattern used to organize content into different sections on the same page.

You are given the basic setup of a React project with 3 tabs:

- Frontend
- Backend
- Full Stack

Your goal is to complete the functionality so that:

- Clicking on a tab should make it active.
- The content below the tabs should update based on the active tab.
- The active tab should appear highlighted to indicate selection.

 **Files Provided** 

- App.js
- Tab.js

Some parts of the code are marked with `// TODO:` comments. You need to complete these parts to make the tab switcher work correctly.

 **What You Need to Do** 

- Use React’s useState hook to keep track of the active tab.
- Render the appropriate content based on the active tab.
- Highlight the selected tab to show which tab is active.
- Update the active tab when a different tab is clicked.

 **Expected Behavior** 

 **Helpful Resources** 

Here are some beginner-friendly links to help you solve this challenge:

- 🔗 Codechef React course
- 🔗 React Docs: useState
- 🔗 React Docs: Handling Events
- 🔗 React Docs: Conditional Rendering
- 🔗 React Props Explained

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T10:32:18.189Z  

```cpp
import { useState } from 'react';
import Tab from './Tab.jsx';

const App = () => {
const [activeTab, setActiveTab] = useState('Frontend');

const renderContent = () => {
if (activeTab === 'Frontend') {
return <p>This is the Frontend Project section.</p>;
} else if (activeTab === 'Backend') {
return <p>This is the Backend Project section.</p>;
} else if (activeTab === 'Full Stack') {
return <p>This is the Full Stack Project section.</p>;
}
};

return (
<div style={{ padding: '20px', fontFamily: 'Arial' }}>
<h1>React Challenge: Tab Switcher</h1>

<div style={{ display: 'flex', gap: '10px' }}>
<Tab activeTab={activeTab} label="Frontend" setActiveTab={setActiveTab} />
<Tab activeTab={activeTab} label="Backend" setActiveTab={setActiveTab} />
<Tab activeTab={activeTab} label="Full Stack" setActiveTab={setActiveTab} />
</div>

<hr />

<div>
{renderContent()}
</div>
</div>
);
};

export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR230)