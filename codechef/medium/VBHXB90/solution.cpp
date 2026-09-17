const express = require('express');
const app = express();
const port = 3000;

const routeCounts = {};

const requestCounter = (req, res, next) => {
  const route = req.path;

  if (!routeCounts[route]) {
    routeCounts[route] = 0;
  }

  routeCounts[route]++;

  console.log(`Route: ${route}, Count: ${routeCounts[route]}`);

  next();
};

app.use(requestCounter);

app.get('/', (req, res) => {
  res.send('Home Page');
});

___________________________ {
  res.send('About Page');
});
