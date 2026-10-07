function BackgroundChanger() {
  const [count, setCount] = useState(0);

    // Add useEffect here
      useEffect(() => {
          // Check if count reaches 5 or more
              if (count >= 5) {
                    document.body.style.backgroundColor = "lightblue";
                        } else {
                              // Reset background when below 5
                                    document.body.style.backgroundColor = "";
                                        }
                                          }, [count]); // Add count as dependency to trigger effect on count change

                                            return (
                                                <div className="container">
                                                      <h1>Count: {count}</h1>
                                                            <button className="btn" onClick={() => setCount(count + 1)}>Increase Count</button>
                                                                  <button className="btn reset-btn" onClick={() => setCount(0)}>Reset</button>
                                                                      </div>
                                                                        );
                                                                        }

                                                                        export default BackgroundChanger;