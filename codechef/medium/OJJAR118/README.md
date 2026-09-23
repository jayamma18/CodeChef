# OJJAR118

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Add the Second Tab

Now, In this lesson, we're enhancing our tab interface by adding a second tab. You'll create an additional header and content section to allow switching between two different views.

- Go to your src/Tabs.jsx file.
- Right now, you have one placeholder header and one placeholder content section.
- Modify Tabs.jsx to include two tab headers and two distinct content paragraphs, like this: In the div with className="tab-headers", add a second <span> element next to the first one. Call it "Tab 2 Header". In the div with className="tab-content", add a second <p> element below the first one. Give it different text, like "This is the CONTENT for Tab 2".

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T10:32:25.493Z  

```cpp
import React from 'react';

function Tabs() {
return (
<div className="tabs-container">
<div className="tab-headers">
<span>Tab 1 Header</span>
<span>Tab 2 Header</span>
</div>

<div className="tab-content">
<p>Tab Content Will Appear Here</p>
<p>This is the CONTENT for Tab 2</p>
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

[View on CodeChef](https://www.codechef.com/problems/OJJAR118)