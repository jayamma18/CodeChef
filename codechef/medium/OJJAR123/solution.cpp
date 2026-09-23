import React from 'react';

function Tabs({ activeTabIndex, onPrevious, onNext }) {
const totalTabs = 3;
const isFirstTab = activeTabIndex === 0;
const isLastTab = activeTabIndex === totalTabs - 1;

return (
<div className="tabs-container">
<div className="tab-headers">
<button className={`tab-header ${activeTabIndex === 0 ? 'active' : ''}`}>Personal Info</button>
<button className={`tab-header ${activeTabIndex === 1 ? 'active' : ''}`}>Experience</button>
<button className={`tab-header ${activeTabIndex === 2 ? 'active' : ''}`}>Review</button>
</div>

<div className="tab-content">
{activeTabIndex === 0 && (
<div>
<h2>Personal Information</h2>
<p>Content for the personal info tab goes here.</p>
</div>
)}
{activeTabIndex === 1 && (
<div>
<h2>Work Experience</h2>
<p>Content for the experience tab goes here.</p>
</div>
)}
{activeTabIndex === 2 && (
<div>
<h2>Review & Submit</h2>
<p>Content for the review tab goes here.</p>
</div>
)}
</div>

<div className="tab-navigation">
<button onClick={onPrevious} disabled={isFirstTab}>Previous</button>
<button onClick={onNext} disabled={isLastTab}>Next</button>
</div>
</div>
);
}

export default Tabs;