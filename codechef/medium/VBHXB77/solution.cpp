// write your code here.
const express = require('express');
const app = express();

const PORT = 3000;

app.get('/hello', (req, res) => {
res.send(req.url);
});

app.listen(PORT, () => {
console.log(`Server is running on port ${PORT}`);
});