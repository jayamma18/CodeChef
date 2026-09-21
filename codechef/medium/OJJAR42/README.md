# OJJAR42

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Filter Long Names

In this example, we will filter out names from an array that are longer than 5 characters. This will allow us to see how the `filter()` method works in a practical scenario.

Imagine you have an array of names, and you want to keep only the names that are 5 characters or fewer. We'll use the `filter()` method to accomplish this.

- Create an array of names: let names = ["John", "Emily", "Michael", "Sara", "Chris", "Kate"];
- Use the filter() method: We will define a callback function that checks if the length of each name is 5 characters or less. let shortNames = names.filter((name) => { return name.length <= 5; });
- Result: After filtering, the shortNames array will contain only those names that meet the condition.

Now, let’s see the complete code that you can run to observe the output.

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T10:05:38.003Z  

```js
let names = ["John", "Emily", "Michael", "Sara", "Chris", "Kate"];
let shortNames = names.filter((name) => {
    return name.length <= 5;
});
console.log(shortNames);

```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR42)