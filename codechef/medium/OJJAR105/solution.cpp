import React, { useState, useEffect } from 'react';

function WindowTracker() {
const [windowSize, setWindowSize] = useState({
width: window.innerWidth,
height: window.innerHeight
});

useEffect(() => {
function handleResize() {
setWindowSize({
width: window.innerWidth,
height: window.innerHeight
});
}

window.addEventListener('resize', handleResize);

return () => {
window.removeEventListener('resize', handleResize);
};
}, []);

return (
<div>
<p>Window Width: {windowSize.width}px</p>
<p>Window Height: {windowSize.height}px</p>
</div>
);
}

export default function App() {
const [showTracker, setShowTracker] = useState(true);

return (
<div>
<button onClick={() => setShowTracker(!showTracker)}>
Toggle Window Tracker
</button>
{showTracker && <WindowTracker />}
</div>
);
}