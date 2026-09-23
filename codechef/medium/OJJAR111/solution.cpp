import { useState, useEffect } from "react";

const useWindowWidth = (delay = 200) => {
const [width, setWidth] = useState(window.innerWidth);

useEffect(() => {
let timeoutId;

const handleResize = () => {
clearTimeout(timeoutId);
timeoutId = setTimeout(() => {
setWidth(window.innerWidth);
}, delay);
};

window.addEventListener("resize", handleResize);

return () => {
window.removeEventListener("resize", handleResize);
clearTimeout(timeoutId);
};
}, [delay]);

return width;
};

const ResponsiveComponent = () => {
const width = useWindowWidth();

return (
<div style={{ padding: "20px", textAlign: "center" }}>
<h2>Current window width:</h2>
<p style={{ fontSize: "24px", fontWeight: "bold", color: "blue" }}>
{width}px
</p>
</div>
);
};

export default ResponsiveComponent;