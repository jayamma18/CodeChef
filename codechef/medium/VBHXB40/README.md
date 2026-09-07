# VBHXB40

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Extract Filename From Path

Let's solidify your understanding of importing and using built-in modules with a practical example. We'll use the `path` and `os` modules, which, as you learned, helps us work with file and directory paths.

 **Let's walk through the code step-by-step:** 

- Import the path and os modules: We'll start by importing the path and os modules using require('path') and require('os').
- Define the file path: We'll create a variable to store the file path we want to work with.
- Use path.basename(): The path module provides a function called basename() that does exactly what we need – it extracts the filename from a path.
- Use os.platform(): The os module provides a function called platform() that returns the name of the operating system platform.
- Display the results: Finally, we'll print both the extracted filename and the OS platform to the console.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-07T10:50:26.718Z  

```cpp
const path = require('path');
const os = require('os');

const filePath = '/users/john/documents/report.txt';

//

console.log('Extracted filename:', fileName);
const fileName=path.basename(filePath);
const platform=os.platform();
console.log('Operating System Platform:', platform);
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB40)