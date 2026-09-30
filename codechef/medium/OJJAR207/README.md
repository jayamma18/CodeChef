# OJJAR207

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Implementing Game Over Logic

Okay, great! We’ve finished merging the logic for all arrow keys. I’ve now added a bit more code to the `handleKeyDown` function:

```
if (JSON.stringify(board) !== JSON.stringify(processedBoard)) {
   const boardWithNewTile = addRandomTile(processedBoard);
   setBoard(boardWithNewTile);
}

```

This ensures that a new random tile is added only when the board actually changes.

Now, let's add the Game Over condition to your 2048 game!

 **Goal:**  Determine when the game is over and display a "Game Over" message to the player. Once the game is over, no further moves should be possible.

 **Requirements:** 

- Implement isGameOver(board) Function: It needs to determine if the game has reached a state where no more valid moves can be made. The game is over if: There are no empty cells (all cells are filled with numbers). AND there are no adjacent cells (horizontally or vertically) with the same value that could be merged. The function should return true if the game is over, and false otherwise.
- Display "Game Over" Message: Conditionally render a div with the text "Game Over" and the class name game-over when the game is over.
- Prevent Moves When Game Over: In the handleKeyDown function, if the game is over, immediately return and do not process any key presses for moves.

 **Your app should look like this when the game ends.**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T07:14:56.575Z  

```cpp
                                                                            }

                                                                            function merge(board) {
                                                                              const newBoard = board.map(row => [...row]);
                                                                                for (let r = 0; r < SIZE; r++) {
                                                                                    for (let c = 0; c < SIZE - 1; c++) {
                                                                                          if (newBoard[r][c] !== 0 && newBoard[r][c] === newBoard[r][c + 1]) {
                                                                                                  newBoard[r][c] *= 2;
                                                                                                          newBoard[r][c + 1] = 0;
                                                                                                                }
                                                                                                                    }
                                                                                                                      }
                                                                                                                        return newBoard;
                                                                                                                        }

                                                                                                                        function moveLeft(board) {
                                                                                                                          let newBoard = compress(board);
                                                                                                                            newBoard = merge(newBoard);
                                                                                                                              newBoard = compress(newBoard);
                                                                                                                                return newBoard;
                                                                                                                                }

                                                                                                                                function moveRight(board) {
                                                                                                                                  let reversed = reverse(board);
                                                                                                                                    let moved = moveLeft(reversed);
                                                                                                                                      return reverse(moved);
                                                                                                                                      }

                                                                                                                                      function moveUp(board) {
                                                                                                                                        let transposed = transpose(board);
                                                                                                                                          let moved = moveLeft(transposed);
                                                                                                                                            return transpose(moved);
                                                                                                                                            }

                                                                                                                                            function moveDown(board) {
                                                                                                                                              let transposed = transpose(board);
                                                                                                                                                let moved = moveRight(transposed);
                                                                                                                                                  return transpose(moved);
                                                                                                                                                  }

                                                                                                                                                  // Implement Game Over Function
                                                                                                                                                  function isGameOver(board) {
                                                                                                                                                    for (let r = 0; r < SIZE; r++) {
                                                                                                                                                        for (let c = 0; c < SIZE; c++) {
                                                                                                                                                              // 1. If any cell is empty, the game is not over
                                                                                                                                                                    if (board[r][c] === 0) return false;

                                                                                                                                                                          // 2. Check horizontally adjacent tile
                                                                                                                                                                                if (c < SIZE - 1 && board[r][c] === board[r][c + 1]) return false;

                                                                                                                                                                                      // 3. Check vertically adjacent tile
                                                                                                                                                                                            if (r < SIZE - 1 && board[r][c] === board[r + 1][c]) return false;
                                                                                                                                                                                                }
                                                                                                                                                                                                  }
                                                                                                                                                                                                    // No empty cells and no available merges left
                                                                                                                                                                                                      return true;
                                                                                                                                                                                                      }

                                                                                                                                                                                                      function App() {
                                                                                                                                                                                                        const [board, setBoard] = useState(() => {
                                                                                                                                                                                                            let newBoard = getEmptyBoard();
                                                                                                                                                                                                                newBoard = addRandomTile(newBoard);
                                                                                                                                                                                                                    newBoard = addRandomTile(newBoard);
                                                                                                                                                                                                                        return newBoard;
                                                                                                                                                                                                                          });

                                                                                                                                                                                                                            const [gameOver, setGameOver] = useState(false);

                                                                                                                                                                                                                              const handleKeyDown = (event) => {
                                                                                                                                                                                                                                  // Prevent moves if game is already over
                                                                                                                                                                                                                                      if (gameOver) return;

                                                                                                                                                                                                                                          let processedBoard;
                                                                                                                                                                                                                                              const currentBoardCopy = board.map(row => [...row]);

                                                                                                                                                                                                                                                  if (event.key === 'ArrowLeft') {
                                                                                                                                                                                                                                                        processedBoard = moveLeft(currentBoardCopy);
                                                                                                                                                                                                                                                            } else if (event.key === 'ArrowRight') {
                                                                                                                                                                                                                                                                  processedBoard = moveRight(currentBoardCopy);
                                                                                                                                                                                                                                                                      } else if (event.key === 'ArrowUp') {
                                                                                                                                                                                                                                                                            processedBoard = moveUp(currentBoardCopy);
                                                                                                                                                                                                                                                                                } else if (event.key === 'ArrowDown') {
                                                                                                                                                                                                                                                                                      processedBoard = moveDown(currentBoardCopy);
                                                                                                                                                                                                                                                                                          } else {
                                                                                                                                                                                                                                                                                                return;
                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                        // Check if the move changed the board state
                                                                                                                                                                                                                                                                                                            if (JSON.stringify(board) !== JSON.stringify(processedBoard)) {
                                                                                                                                                                                                                                                                                                                  const nextBoard = addRandomTile(processedBoard);
                                                                                                                                                                                                                                                                                                                        setBoard(nextBoard);

                                                                                                                                                                                                                                                                                                                              // Check if the board reached game over state
                                                                                                                                                                                                                                                                                                                                    if (isGameOver(nextBoard)) {
                                                                                                                                                                                                                                                                                                                                            setGameOver(true);
                                                                                                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                                                                                                                                        };

                                                                                                                                                                                                                                                                                                                                                          useEffect(() => {
                                                                                                                                                                                                                                                                                                                                                              window.addEventListener('keydown', handleKeyDown);
                                                                                                                                                                                                                                                                                                                                                                  return () => window.removeEventListener('keydown', handleKeyDown);
                                                                                                                                                                                                                                                                                                                                                                    }, [board, gameOver]);

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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          {gameOver && <p className="game-over">Game Over</p>}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              </div>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                );
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR207)