const express = require('express');
const fs = require('fs');
const path = require('path');

const app = express();
const PORT = 3000;

// Root route to serve the HTML file
app.get('/', (req, res) => {
const filePath = path.join(__dirname, 'index.html');

fs.readFile(filePath, 'utf8', (err, data) => {
if (err) {
res.status(500).send('Error loading HTML file.');
} else {
res.setHeader('Content-Type', 'text/html');
res.send(data);
}
});
});

app.listen(PORT, () => {
console.log(`Server is running at http://localhost:${PORT}`);
});

