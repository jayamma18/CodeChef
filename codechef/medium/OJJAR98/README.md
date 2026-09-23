# OJJAR98

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Rules of Hooks
#### Task: Fix the Hook Usage

In our IDE you are given a component that violates the Rules of Hooks. Identify the mistake and correct the code.

Once done, submit your solution to verify correctness.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T09:54:55.117Z  

```cpp

return (
<form className="simple-form" onSubmit={handleSubmit}>
<label htmlFor={`${uniqueId}-name`}>Name:</label>
<input
id={`${uniqueId}-name`}
type="text"
value={name}
onChange={(e) => setName(e.target.value)}
/>
<label htmlFor={`${uniqueId}-email`}>Email:</label>
<input
id={`${uniqueId}-email`}
type="email"
value={email}
onChange={(e) => setEmail(e.target.value)}
/>
<button type="submit">Submit</button>
</form>
);
}

export default SimpleForm;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR98)