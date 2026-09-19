const express = require('express');
const app = express();

// Middleware to parse JSON request bodies
app.use(express.json());

app.post('/products', (req, res) => {
    const { name, price, quantity } = req.body || {};

        // Check if all required fields are present
            if (name === undefined || price === undefined || quantity === undefined) {
                    return res.status(400).send("Name, price, and quantity are required.");
                        }

                            // Validate name
                                if (typeof name !== 'string' || name.trim() === '') {
                                        return res.status(400).send("Name must be a non-empty string.");
                                            }

                                                // Validate price
                                                    if (typeof price !== 'number' || price <= 0) {
                                                            return res.status(400).send("Price must be a number greater than 0.");
                                                                }

                                                                    // Validate quantity
                                                                        if (typeof quantity !== 'number' || !Number.isInteger(quantity) || quantity < 0) {
                                                                                return res.status(400).send("Quantity must be an integer greater than or equal to 0.");
                                                                                    }

                                                                                        // If all checks pass
                                                                                            res.status(200).send("Product added successfully!");
                                                                                            });

                                                                                            app.listen(8080, () => {
                                                                                                console.log('Server listening on port 8080');
                                                                                                });