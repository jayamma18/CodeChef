# OJJAR113

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Complete the Newsletter Subscription Form

Let's build a newsletter subscription form using React! Your task is to complete the existing template by filling in the missing code pieces. Follow these steps carefully:

#### Step 1: Initialize State Variables
- Fix the email state initialization: Complete the commented / *email state* / with email Complete the setEmail state updater
- Initialize error state: Set initial value to null (instead of / *initial value* /)
#### Step 2: Handle Form Submission
- In the fetch() call: Set HTTP method to 'POST' Create request body using { name, email }
- After successful submission: Clear form fields using setName('') and setEmail('')
#### Step 3: Error Handling
- For non-OK responses: Throw error using throw new Error(data.message || 'Submission failed')
- In catch block: Update status to 'error' Set error message using setError(err.message)

 **To test the error message, change the ENDPOINT and observe the result.** 

#### Step 4: Form Reset
- In resetForm(): Reset all states: setName(''); setEmail(''); setStatus('idle'); setError(null);
#### Step 5: Email Input Binding
- Complete email input's onChange handler: Use (e) => setEmail(e.target.value)

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T10:05:01.744Z  

```cpp
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
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR113)