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