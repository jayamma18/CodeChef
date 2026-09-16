# VBHXB51

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Create and List Directory Contents

Let's create a new directory named "my_directory" and then list all the files and folders present in the current directory (where your Node.js script is located). This will help you solidify your understanding of `fs.mkdir` and `fs.readdir`.

Here's the problem:

- We use fs.mkdir to create a directory named "my_directory".
- In the callback of fs.mkdir, use fs.readdir to list the contents of the current directory (represented by.).
- Log each file or folder name to the console.
- Handle potential errors for both fs.mkdir and fs.readdir.
#### Task:

Complete the code to iterate in the files list and print all the files present in the directory.

This exercise combines creating a directory and then immediately listing the contents of the directory where the script is executed, reinforcing the asynchronous nature of the `fs` module. Run the code and see what files and directories are in the same folder as your script!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:38:22.389Z  

```cpp
const fs = require('fs');
const path = require('path');

const dirName = 'my_directory';

fs.mkdir(dirName, { recursive: true }, (err) => {
if (err) {
return console.error('Error creating directory:', err);
}

console.log(`Directory "${dirName}" created successfully.`);

fs.readdir('.', (err, files) => {
if (err) {
return console.error('Error reading current directory:', err);
}

console.log('Contents of current directory:');
files.forEach(file => {
console.log(file);
});
});
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB51)