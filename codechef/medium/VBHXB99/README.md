# VBHXB99

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Simple To-Do API

Let's build a very basic To-Do API using Express. This API will allow users to add new To-Dos via a form submission and also via JSON.

 **Problem:** 

We'll create a server that can receive To-Do submissions via an HTML form and also accept To-Do data as JSON.

- The HTML form will have a single field for task.
- The server should log the form data (the task) to the console when the form is submitted.
- The server should also accept JSON To-Do data with a task field.
- The server should log the JSON data to the console when it receives a JSON submission and send a JSON response confirming receipt.

 **Requirements:** 

- Create a route /add-todo-form to handle form submissions.
- Create a route /add-todo-json to handle JSON submissions.
- Log the received data to the console for both form and JSON submissions.
- Send a simple text response for form submissions (e.g., "To-Do added!").

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T05:30:09.749Z  

```cpp
                            });
                            console.log(`Server listening on port ${PORT}`);
            });

            // Route to handle JSON submissions
            app.post('/add-todo-json', (req, res) => {
                console.log('JSON To-Do received:');
                    console.log(req.body);
                        res.json({ message: 'To-Do received successfully', task: req.body.task });
                        });

                        // Start the server
                        const PORT = 3000;
                        app.listen(PORT, () => {
            res.send('To-Do added successfully!');
        console.log(req.body);
    console.log('Form To-Do received:');

// Route to handle form submissions
app.post('/add-todo-form', (req, res) => {
app.use(express.json());

// Serve static files from the "public" folder (including todo.html)
app.use(express.static(path.join(__dirname, 'public')));

// Middleware to parse JSON data
app.use(express.urlencoded({ extended: false }));

// Middleware to parse URL-encoded form data
const app = express();

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB99)