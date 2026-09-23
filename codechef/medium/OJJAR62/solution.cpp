function Welcome() {
      return <h2>Welcome to My React App! 🎉</h2>;
      }

      // Creating the new Goodbye component
      function Goodbye() {
          return <h3>Thanks for visiting! See you soon!</h3>;
          }

          function App() {
              return (
                      <div>
                                  <Welcome /> {/* Using the Welcome component */}
                                              <p>React components make the UI more structured and reusable.</p>
                                                          <Goodbye /> {/* Using the Goodbye component */}
                                                                  </div>
                                                                      );
                                                                      }

                                                                      export default App;
