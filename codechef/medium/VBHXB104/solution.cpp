const express = require('express');
const app = express();

// Route 1: Welcome message at root route
app.get('/', (req, res) => {
    res.send('<h1>Welcome to our store!</h1>');
    });

    // Route 2: Product data as JSON
    app.get('/products', (req, res) => {
        const products = [
                { id: 1, name: 'Laptop', price: 999 },
                        { id: 2, name: 'Keyboard', price: 75 },
                                { id: 3, name: 'Mouse', price: 25 }
                                    ];

                                        res.json(products);
                                        });

                                        // Start the server
                                        const PORT = 3000;
                                        app.listen(PORT, () => {
                                            console.log(`Server is running on http://localhost:${PORT}`);
                                            });