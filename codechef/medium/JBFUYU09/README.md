# JBFUYU09

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Personal Bookshelf API

Fantastic! You've successfully mapped CRUD operations to HTTP methods for a To-Do list. Now, let's reinforce that knowledge with a different real-world example.

Imagine you are creating a backend service for a "Personal Bookshelf" application where users can keep track of the books they own. You have been given the basic Express server and a Mongoose `Book` model.

The `Book` model has the following schema:

- title: A String for the book's title.
- author: A String for the author's name.
- pages: A Number for the total page count.

Your goal is to implement the complete set of CRUD endpoints for managing these books. You will need to write the logic for each route to perform the correct database operation using Mongoose.

 **Your Task:** 

- POST /books: Create a new book. The book's details will be provided in the request body (req.body). The server should respond with the newly created book object.
- GET /books: Retrieve a list of all books in the collection.
- PUT /books/:id: Update an existing book's details using its ID. The ID will be in req.params.id, and the update information will be in req.body. The server should respond with the updated book object.
- DELETE /books/:id: Remove a book from the collection by its ID (req.params.id). The server should respond with the book object that was deleted.

Remember to use the appropriate HTTP method for each action and the corresponding Mongoose function you've learned about.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-08T10:38:38.135Z  

```cpp
                                                                                                                                                                                                                                         id,
                                                                                                                                                                                                                                                     req.body,
                                                                                                                                                                                                                                                                 { new: true, runValidators: true }
                                                                                                                                                                                                                                                                         );

                                                                                                                                                                                                                                                                                 if (!updatedBook) {
                                                                                                                                                                                                                                                                                             return res.status(404).json({ message: 'Book not found' });
                                                                                                                                                                                                                                                                                                     }

                                                                                                                                                                                                                                                                                                             res.json(updatedBook);
                                                                                                                                                                                                                                                                                                                 } catch (error) {
                                                                                                                                                                                                                                                                                                                         res.status(400).json({ error: error.message });
                                                                                                                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                                                                                                             });

                                                                                                                                                                                                                                                                                                                             /**
                                                                                                                                                                                                                                                                                                                              * DELETE - Remove a book by ID
                                                                                                                                                                                                                                                                                                                               * DELETE /books/:id
                                                                                                                                                                                                                                                                                                                                */
                                                                                                                                                                                                                                                                                                                                app.delete('/books/:id', async (req, res) => {
                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                            const { id } = req.params;

                                                                                                                                                                                                                                                                                                                                                    const deletedBook = await Book.findByIdAndDelete(id);

                                                                                                                                                                                                                                                                                                                                                            if (!deletedBook) {
                                                                                                                                                                                                                                                                                                                                                                        return res.status(404).json({ message: 'Book not found' });
                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                        res.json({ message: 'Book deleted successfully', deletedBook });
                                                                                                                                                                                                                                                                                                                                                                                            } catch (error) {
                                                                                                                                                                                                                                                                                                                                                                                                    res.status(500).json({ error: error.message });
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                        });

                                                                                                                                                                                                                                                                                                                                                                                                        // Start the server
                                                                                                                                                                                                                                                                                                                                                                                                        const PORT = process.env.PORT || 8080;
                                                                                                                                                                                                                                                                                                                                                                                                        app.listen(PORT, () => {
                                                                                                                                                                                                                                                                                                                                                                                                            console.log(`Bookshelf API running at http://localhost:${PORT}`);
                                                                                                                                                                                                                                                                                                                                                                                                            });
```

---

[View on CodeChef](https://www.codechef.com/problems/JBFUYU09)