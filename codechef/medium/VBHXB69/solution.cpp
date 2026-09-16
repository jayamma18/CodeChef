const express = require('express');
const app = express();

// Use PORT to set the port number as 3000
const PORT = 3000;

// Simple route
app.get('/', (req, res) => {
    res.send('Hello from Express!');
    });

    // Start the server
    app.listen(PORT, () => {
        console.log(`Server is running on port ${PORT}`);
        });
