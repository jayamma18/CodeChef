const express = require('express');
const app = express();
const PORT = 3000;

app.get('/', (req, res) => {
const userAgent = req.headers['user-agent'];
res.send(`Your User-Agent is: ${userAgent}`);
});

app.listen(PORT, () => {
console.log(`Server is running on port ${PORT}`);
});
