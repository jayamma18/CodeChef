# VBHXB56

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Display a File on the Server

Now, let's create a worked example where our server reads the contents of a text file and displays it in the browser. This will combine our knowledge of the `http` module with the `fs` (file system) module we learned about previously!

Here's the problem: We want to create a server that reads the contents of a file named `my-file.txt` and displays those contents when someone visits `http://localhost:3000/`.

#### Task:

Complete the missing code.

#### Let's break down the code:
- We import the fs module using require('fs').
- Inside the createServer callback, you use fs.readFile('my-file.txt', 'utf8', (err, data) => {... }) to read the contents of my-file.txt. 'utf8' specifies the character encoding. The callback function (err, data) => {... } is executed after the file is read. err will contain an error object if there was an error reading the file. data will contain the contents of the file as a string.
- If there's an error reading the file (if (err)), we send a 500 status code (Internal Server Error) and an error message.
- If the file is read successfully, we send a 200 status code (OK) and the contents of the file as the response using res.end(data).

Click "RUN" to run the code and see the output! Click on "SUBMIT" to go to the next problem.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:40:34.007Z  

```cpp
const http = require('http');
const fs = require('fs');

const server = http.createServer((req, res) => {
// complete the code to read the file
fs.readFile('my-file.txt', 'utf8', (err, data) => {
if (err) {
res.writeHead(500, { 'Content-Type': 'text/plain' });
res.end('Error reading file!');
return;
}
res.writeHead(200, { 'Content-Type': 'text/plain' });
res.end(data);
});
});

const port = 3000;
server.listen(port, () => {
console.log(`Server running at http://localhost:${port}/`);
});
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB56)