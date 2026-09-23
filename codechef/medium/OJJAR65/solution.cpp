// Task: Convert this code to use a reusable component `<GreetingCard />`
// Instead of hardcoding values, pass `name`, `age`, and `greeting` as props
// Use instances of `<GreetingCard />` inside `App`

export function GreetingCard({ name, age, greeting }) {
const cardStyle = {
border: "2px solid #333",
padding: "20px",
borderRadius: "10px",
width: "250px",
textAlign: "center",
boxShadow: "2px 2px 10px rgba(0,0,0,0.1)"
};

const headingStyle = {
color: "blue",
fontSize: "20px"
};

return (
<div style={cardStyle}>
<h2 style={headingStyle}>{greeting}</h2>
<p>Hello, my name is {name}.</p>
<p>I am {age} years old.</p>
<p>Year: {new Date().getFullYear()}</p>
<p>Enjoy your day! 🎉</p>
</div>
);
}

export function App() {
const name = "John";
const age = 25;
const greeting = "Happy Birthday!";
