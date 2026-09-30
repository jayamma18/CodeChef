            <div
                  className="circle"
                        data-testid="circle"
                              style={{ left: `${x}%`, top: `${y}%` }}
                                    onClick={onClick}
                                        />
                                          );
                                          }

                                          function App() {
                                            // TODO 1: Initialize circles, score, and timeLeft state variables using useState
                                              const [circles, setCircles] = useState([]);
                                                const [score, setScore] = useState(0);
                                                  const [timeLeft, setTimeLeft] = useState(10);

                                                    // TODO 2: Create a ref using useRef to store the interval ID
                                                      const intervalRef = useRef(null);

                                                        // Generates one random circle each second
                                                          const generateRandomCircle = () => {
                                                              setCircles([]); // Clear existing circles

                                                                  const { x, y } = getRandomPosition();
                                                                      const id = Date.now(); // Unique ID based on timestamp
                                                                          const newCircle = { id, x, y };

                                                                              setCircles([newCircle]); // Add the new circle

                                                                                  // Auto-remove the circle after 1 second
                                                                                      setTimeout(() => {
                                                                                            setCircles([]);
                                                                                                }, 1000);
                                                                                                  };

                                                                                                    // TODO 3: Implement click handler logic
                                                                                                      const handleCircleClick = (id) => {
                                                                                                          setScore((prevScore) => prevScore + 1);
                                                                                                              setCircles((prevCircles) => prevCircles.filter((circle) => circle.id !== id));
                                                                                                                };

                                                                                                                  // useEffect to handle circle generation every second
                                                                                                                    useEffect(() => {
                                                                                                                        if (timeLeft <= 0) return;

                                                                                                                            // TODO 4: Set up an interval to generate circles every second and store the interval ID in intervalRef
                                                                                                                                intervalRef.current = setInterval(generateRandomCircle, 1000);

                                                                                                                                    return () => clearInterval(intervalRef.current); // Cleanup interval
                                                                                                                                      }, [timeLeft]);

                                                                                                                                        // useEffect to handle countdown timer
                                                                                                                                          useEffect(() => {
                                                                                                                                              if (timeLeft <= 0) {
                                                                                                                                                    clearInterval(intervalRef.current); // Stop circle generation when time runs out
                                                                                                                                                          return;
                                                                                                                                                              }

                                                                                                                                                                  // TODO 6: Set up a countdown timer that decreases timeLeft every second
                                                                                                                                                                      const timer = setInterval(() => {
                                                                                                                                                                            setTimeLeft((prevTime) => prevTime - 1);
                                                                                                                                                                                }, 1000);

                                                                                                                                                                                    return () => clearInterval(timer); // Cleanup countdown
                                                                                                                                                                                      }, [timeLeft]);

                                                                                                                                                                                        return (
                                                                                                                                                                                            <div className="game-container">
                                                                                                                                                                                                  <h1>Click the Circles!</h1>
                                                                                                                                                                                                        <p>Time Left: {timeLeft}</p>
                                                                                                                                                                                                              <p>Score: {score}</p>

                                                                                                                                                                                                                    {/* Render all active circles */}
                                                                                                                                                                                                                          {circles.map((circle) => (
                                                                                                                                                                                                                                  <Circle
                                                                                                                                                                                                                                            key={circle.id}
                                                                                                                                                                                                                                                      x={circle.x}
                                                                                                                                                                                                                                                                y={circle.y}
                                                                                                                                                                                                                                                                          onClick={() => handleCircleClick(circle.id)}
                                                                                                                                                                                                                                                                                  />
                                                                                                                                                                                                                                                                                        ))}

                                                                                                                                                                                                                                                                                              {/* Game over message */}
                                                                                                                                                                                                                                                                                                    {timeLeft === 0 && (
                                                                                                                                                                                                                                                                                                            <h2 className="end-msg">Game Over! Final Score: {score}</h2>
                                                                                                                                                                                                                                                                                                                  )}
                                                                                                                                                                                                                                                                                                                      </div>
                                                                                                                                                                                                                                                                                                                        );
                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                        export default App;