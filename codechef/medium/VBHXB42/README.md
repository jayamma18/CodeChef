# VBHXB42

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### File Existence, Rename and Delete

Let's create a scenario where we combine checking for a file's existence, renaming it, and then deleting it. This will give you a better understanding of how these operations work together using the `fs` module.

### Here's the problem:

We want to create a script that first checks if a file named `file.txt` exists. If it  *doesn't*  exist, the script should create it. Then, regardless of whether it was created or already existed, the script should rename the file to `newFile.txt`. Finally, the script should delete `newFile.txt`.

### Code breakdown:
- index.js: this is the js code which check if the file that is asked in the code exist or not, if it does not then a new file will be created.
- index2.js this code searches the given file name and changes its name to whatever the user have specified.
- index3.js this code searches and deletes the file specified by the user.
#### Task:

Complete the code to check if the file already exist in the directory or not.

Now, lets run all the files one by one using the terminal command `node (file_name)`. Observe the output in your console.

Click on `SUBMIT` button to move forward, or you can change the code to try out these functionality on different files.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-07T10:50:53.619Z  

```cpp
const fs = require('fs');

const initialFilePath = 'file.txt';
const renamedFilePath = 'newFile.txt';

// Check if the initial file exists
if () {
    // Create the file if it doesn't exist
    try {
        fs.writeFileSync(initialFilePath, ''); // creates an empty file
        console.log('File created successfully!');
    } catch (err) {
        console.error('Error creating file:', err);
    }
} else {
    console.log('File already exists!');
}
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB42)