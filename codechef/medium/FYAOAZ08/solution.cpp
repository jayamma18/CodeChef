const express = require('express');
const app = express();

// Set the view engine to ejs
app.set('view engine', 'ejs');

// Route to display personalized greeting
app.get('/', (req, res) => {
  // Prepare the data to be passed to the view
  const name = 'Abhay'; // You can replace with req.query.name to make it dynamic
  const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
  const currentDay = days[new Date().getDay()];

  // Pass the data to the 'greeting' view
  res.render('greeting', { name: name, dayOfWeek: currentDay });
});

app.listen(3000, () => {
  console.log('Server is running on port 3000');
});
