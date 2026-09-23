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