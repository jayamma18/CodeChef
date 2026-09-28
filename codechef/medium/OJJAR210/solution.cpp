                  setCount((prev) => prev + amount);

                      // 2. Set the fling message & unique key to re-trigger animation
                          setFlingMessage(`+${amount}`);
                              setFlingKey(Date.now());

                                  // 3. Clear existing timeout
                                      if (flingTimeoutRef.current) {
                                            clearTimeout(flingTimeoutRef.current);
                                                }

                                                    // 4. Set new timeout to reset the message
                                                        flingTimeoutRef.current = setTimeout(() => {
                                                              setFlingMessage('');
                                                                    flingTimeoutRef.current = null;
                                                                        }, 1200);
                                                                          };

                                                                            return (
                                                                                <div className={styles.container}>
                                                                                      <h1>Animated Counter</h1>

                                                                                            {/* Counter Display Area */}
                                                                                                  <div className={styles.counterDisplayWrapper}>
                                                                                                          <div className={styles.counterDisplay}>
                                                                                                                    {/* Animated count value */}
                                                                                                                              <span key={count} className={styles.animatedValue}>
                                                                                                                                          {count}
                                                                                                                                                    </span>
                                                                                                                                                            </div>

                                                                                                                                                                    {/* Fling Message */}
                                                                                                                                                                            <div key={flingKey} className={styles.flingMessage}>
                                                                                                                                                                                      {flingMessage}
                                                                                                                                                                                              </div>
                                                                                                                                                                                                    </div>

                                                                                                                                                                                                          {/* Control Buttons */}
                                                                                                                                                                                                                <div className={styles.controls}>
                                                                                                                                                                                                                        <button onClick={() => handleIncrement(1)}>+1</button>
                                                                                                                                                                                                                                <button onClick={() => handleIncrement(5)}>+5</button>
                                                                                                                                                                                                                                        <button onClick={() => handleIncrement(10)}>+10</button>
                                                                                                                                                                                                                                              </div>
                                                                                                                                                                                                                                                  </div>
                                                                                                                                                                                                                                                    );
                                                                                                                                                                                                                                                    }