# VBHXB66

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Serving an Image

Let's solidify your understanding by serving an image file. In this example, we'll create a simple server that serves a PNG image.

First, you'll need an image. You can either use an existing `.png` image on your computer or download a sample image from the internet and place it in a new folder named `public`. For example, you could name the image `nodejs.png`.

### Here's how the code works:
- The server listens for incoming HTTP requests using Node.js’s built-in http module.
- If the request URL is '/', it responds with a plain text message: "Welcome to the server!".
- If the request URL is '/image', it enters the else if block that handles image serving.
- Inside this block, it uses path.join() to create the full path to the nodejs.png file inside the public directory.
- Then, fs.readFile() is used to read the image file asynchronously.
- If there's an error (like if the file doesn't exist), it sends a 500 Internal Server Error response with a plain text message.
- If the file is read successfully, it sets the Content-Type header to image/png and sends the image data as the response.
- For any other route that doesn’t match '/' or '/image', it returns a 404 Not Found error.
#### Task:

Complete the code to store the path of the image stored in `/public` directory. Image name is `nodejs.png`

Change the URL in the browser to `/image` like given below:

Click "Submit" to go to the next problem.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T07:09:06.241Z  

```cpp
const http = require('http');
const fs = require('fs');
const path = require('path');

const server = http.createServer((req, res) => {
if (req.url === '/') {
res.writeHead(200, { 'Content-Type': 'text/plain' });
res.end('Welcome to the server!');
} else if (req.url === '/image') {
// complete the code to get the image path
const imagePath = path.join(__dirname, 'public', 'nodejs.png');

fs.readFile(imagePath, (err, data) => {
if (err) {
res.writeHead(500, { 'Content-Type': 'text/plain' });
res.end('Internal Server Error');
} else {
res.writeHead(200, { 'Content-Type': 'image/png' });
res.end(data);
}
});
} else {
res.writeHead(404, { 'Content-Type': 'text/plain' });
res.end('Not Found');
}
});

const port = 3000;
server.listen(port, () => {
console.log(`Server listening on port ${port}`);
});

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB66)