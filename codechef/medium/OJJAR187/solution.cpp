import './App.css';

// Inline Header Component
function Header() {
  return <header><h1>Header</h1></header>;
  }

  // Inline Hero Component
  function Hero() {
    return <section><h2>Hero Section</h2></section>;
    }

    // Inline About Component
    function About() {
      return <section><h2>About Section</h2></section>;
      }

      // Inline Projects Component
      function Projects() {
        return <section><h2>Projects Section</h2></section>;
        }

        // Inline Blog Component
        function Blog() {
          return <section><h2>Blog Section</h2></section>;
          }

          // Inline Contact Component
          function Contact() {
            return <section><h2>Contact Section</h2></section>;
            }

            // Inline Footer Component
            function Footer() {
              return <footer><p>Footer</p></footer>;
              }

              // Main App Component
              function App() {
                return (
                    <div className="App">
                          <Header />
                                <Hero />
                                      <About />
                                            <Projects />
                                                  <Blog />
                                                        <Contact />
                                                              <Footer />
                                                                  </div>
                                                                    );
                                                                    }

                                                                    export default App;