// write your code here.
const express = require('express');
const app = express();

const greeting = 'Hello, there!';

app.get('/', (req, res) => {
res.send(greeting);
});

app.listen(3000, () => {
console.log('Server is running on port 3000');
});