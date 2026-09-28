import React, { useState, useEffect } from "react";

function App() {
const [score, setScore] = useState(0);

useEffect(() => {
setScore(score + 1);
}, []);

const handleClick = () => {
setScore(score + 1);
};

return (
<div style={{ textAlign: "center", marginTop: "100px" }}>
<h1>Click Me Game</h1>
<h2>Score: {score}</h2>
<button onClick={handleClick}>Click Me!</button>
</div>
);
}

export default App;