const express = require('express');
const path = require('path');

const app = express();

// Middleware to parse form data
app.use(express.urlencoded({ extended: false }));

// Set EJS as the view engine
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

// Route to display the form
app.get('/favorite-color', (req, res) => {
    res.render('FavColor'); // no data passed on initial render
});

// Route to handle form submission
app.post('/favorite-color', (req, res) => {
    const favoriteColor = req.body.color; // extract color from form data
    console.log('The color submitted is:', favoriteColor);
    res.render('FavColor', { favoriteColor }); // re-render with color
});

// Start the server
app.listen(3000, () => {
    console.log('Server is running on http://localhost:3000');
});
