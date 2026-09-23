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