# OJJAR44

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Positive Numbers

In this problem, we will filter out negative numbers from an array of integers using the `filter()` method.

You are given an array of numbers, and you want to keep only the positive numbers (including zero). We'll use the `filter()` method for this.

- Use the filter() method: We will define a callback function that checks if each number is greater than or equal to zero. let positiveNumbers = numbers.filter((number) => { // Your code here });
- Result: After filtering, the positiveNumbers array will contain only those numbers that meet the condition. Print the positiveNumbers array to see the output.

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T10:26:21.810Z  

```js
let numbers = [10, -5, 0, 3, -2, 7, -1, 4];
let positiveNumbers=numbers.filter(numbers=>numbers >=0);
console.log(positiveNumbers);
// complete the code 
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR44)