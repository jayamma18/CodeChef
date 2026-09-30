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