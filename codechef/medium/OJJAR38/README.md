# OJJAR38

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Calculate the Total Score

You are given an array containing `scores` from different rounds of a game. Calculate the total score by adding up all the scores in the array.

### Sample 1:
Input
Output

```
[10, 45, 23, 8]
```

```
Total Score: 86
```

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T09:45:53.939Z  

```js
let scores = [10, 45, 23, 8];
let totalScore = 0; 

// complete the code 

// Use forEach to go through each score

// Add the current score to the totalScore
scores.forEach(score=>{
    totalScore+=score;
});
  

console.log("Total Score:", totalScore); 
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR38)