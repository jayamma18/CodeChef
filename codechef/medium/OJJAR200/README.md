# OJJAR200

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Handling Player Input

Implement functionality to detect when the player presses any of the four arrow keys: `ArrowLeft`, `ArrowRight`, `ArrowUp`, or `ArrowDown`.

#### Requirements:
- Monitor keyboard events and identify when an arrow key is pressed.
- Upon detecting a key press: Log the corresponding key to the console in the following format: If the user presses the left arrow key, log: "ArrowLeft pressed" If the user presses the right arrow key, log: "ArrowRight pressed" If the user presses the up arrow key, log: "ArrowUp pressed" If the user presses the down arrow key, log: "ArrowDown pressed"

 **Your app should be work like that at the end**   **How it works** 

- Click the Toggle Console button >_.
- Console opens inside the app.
- Press the arrow keys (← ↑ → ↓) to move tiles.
- Check the console for instant move updates.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T07:05:21.582Z  

```cpp
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
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR200)