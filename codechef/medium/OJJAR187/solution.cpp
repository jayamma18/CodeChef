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