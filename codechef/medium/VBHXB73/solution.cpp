const express = require('express');

const app = express();

const PORT = 3000;

// Define a route for GET requests to the root path ("/") that responds with "Welcome to the homepage!"
app.get('/', (req, res) => {
res.send('Welcome to the homepage!');
});

// Define a route for GET requests to the path "/products" that responds with "Our products are coming soon!"
app.get('/products', (req, res) => {
res.send('Our products are coming soon!');
});

app.listen(PORT, () => {
console.log(`Server is running on port ${PORT}`);
});
