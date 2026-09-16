# VBHXB53

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Reading a Non-Existent File

Let's practice error handling with a common scenario: trying to read a file that doesn't exist.

In this Node.js program we attempt to read a file named `my_missing_file.txt`. Since this file doesn't exist, the `fs.readFile` function will return an error. Your program should handle this error gracefully by printing an informative error message to the console.

#### How this file works:
- Import the fs module.
- Use fs.readFile to attempt to read my_missing_file.txt.
- Check the err argument in the callback function.
- If an error occurred, print a message like "Error: File not found!" along with the error details.
- If no error occurred (which won't happen in this case), you can add a message saying the file was read successfully.
#### Task:

Write the code to import the fs module.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:39:21.103Z  

```cpp
const fs = require('fs');

fs.readFile('my_missing_file.txt', 'utf8', (err, data) => {
if (err) {
console.error('Error: File not found!');
console.error(err.message);
} else {
console.log('File read successfully:');
console.log(data);
}
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB53)