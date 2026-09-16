# VBHXB48

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Construct and Analyze a File Path

Okay, let's put the `path` module into action with a worked example!

### How code works:
- Uses path.join() to construct a file path from a directory named reports, a sub-directory named 2024, and a filename sales.txt. Assume the script is run from the project's root directory.
- Then, use path.resolve() to convert the joined path to an absolute path.
- Finally, extract and print the base name (filename with extension), the extension, and the directory name from the absolute path.
#### Task:

Complete the code to get the absolute path of the file.

This exercise will give you a good feel for how to combine different parts of a path and how to extract useful information from it.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:27:20.666Z  

```cpp
const path = require('path');

// 1. Construct the file path
const reportsDir = 'reports';
const yearDir = '2024';
const fileName = 'sales.txt';

// Use path.join() to create the full file path
const relativePath = path.join(reportsDir, yearDir, fileName);

// 2. Resolve to absolute path
const absolutePath = path.resolve(relativePath);

// 3. Extract and print information
const baseName = path.basename(absolutePath);
const extName = path.extname(absolutePath);
const dirName = path.dirname(absolutePath);

console.log('Relative Path:', relativePath);
console.log('Absolute Path:', absolutePath);
console.log('Base Name:', baseName);
console.log('Extension:', extName);
console.log('Directory Name:', dirName);

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB48)