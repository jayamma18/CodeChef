# OJJAR40

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Greet Each User

You are given an array of user objects. Each user has a `name` and an `age`. Your task is to use the `forEach()` method to print a greeting message for each user in the format:

### Sample 1:
Input
Output

```
  
```

```
Hello, Alice! You are 25 years old.
Hello, Bob! You are 30 years old.
Hello, Charlie! You are 22 years old.
```

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T10:04:04.734Z  

```js
const users = [
  { name: 'Alice', age: 25 },
  { name: 'Bob', age: 30 },
  { name: 'Charlie', age: 22 }
];


// Complete the code below.
// formated log
users.forEach(user=>{
console.log(`Hello, ${user.name}! You are ${user.age} years old.`);
});
//users.forEach(user=>{
    //console.log('Hello, ${user.name}! You are ${user.age} years old.');
//});
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR40)