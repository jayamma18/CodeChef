# OJJAR35

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Convert Array of Strings to Uppercase Using map()

You are given an array of strings. Your task is to create a new array where each string is converted to its uppercase(use  **`toUpperCase`**  function) version. You  **must**  use the `.map()` method to achieve this.

### Sample 1:
Input
Output

```
['hello', 'world', 'javascript']
```

```
[ 'HELLO', 'WORLD', 'JAVASCRIPT' ]
```

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T09:39:10.949Z  

```js
const words = ['hello', 'world', 'javascript'];

// complete the code 
const uppercaseWords=words.map(word=>word.toUpperCase()) ;

console.log(uppercaseWords); 
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR35)