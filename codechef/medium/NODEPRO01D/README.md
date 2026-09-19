# NODEPRO01D

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### View and delete a note

Now we are on the last stage of our first project.

The last functionality we have to implement is viewing a single note and its content and an option to delete it.

#### Task:
- Complete the notes.js code to implement the functionality of viewing a particular note on /:title route. The titile name should not contain the.txt extension. And render the view-note.ejs to show the note on frontend.
- Complete the functionality of deleting the note on /:title/delete route. After deleting the note, go back to /notes route.
- Complete notes.ejs to link all the notes to their particular route and show its content.
- Complete the view-note.ejs to show the title as heading and content of the note. And add the route to delete the particular note.
#### Expected working:

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:28:56.173Z  

```cpp
<!DOCTYPE html>
<html>
    <head>
        <title>Notes App</title>
        <link rel="stylesheet" href="/styles.css" />
    </head>
    <body>
        <h2><%= title %></h2>
        <pre><%= content %></pre>
        <form method="POST" action="/notes/<%= title %>/delete">
          <button type="submit">🗑 Delete Note</button>
        </form>
        <a href="/notes">⬅ Back to Notes</a>
        
</body>
</html>

```

---

[View on CodeChef](https://www.codechef.com/problems/NODEPRO01D)