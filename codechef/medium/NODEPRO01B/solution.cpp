const PORT = process.env.PORT || 3000;

// Middleware
app.use(express.urlencoded({ extended: true }));
app.use(express.static(path.join(__dirname, 'public')));

// View Engine
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

// Routes
app.get('/', (req, res) => {
  res.render('index');
});

// set the notes routes to notes.js file
app.use('/notes', notesRouter);

// Create 'notes' folder if not exists
if (!fs.existsSync('./notes')) fs.mkdirSync('./notes');

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
