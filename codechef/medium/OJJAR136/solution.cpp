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
