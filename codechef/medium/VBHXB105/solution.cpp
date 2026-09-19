const express = require('express');
const app = express();

// Root route returning HTML message
app.get('/', (req, res) => {
    res.send('<h1>Welcome to the Book Store!</h1>');
    });
    
    // /books route returning JSON data
    app.get('/books', (req, res) => {
        const books = [
                { "id": 1, "title": "The Hitchhiker's Guide to the Galaxy", "author": "Douglas Adams" },
                        { "id": 2, "title": "Pride and Prejudice", "author": "Jane Austen" },
                                { "id": 3, "title": "1984", "author": "George Orwell" }
                                    ];
                                    
                                        res.json(books);
                                        });
                                        
                                        // Start server
                                        const PORT = 3000;
                                        app.listen(PORT, () => {
                                            console.log(`Server is running on port ${PORT}`);
                                            });// write your code here
