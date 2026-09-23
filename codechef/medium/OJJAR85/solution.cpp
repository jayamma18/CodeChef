const [value, setValue] = useState("");
const generateRandomString = () => {
const randomStr = Math.random().toString(36).substring(2, 8);
setValue(randomStr);
};
return (
<div className="container">
<input
type="text"
value={value}
onChange={(e) => setValue(e.target.value)}
placeholder="Type something..."
/>
<div className="output-box">
<h3>Live Display: {value}</h3>
</div>
<button className="btn" onClick={generateRandomString}>
Generate Random String
</button>
</div>
);
}
