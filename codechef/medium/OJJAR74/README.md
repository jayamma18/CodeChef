# OJJAR74

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Understanding the && (Logical AND) Operator

The `&&` (logical AND) operator is used to evaluate two conditions (`true` or `false`). It returns `true` only if  **both**  conditions are `true`; otherwise, it returns `false`.

### How it Works:
- true && true → ✅ true
- true && false → ❌ false
- false && true → ❌ false
- false && false → ❌ false
### Example

Let's say we are checking whether a user gets a discount:

```
function DiscountMessage() {
  const isPremiumMember = true;
  const hasCoupon = true;

  return (
    <>
      {isPremiumMember && hasCoupon ? (
        <p className="success">You get an EXTRA discount! 🎉</p>
     ) : (
        <p className="warning">You do not qualify for an extra discount.</p>
     )}
    </>
 );
}

```

#### Explanation:
- If isPremiumMember is true AND hasCoupon is true, the user gets an extra discount.
- If either one is false, the discount is not applied.
### Your Task:

Update the `WelcomeMessage` component to:

- Display the title: <h1>My React App</h1>
- Check BOTH isLoggedIn AND isPremiumUser directly in the JSX using &&: If both are true, show: "<p>Welcome to Premium Content! 🎉</p>" If either is false, show: "<p>Please log in and upgrade to premium...</p>"

 **Note -** 
1. Display the title in an `<h1>` tag.
2. Display the message in a `<p>` tag.

You can Test by changing `isLoggedIn`/`isPremiumUser` values in the App component.
Try writing the function and submit your solution!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T06:55:18.957Z  

```cpp
import React from 'react';
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR74)