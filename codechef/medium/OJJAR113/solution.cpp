required
/>
</div>

<button type="submit" disabled={status === 'loading'}>
{status === 'loading' ? (
<>
<span className="spinner"></span> Sending...
</>
) : (
'Subscribe'
)}
</button>

{status === 'error' && <p className="error">{error}</p>}
</form>
);
onChange={(e) => setEmail(e.target.value)}
disabled={status === 'loading'}
disabled={status === 'loading'}
required
/>
</div>

<div className="input-group">
<label htmlFor="email">Email:</label>
<input
id="email"
type="email"
value={email}
type="text"
value={name}
onChange={(e) => setName(e.target.value)}
<form onSubmit={handleSubmit} className="newsletter-form">
<div className="input-group">
<label htmlFor="name">Name:</label>
<input
id="name"

return (
}
</div>
);
<button onClick={resetForm}>Subscribe Again</button>
return (
<div className="success-container">
<h3>Thank you for subscribing!</h3>
setStatus('error');
setError(err.message);
}
}

function resetForm() {
setName('');
setEmail('');
setStatus('idle');
setError(null);
}

if (status === 'success') {
if (!response.ok) {
throw new Error(data.message || 'Submission failed');
}

setStatus('success');
setName('');
setEmail('');
} catch (err) {
body: JSON.stringify({ name, email }),
});

const data = await response.json();

},
import React from 'react';
import './App.css';

const ENDPOINT = 'https://jsonplaceholder.typicode.com/posts';

function NewsletterForm() {
const [email, setEmail] = React.useState('');
const [name, setName] = React.useState('');
const [status, setStatus] = React.useState('idle');
const [error, setError] = React.useState(null);

async function handleSubmit(event) {
event.preventDefault();
setStatus('loading');
setError(null);

try {
const response = await fetch(ENDPOINT, {
method: 'POST',
headers: {
'Content-Type': 'application/json',