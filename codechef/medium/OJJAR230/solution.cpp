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