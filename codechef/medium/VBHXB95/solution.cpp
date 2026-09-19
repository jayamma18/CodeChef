const express = require('express');
const app = express();
const port = 3000;

// Route /divide that accepts numerator and denominator as query parameters
app.get('/divide', (req, res, next) => {
  try {
    const numerator = Number(req.query.numerator);
    const denominator = Number(req.query.denominator);

    if (isNaN(numerator) || isNaN(denominator)) {
      throw new Error('Numerator and denominator must be numbers');
    }

    if (denominator === 0) {
      // Explicitly throw error for division by zero
      const err = new Error('Division by zero');
      err.type = 'DIV_ZERO';
      throw err;
    }

    const result = numerator / denominator;
    res.send(`Result: ${result}`);
  } catch (err) {
    // Pass any error to the error handling middleware
    next(err);
  }
});

// Error handling middleware