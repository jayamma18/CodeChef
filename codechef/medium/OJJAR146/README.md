# OJJAR146

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Why We Need Lazy Loading

If you had  **lazy loading:** 

- Only the code for the page being visited would be downloaded at first (for example, just Home.jsx).
- Other pages (About, Dashboard, ProductDetails) would be loaded on demand when the user navigates to them.
- This means: Faster initial load (small bundle). But navigation to a new page might take a short delay (because React has to fetch the new chunk of code).

 **With Lazy Loading (using React.lazy + Suspense):** 
"Only the components you need right now are loaded. First load is lighter and faster, but new routes require fetching code on demand."

Let's understand this By previous example using Lazy Loading:

- How It Works in This Example Instead of normal imports, we use React.lazy(() => import(...)). Example:

```
// Lazy imports (code-splitting)
const Home = lazy(() => import('./pages/Home.jsx'))
const About = lazy(() => import('./pages/About.jsx'))
const Dashboard = lazy(() => import('./pages/Dashboard.jsx'))
const ProductDetails = lazy(() => import('./pages/ProductDetails.jsx'))

```

- This tells React: "Don’t include About in the initial bundle. Load it only when the user goes to /about."- We wrap routes in <Suspense> with a fallback UI (like a spinner).
- While the new component’s code is being fetched, the spinner shows. Once the component loads, React renders it normally.

 **User Experience with Lazy Loading** 

- First load: Faster, because only Home (the initial route) is loaded.
- Navigation: When user visits /about or /dashboard, React downloads that component's code on demand.
- Fallback: If the network is slow, the LoadingSpinner shows until the component arrives.

Run code and Refer below video to understand this example :

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T10:32:31.493Z  

```cpp
import { Suspense, lazy, useState } from 'react'
import { Link, Route, Routes, useLocation } from 'react-router-dom'

// Lazy imports (code-splitting)
const Home = lazy(() => import('./pages/Home.jsx'))
const About = lazy(() => import('./pages/About.jsx'))
const Dashboard = lazy(() => import('./pages/Dashboard.jsx'))
const ProductDetails = lazy(() => import('./pages/ProductDetails.jsx'))

function LoadingSpinner() {
  return (
      <div className="center">
            <div className="spinner" />
                  <p>Loading...</p>
                      </div>
                        )
                        }

                        export default function App() {
                          const location = useLocation()
                            const [slowNetwork, setSlowNetwork] = useState(false)

                              return (
                                  <div className="app">
                                        <header>
                                                <h1>React Lazy Loading + Suspense</h1>
                                                        <nav>
                                                                  <Link to="/">Home</Link>
                                                                            <Link to="/about">About</Link>
                                                                                      <Link to="/dashboard">Dashboard</Link>
                                                                                                <Link to="/product/42">Product 42</Link>
                                                                                                        </nav>
                                                                                                                <label className="slow-toggle">
                                                                                                                          <input
                                                                                                                                      type="checkbox"
                                                                                                                                                  checked={slowNetwork}
                                                                                                                                                              onChange={(e) => setSlowNetwork(e.target.checked)}
                                                                                                                                                                        />
                                                                                                                                                                                  Simulate slow network
                                                                                                                                                                                          </label>
                                                                                                                                                                                                </header>

                                                                                                                                                                                                      {/* Suspense shows fallback while lazy chunks load */}
                                                                                                                                                                                                            <Suspense fallback={<LoadingSpinner />}>
                                                                                                                                                                                                                    <Routes location={location}>
                                                                                                                                                                                                                              <Route path="/" element={<Home slow={slowNetwork} />} />
                                                                                                                                                                                                                                        <Route path="about" element={<About />} />
                                                                                                                                                                                                                                                  <Route path="dashboard" element={<Dashboard slow={slowNetwork} />} />
                                                                                                                                                                                                                                                            <Route path="product/:id" element={<ProductDetails slow={slowNetwork} />} />
                                                                                                                                                                                                                                                                      <Route path="*" element={<p className="center">Not Found</p>} />
                                                                                                                                                                                                                                                                              </Routes>
                                                                                                                                                                                                                                                                                    </Suspense>
                                                                                                                                                                                                                                                                                        </div>
                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                          }
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR146)