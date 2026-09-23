# OJJAR110

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Debouncing with useEffect in React

Imagine building a search box where every keystroke triggers an API call to fetch results. If a user types "hello" quickly,  **5 API calls**  fire in rapid succession (one for "h", "he", "hel", etc.). This creates two big issues:

- Performance Overload: The app (and server) gets flooded with unnecessary requests.
- Stale Data: Earlier API responses might arrive after later ones, causing incorrect results.

But what if we could wait until the user pauses typing (e.g., for 500ms) before making the API call? That’s exactly what  **debouncing**  does!

#### Hello World Example

Let’s create a simple input field that debounces its output to the console.

```
import { useState, useEffect } from 'react';

function SearchInput() {
  const [inputValue, setInputValue] = useState('');

  useEffect(() => {
    // Create a timer that runs after 500ms of inactivity
    const debounceTimer = setTimeout(() => {
      console.log('Debounced value:', inputValue);
    }, 500);

    // Cleanup: Cancel the timer if inputValue changes before 500ms
    return () => clearTimeout(debounceTimer);
  }, [inputValue]); // Re-run effect when inputValue changes

  return (
    <input
      type="text"
      value={inputValue}
      onChange={(e) => setInputValue(e.target.value)}
      placeholder="Type something..."
    />
 );
}

export default SearchInput;

```

#### How It Works
- State Setup: inputValue tracks the text in the input field.
- useEffect Dependency: The effect runs whenever inputValue changes.
- Debounce Logic: A setTimeout delays the console log by 500ms. If the user keeps typing, the cleanup function (clearTimeout) cancels the previous timer.
- Final Execution: The console logs the value only after the user stops typing for 500ms.
#### Task

In the current implementation, the movie list filters  **on every keystroke**. If you type quickly (e.g., "matrix"):

- Re-renders 5 times unnecessarily
- Feels jittery to users
- Wastes resources filtering partial queries like "m", "ma", "mat"

 **Your Goal:** 
Add debouncing so the list only filters  **500ms after the user stops typing**.

 **Implementation Steps** 

- Create Debounce Timer Inside the effect, use setTimeout to delay filtering by 500ms
- Implement Cleanup Function Return a function that clears the timer using clearTimeout
- Update Filtered Movies Move the filtering logic inside the timer's callback Use setFilteredMovies to update the state

 **Hints** 

- Start by adding the useEffect hook with [searchQuery] as dependency
- The cleanup function should cancel any pending timers
- Remember to wrap your filtering logic in setTimeout

You can use this code to  **filter movies**. The  **`filtered`**  variable will store an array of movies whose names include the  **`searchQuery`**  (case-insensitive match).

```
const filtered = movies.filter(movie =>
    movie.toLowerCase().includes(searchQuery.toLowerCase())
);

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T10:41:30.504Z  

```cpp
'Forrest Gump',
'The Shawshank Redemption',
'Fight Club',
'Parasite',
'Spirited Away',
'The Godfather',
'Goodfellas',
'The Social Network',
'Whiplash',
'Mad Max: Fury Road',
'The Grand Budapest Hotel',
'Her',
'Eternal Sunshine of the Spotless Mind',
'No Country for Old Men',
'There Will Be Blood'
];

useEffect(() => {
const timer = setTimeout(() => {
if (searchQuery.trim() === '') {
setFilteredMovies([]);
} else {
const filtered = movies.filter(movie =>
movie.toLowerCase().includes(searchQuery.toLowerCase())
);
setFilteredMovies(filtered);
}
}, 500);

return () => clearTimeout(timer);
}, [searchQuery]);

return (
<div className="movie-search-container">
<input
className="search-input"
type="text"
value={searchQuery}
onChange={(e) => setSearchQuery(e.target.value)}
placeholder="Search for a movie..."
/>
<ul className="movie-list">
{filteredMovies.length > 0 ? (
filteredMovies.map((movie, index) => (
<li className="movie-item" key={index}>{movie}</li>
))
) : (
<div className="no-results">
{searchQuery ? 'No movies found. Try a different search.' : 'Start typing to search movies...'}
</div>
)}
</ul>
</div>
);
}

export default MovieSearch;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR110)