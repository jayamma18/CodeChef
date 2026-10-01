import './App.css'; // We'll provide this CSS

// 👉 Your task is to modify THIS component
function Button({ children, className = '', ...otherProps }) {
  // Problem 1: The type="button" below can be overridden by {...otherProps}
    // Problem 2: The className prop replaces "btn" instead of merging with it.
      //            We need to combine "btn" and the user's className.

        const finalClassName = `btn ${className}`.trim();

          return (
              <button {...otherProps} type="button" className={finalClassName}>
                    {children}
                        </button>
                          );
                          }

                          // Example Usage (You don't need to change this part)
                          function App() {
                            return (
                                <div>
                                      <p>Basic Button (should have class "btn"):</p>
                                            <Button onClick={() => alert('Default clicked!')}>
                                                    Default Button
                                                          </Button>

                                                                <p>Primary Button (should have classes "btn btn-primary"):</p>
                                                                      <Button
                                                                              className="btn-primary"
                                                                                      onClick={() => alert('Primary clicked!')}
                                                                                            >
                                                                                                    Primary Button
                                                                                                          </Button>

                                                                                                                <p>Button trying to override type (should remain type="button"):</p>
                                                                                                                      <Button
                                                                                                                              className="btn-secondary"
                                                                                                                                      type="submit" // This should NOT change the actual button type
                                                                                                                                              onClick={() => alert('Secondary clicked!')}
                                                                                                                                                    >
                                                                                                                                                            Secondary (Still a Button)
                                                                                                                                                                  </Button>

                                                                                                                                                                        <p>Disabled Button (should have "btn" class and be disabled):</p>
                                                                                                                                                                              <Button disabled>
                                                                                                                                                                                      Disabled Button
                                                                                                                                                                                            </Button>
                                                                                                                                                                                                </div>
                                                                                                                                                                                                  );
                                                                                                                                                                                                  }

                                                                                                                                                                                                  export default App; // Assuming this is the main export for display