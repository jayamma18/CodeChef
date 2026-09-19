# NODEPRO01C

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### View all notes

In this part we will deal with viewing of all the notes that we have made.

We are working on `/notes` route.

#### Task:
- Complete the notes.js to view all the notes present in the notes folder.
- Complete the notes.ejs to traverse all the notes present in the folder and remove the.txt extension while showing the name of the note on the frontend.
### APIs Notes:
Endpoint	Method	Description
`/notes/`	GET	Returns all saved notes
#### Expected working of the backend:

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:26:59.929Z  

```cpp
<!DOCTYPE html>
<html>
<head>
  <title>Notes App</title>
  <link rel="stylesheet" href="/styles.css" />
</head>
<body>
  <h1><a href="/">📓 Notes App</a></h1>

  <a href="/" style="text-decoration: none;">
    <button type="button">⬅ Back to Home</button>

  <h2>All Notes</h2>
  <ul>
      <% notes.forEach(note => { %>
        <li>
              <%= note.replace('.txt', '') %>
        </li>
        <% }) %>
    </ul>
    <a href="/notes/add">➕ Add New Note</a>
    
</body>
</html>
```

---

[View on CodeChef](https://www.codechef.com/problems/NODEPRO01C)