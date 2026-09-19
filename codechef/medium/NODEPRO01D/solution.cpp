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
