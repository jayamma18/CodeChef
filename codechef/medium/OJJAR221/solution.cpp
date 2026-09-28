import { useState, useEffect } from 'react';
import Toast from './Toast.jsx';

function App() {
const [name, setName] = useState('');
const [message, setMessage] = useState('');
const [showToast, setShowToast] = useState(false);
const [toastMessage, setToastMessage] = useState('');

const handleSubmit = (event) => {
event.preventDefault();
console.log('Form Submitted:', { name, message });

setToastMessage(`Thanks, ${name}! Your message was sent.`);
setShowToast(true);

setName('');
setMessage('');
};

useEffect(() => {
let timer;
if (showToast) {
timer = setTimeout(() => {
setShowToast(false);
}, 3000);
}

return () => clearTimeout(timer);
}, [showToast]);

return (
<div>
<h1>Feedback Form</h1>
<form onSubmit={handleSubmit} className="feedback-form">
<div>
<label htmlFor="nameInput">Name:</label>
<input
id="nameInput"
type="text"
value={name}
onChange={(e) => setName(e.target.value)}
required
/>
</div>
<div>
<label htmlFor="messageInput">Message:</label>
<textarea
id="messageInput"
value={message}
onChange={(e) => setMessage(e.target.value)}
required
/>
</div>
<button type="submit">Submit Feedback</button>
</form>

{showToast && (
<Toast
message={toastMessage}
onClose={() => setShowToast(false)}
/>
)}
</div>
);
}

export default App;