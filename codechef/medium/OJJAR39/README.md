# OJJAR39

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Double the Numbers

Given an array of numbers, create a new array where each number is double the value of the corresponding number in the original array. Note: While `map` is often preferred for creating new arrays, this exercise shows how you can achieve it using `forEach` and an external array.

### Sample 1:
Input
Output

```
[1, 5, 10]
```

```
Doubled: [ 2, 10, 20 ]
```

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T09:54:14.983Z  

```js
let originalNumbers = [1, 5, 10];

// Create an empty array to store the results

// Iterate over the original numbers
let doubledNumbers=[];
// Calculate the doubled value

// Add the doubled value to our new array
originalNumbers.forEach(num=> {
    doubledNumbers.push(num*2);
});

console.log("Doubled:",doubledNumbers );
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR39)