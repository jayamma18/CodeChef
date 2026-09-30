# OJJAR145

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### What Happens Without Lazy Loading

Before we deep dive into How Lazy Loading Works, Let's firstly see what happens if we doesn't use lazy loading

 **Without Lazy Loading (your example):** 
"All components are bundled and loaded upfront. First load is heavier, but later navigation is instant."

 **Let's understand from given Example:** 
In given example code:

```
import Home from './pages/Home.jsx'
import About from './pages/About.jsx'
import Dashboard from './pages/Dashboard.jsx'
import ProductDetails from './pages/ProductDetails.jsx'

```

- These imports are normal ES module imports.
- That means all the components (Home, About, Dashboard, ProductDetails) are bundled and loaded upfront as soon as the app starts.
- When you run the app and open it in the browser, the browser downloads the entire JavaScript bundle, which contains: Home page code About page code Dashboard page code Product details page code (even if the user never visits some of them)

 **User Experience Without Lazy Loading** 

On first load:
The user waits for the browser to download the entire bundle. If the app has many pages/components, this can make the first load slower.

After that:
Navigation between pages is instant, because all the code is already in memory.

Example in your app:
When user goes to `/dashboard`, the Dashboard component shows immediately (no extra network request).
Same for `/product/42` → ProductDetails is already loaded.

Run code and Refer below video to understand this example :

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T10:29:57.481Z  

```cpp
                        onChange={(e) => setSlowNetwork(e.target.checked)}
                    />
                    Simulate slow network
                </label>
            </header>

            {/* 🚫 Suspense removed */}
            <Routes location={location}>
                <Route path="/" element={<Home slow={slowNetwork} />} />
                <Route path="about" element={<About />} />
                <Route path="dashboard" element={<Dashboard slow={slowNetwork} />} />
                <Route path="product/:id" element={<ProductDetails slow={slowNetwork} />} />
                <Route path="*" element={<p className="center">Not Found</p>} />
            </Routes>
        </div>
    )
}

                        type="checkbox"
                        checked={slowNetwork}
    const location = useLocation()
    const [slowNetwork, setSlowNetwork] = useState(false)

    return (
        <div className="app">
            <header>
                <h1>React Example (No Lazy Loading)</h1>
                <nav>
                    <Link to="/">Home</Link>
                    <Link to="/about">About</Link>
                    <Link to="/dashboard">Dashboard</Link>
                    <Link to="/product/42">Product 42</Link>
                </nav>
                <label className="slow-toggle">
                    <input
export default function App() {
import  { useState } from 'react'
import { Link, Route, Routes, useLocation } from 'react-router-dom'

// ✅ Normal imports (all loaded upfront, no lazy loading)
import Home from './pages/Home.jsx'
import About from './pages/About.jsx'
import Dashboard from './pages/Dashboard.jsx'
import ProductDetails from './pages/ProductDetails.jsx'

```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR145)