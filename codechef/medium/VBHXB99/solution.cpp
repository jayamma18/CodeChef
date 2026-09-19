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
