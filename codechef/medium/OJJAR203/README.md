# OJJAR203

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Compressing Tiles to the Left

 **Goal:**  Implement the logic to slide all tiles in each row to the leftmost available positions, effectively "compressing" them and removing any empty spaces between them. You will create a `compress` function for this and then a basic `moveLeft` function that utilizes it.
 **The main rule for this project is:**  after every compression (that results from a `moveLeft` action and actually changes the board), you need to generate one random number (a new tile) on the grid.

 **What We Are Doing in This Chapter:**  We're taking the first major step towards enabling tile movement. When a user wants to move tiles (e.g., left), the first thing that needs to happen is for all existing tiles in each row to slide over, filling any empty spots to their left. For example, a row like `[0, 2, 0, 4]` should become `[2, 4, 0, 0]` after compression.
Following this compression, you must generate one random number (a new tile) on the grid.

for example you can write it like

```
let newBoard;
if (event.key === 'ArrowLeft') {
    newBoard = moveLeft(board);
}

```

 **Your App should be work like that at the end** 
 **How it works** : Press the left arrow ← and all tiles slide to the left.

 **Hints to write compress function** 

```
function compress(board) {
  let newBoard = board.map(row => {
    let newRow = row.filter(val => val !== 0);
    while (newRow.length < SIZE) newRow.push(0);
    return newRow;
  });
  return newBoard;
}

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T07:07:44.081Z  

```cpp
  function getRandomInt(max) {
    return Math.floor(Math.random() * max);
    }

    function addRandomTile(board) {
      const newBoard = board.map(row => [...row]);
        const emptyTiles = [];
          for (let r = 0; r < SIZE; r++) {
              for (let c = 0; c < SIZE; c++) {
                    if (newBoard[r][c] === 0) {
                            emptyTiles.push({ r, c });
                                  }
                                      }
                                        }

                                          if (emptyTiles.length === 0) {
                                              return newBoard;
                                                }

                                                  const { r, c } = emptyTiles[getRandomInt(emptyTiles.length)];
                                                    newBoard[r][c] = Math.random() < 0.9 ? 2 : 4;
                                                      return newBoard;
                                                      }

                                                      // Compress function: filters out zeros and pads with zeros on the right
                                                      function compress(board) {
                                                        let newBoard = board.map(row => {
                                                            let newRow = row.filter(val => val !== 0);
                                                                while (newRow.length < SIZE) {
                                                                      newRow.push(0);
                                                                          }
                                                                              return newRow;
                                                                                });
                                                                                  return newBoard;
                                                                                  }

                                                                                  // MoveLeft function: compresses board and adds a new random tile
                                                                                  function moveLeft(board) {
                                                                                    let newBoard = compress(board);
                                                                                      newBoard = addRandomTile(newBoard);
                                                                                        return newBoard;
                                                                                        }

                                                                                        function App() {
                                                                                          const [board, setBoard] = useState(() => {
                                                                                              let startingBoard = getEmptyBoard();
                                                                                                  startingBoard = addRandomTile(startingBoard);
                                                                                                      startingBoard = addRandomTile(startingBoard);
                                                                                                          return startingBoard;
                                                                                                            });

                                                                                                              const handleKeyDown = (event) => {
                                                                                                                  if (event.key === 'ArrowLeft') {
                                                                                                                        console.log('ArrowLeft pressed');
                                                                                                                              setBoard(prevBoard => moveLeft(prevBoard));
                                                                                                                                  } else if (event.key === 'ArrowRight') {
                                                                                                                                        console.log('ArrowRight pressed');
                                                                                                                                            } else if (event.key === 'ArrowUp') {
                                                                                                                                                  console.log('ArrowUp pressed');
                                                                                                                                                      } else if (event.key === 'ArrowDown') {
                                                                                                                                                            console.log('ArrowDown pressed');
                                                                                                                                                                }
                                                                                                                                                                  };

                                                                                                                                                                    useEffect(() => {
                                                                                                                                                                        window.addEventListener('keydown', handleKeyDown);
                                                                                                                                                                            return () => {
                                                                                                                                                                                  window.removeEventListener('keydown', handleKeyDown);
                                                                                                                                                                                      };
                                                                                                                                                                                        }, []);

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

[View on CodeChef](https://www.codechef.com/problems/OJJAR203)