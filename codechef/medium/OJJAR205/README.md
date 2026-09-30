# OJJAR205

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Implementing Move Up & Down

Okay, let's tackle moving tiles up and down, again by cleverly re-using logic we (conceptually) already have!

 **Goal:**  Extend your 2048 game to support "move up" and "move down" actions. When the up or down arrow key is pressed, all tiles on the board should slide as far as possible in their respective columns.

 **Feature Requirements:** 

- Sliding Tiles Up: All tiles should move to the topmost available positions in their columns. Example: If a column looks like [0, 2, 0, 4], moving up should change it to [2, 4, 0, 0].
- Sliding Tiles Down: All tiles should move to the bottommost available positions in their columns. Example: If a column looks like [2, 0, 4, 0], moving down should change it to [0, 0, 2, 4].

 **The Core Idea: Transposing the Board (Flipping Rows and Columns)** 

Our "slide left" logic (`compress`) works on rows. To make it work for up/down movements (which affect columns), we need a way to temporarily treat columns as if they were rows. The magic trick for this is  **transposing**  the board.

- What is Transposing? Imagine your game board. Transposing it means swapping its rows and columns. The first row becomes the first column, the second row becomes the second column, and so on. Original Board: [a, b, c] [d, e, f] [g, h, i] Transposed Board: [a, d, g] (Original first column is now the first row) [b, e, h] (Original second column is now the second row) [c, f, i] (Original third column is now the third row)

Once the board is transposed, the original columns are now rows. We can then apply our "slide left" logic to these new rows!

 **Logic for Moving Tiles Up/Down:** 

- Take the current board.
- Transpose it. Now, the original columns are laid out as rows.
- Apply the 'slide left' logic if it is moveUp, and apply the 'slide right' logic if it is moveDown.
- Transpose the result back. Flip it back to its original row/column orientation.

 **Now try to implement it, or you can go another way as well** 

 **Your app should be work like that at the end** 

- Press $←$ (left), $→$ (right), $↑$ (up), $↓$ (down) — tiles slide in that direction.

#### Hints (transpose matrix function)

```
function transpose(board) {
  const newBoard = getEmptyBoard();
  for (let r = 0; r < SIZE; r++) {
    for (let c = 0; c < SIZE; c++) {
      newBoard[c][r] = board[r][c];
    }
  }
  return newBoard;
}

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T07:10:59.829Z  

```cpp
import React, { useState, useEffect } from 'react';
import './App.css';

const SIZE = 4;

function getEmptyBoard() {
  return Array(SIZE).fill(null).map(() => Array(SIZE).fill(0));
  }

  function getRandomInt(max) {
    return Math.floor(Math.random() * max);
    }

    function addRandomTile(board) {
      const emptyTiles = [];
        for (let r = 0; r < SIZE; r++) {
            for (let c = 0; c < SIZE; c++) {
                  if (board[r][c] === 0) emptyTiles.push({ r, c });
                      }
                        }

                          if (emptyTiles.length === 0) return board;
                            const { r, c } = emptyTiles[getRandomInt(emptyTiles.length)];
                              board[r][c] = Math.random() < 0.9 ? 2 : 4;
                                return board;
                                }

                                function reverse(board) {
                                  return board.map(row => [...row].reverse());
                                  }

                                  function transpose(board) {
                                    const newBoard = getEmptyBoard();
                                      for (let r = 0; r < SIZE; r++) {
                                          for (let c = 0; c < SIZE; c++) {
                                                newBoard[c][r] = board[r][c];
                                                    }
                                                      }
                                                        return newBoard;
                                                        }

                                                        function compress(board) {
                                                          let newBoard = board.map(row => {
                                                              let newRow = row.filter(val => val !== 0);
                                                                  while (newRow.length < SIZE) newRow.push(0);
                                                                      return newRow;
                                                                        });
                                                                          return newBoard;
                                                                          }

                                                                          function moveLeft(board) {
                                                                            let newBoard = compress(board);
                                                                              return newBoard;
                                                                              }

                                                                              function moveRight(board) {
                                                                                let reversed = reverse(board);
                                                                                  let compressed = compress(reversed);
                                                                                    let newBoard = reverse(compressed);
                                                                                      return newBoard;
                                                                                      }

                                                                                      function moveUp(board) {
                                                                                        let transposed = transpose(board);
                                                                                          let compressed = moveLeft(transposed);
                                                                                            let newBoard = transpose(compressed);
                                                                                              return newBoard;
                                                                                              }

                                                                                              function moveDown(board) {
                                                                                                let transposed = transpose(board);
                                                                                                  let compressed = moveRight(transposed);
                                                                                                    let newBoard = transpose(compressed);
                                                                                                      return newBoard;
                                                                                                      }

                                                                                                      function App() {
                                                                                                        const [board, setBoard] = useState(() => addRandomTile(addRandomTile(getEmptyBoard())));

                                                                                                          const handleKeyDown = (event) => {
                                                                                                              let updatedBoard;

                                                                                                                  if (event.key === 'ArrowLeft') {
                                                                                                                        updatedBoard = moveLeft(board);
                                                                                                                            } else if (event.key === 'ArrowRight') {
                                                                                                                                  updatedBoard = moveRight(board);
                                                                                                                                      } else if (event.key === 'ArrowUp') {
                                                                                                                                            console.log('ArrowUp pressed');
                                                                                                                                                  updatedBoard = moveUp(board);
                                                                                                                                                      } else if (event.key === 'ArrowDown') {
                                                                                                                                                            console.log('ArrowDown pressed');
                                                                                                                                                                  updatedBoard = moveDown(board);
                                                                                                                                                                      } else {
                                                                                                                                                                            return;
                                                                                                                                                                                }

                                                                                                                                                                                    const finalBoard = addRandomTile([...updatedBoard]);
                                                                                                                                                                                        setBoard(finalBoard);
                                                                                                                                                                                          };

                                                                                                                                                                                            useEffect(() => {
                                                                                                                                                                                                window.addEventListener('keydown', handleKeyDown);
                                                                                                                                                                                                    return () => window.removeEventListener('keydown', handleKeyDown);
                                                                                                                                                                                                      }, [board]);

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

[View on CodeChef](https://www.codechef.com/problems/OJJAR205)