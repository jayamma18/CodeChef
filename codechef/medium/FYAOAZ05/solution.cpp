const express = require('express');
const app = express();
const port = 3000;

app.set('view engine', 'ejs');

app.get('/', (req, res) => {
  const product = {
    name: "Awesome T-Shirt",
    price: 40
  };
  res.render('product', { product: product });
});

app.listen(port, () => {
  console.log(`Server listening at http://localhost:${port}`);
});
