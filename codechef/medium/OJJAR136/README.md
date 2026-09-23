# OJJAR136

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Example to understand Browser Routing in React

Let’s make the simplest React Browser Router example :

In this example we're going to create a React application using Browser Router that has two pages:

1]  **Home Page**  (`/`)

- Displays the text: "Welcome to the Home Page"

2]  **About Page**  (`/about`)

- Displays the text: "This is the About Page"

 **Expected Output Behavior:** 

- Opening / shows Welcome to the Home Page.
- Clicking About link or visiting /about directly shows This is the About Page.
- Navigation happens smoothly without full page reload.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T10:45:58.459Z  

```cpp
import { NavLink, Routes, Route } from 'react-router-dom'
import Home from './pages/Home'
import About from './pages/About'

function App() {
  return (
    <>
      <header>
        <nav className="nav">
          <NavLink to="/" end>Home</NavLink>
          <NavLink to="/about">About</NavLink>
        </nav>
      </header>

      <main>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
        </Routes>
      </main>
    </>
  )
}

export default App

```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR136)