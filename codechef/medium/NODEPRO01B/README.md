# NODEPRO01B

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Add new notes

Now moving further we would start building our APIs and functionalities.

First we would make the note adding feature.

#### Task:
- Add the frontend file add-note.ejs for /add route.
- Complete the logic to add notes in the route /add: The frontend file have 2 inputs title and content, so check if any of these inputs are missing and if missing response Missing fields. Make a new file with name user input Title +.txt file format and save it in the notes folder. If everything work correctly send response Note saved.
- Add the /notes routes in the server.js to serve all the routes in notes.js file.
### APIs Notes:
Endpoint	Method	Description
`/notes/add`	POST	Adds a new note (from user input)
#### Expected output after clicking on the add-note button:

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:26:34.845Z  

```cpp
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

```

---

[View on CodeChef](https://www.codechef.com/problems/NODEPRO01B)