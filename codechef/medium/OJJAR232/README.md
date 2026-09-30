# OJJAR232

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Improve your aim
- In this game, colored circles appear randomly on the screen every second. Your goal is to click on them to increase your score before they disappear. The game ends after a fixed time.
- Your task is to complete the given React project using useState, useEffect, and useRef.

 **Functionality** 

- Circles appear in random locations every second.
- Each circle disappears automatically after 1 second.
- Clicking a circle increases your score by 1.
- A countdown timer shows how much time is left.
- After time runs out, the game stops and shows the final score.

 **TODOs in Code** 

- Initialize the following state variables using useState: circles: an array of circle objects score: number, initial value 0 timeLeft: number, initial value (10)
- Create a useRef hook to store the circle generation interval ID.
- Implement the handleCircleClick(id) function: Use setScore to increase the score. Use setCircles to remove the clicked circle by filtering it out.
- Inside the first useEffect, set up a timer using setInterval to generate one random circle every second. Store the interval ID in intervalRef.current. Clear the interval on cleanup.
- Provide the correct dependency array for the above useEffect (should rerun when timeLeft changes).
- Inside the second useEffect, implement a countdown timer using setInterval that decreases timeLeft by 1 every second. Stop the timer when time reaches 0. Clear the interval on cleanup.

 **What’s Provided** 

- Prebuilt Circle component for rendering.
- getRandomPosition() utility function for generating random coordinates.
- Game UI structure is already written for you.
- Styling is provided in App.css.

 **Output Example** 

 **Helpful Resources** 

- Codechef React course
- React useState Docs
- React useEffect Docs
- React useRef Docs
- setInterval – MDN
- Array.prototype.filter – MDN

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T09:29:04.320Z  

```cpp
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
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR232)