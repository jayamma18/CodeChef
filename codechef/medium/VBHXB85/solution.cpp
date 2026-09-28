const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
  res.send('Categories Route');
  });

  router.get('/:id', (req, res) => {
    res.send(`Category with ID ${req.params.id}`);
    });

    module.exports = router;