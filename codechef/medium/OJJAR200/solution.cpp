                                                                                                                            }
                                                                                                                              };

                                                                                                                                // STEP 2: Use useEffect to attach and clean up the event listener
                                                                                                                                  useEffect(() => {
                                                                                                                                      window.addEventListener('keydown', handleKeyDown);

                                                                                                                                          // Cleanup function to avoid memory leaks
                                                                                                                                              return () => {
                                                                                                                                                    window.removeEventListener('keydown', handleKeyDown);
                                                                                                                                                        };
                                                                                                                                                          }, []);

                                                                                                                                                            // --- End of Part 3 ---

                                                                                                                                                              return (
                                                                                                                                                                  <div className="container">
                                                                                                                                                                        <h1>2048 Game</h1>
                                                                                                                                                                              <div className="board">
                                                                                                                                                                                      {board.map((row, rowIndex) => (
                                                                                                                                                                                                <div key={rowIndex} className="row">
                                                                                                                                                                                                            {row.map((cell, cellIndex) => (
                                                                                                                                                                                                                          <div key={cellIndex} className={`cell cell-${cell}`}>
                                                                                                                                                                                                                                          {cell !== 0 ? cell : ''}
                                                                                                                                                                                                                                                        </div>
                                                                                                                                                                                                                                                                    ))}
                                                                                                                                                                                                                                                                              </div>
                                                                                                                                                                                                                                                                                      ))}
                                                                                                                                                                                                                                                                                            </div>
                                                                                                                                                                                                                                                                                                </div>
                                                                                                                                                                                                                                                                                                  );
                                                                                                                                                                                                                                                                                                  }

                                                                                                                                                                                                                                                                                                  export default App;