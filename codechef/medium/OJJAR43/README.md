# OJJAR43

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Filter Out Long Words

In this example, we will filter out words from an array that are longer than 4 characters. This will allow us to see how the `filter()` method works in a practical scenario.

You are given an array of words, and you want to keep only the words that are 4 characters or fewer. We'll use the `filter()` method to accomplish this.

- Use the filter() method: We will define a callback function that checks if the length of each word is 4 characters or less. let shortWords = words.filter((word) => { // Your code here });
- Result: After filtering, the shortWords array will contain only those words that meet the condition. Print the shortWords array to see the output.

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T10:14:41.692Z  

```js
let words = ["apple", "banana", "pear", "kiwi", "grape", "orange"];

// complete the code 
let shortWords=words.filter(word=>word.length <= 4);
console.log(shortWords)
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR43)