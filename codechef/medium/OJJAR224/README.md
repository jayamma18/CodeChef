# OJJAR224

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Tic-tac-toe 2

In this component, you will implement the core logic that determines the winner of a Tic-Tac-Toe game.

The function `calculateWinner(squares)` takes an array of 9 elements (each representing a square) and returns:

- 'X' if player X has won
- 'O' if player O has won
- null if there is no winner yet

This function will be used by the game to display the winner once any winning condition is met.

 **Requirements** 

You need to:

- Define all possible winning line combinations (rows, columns, and diagonals).
- Check each combination to see if it contains the same non-null symbol ('X' or 'O').
- Return the symbol ('X' or 'O') if a winning combination is found.
- If no winner exists after checking all lines, return null.

 **Example** 

 **Helpful Resources** 

- React Tic-Tac-Toe Tutorial (Official) https://reactjs.org/tutorial/tutorial.html#declaring-a-winner
- Array Destructuring in JS https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment
- Looping through Arrays https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/for...of

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T09:48:42.947Z  

```cpp
export function calculateWinner(squares) {
    // All possible winning line combinations (8 total)
      const lines = [
          [0, 1, 2], // Top row
              [3, 4, 5], // Middle row
                  [6, 7, 8], // Bottom row
                      [0, 3, 6], // Left column
                          [1, 4, 7], // Middle column
                              [2, 5, 8], // Right column
                                  [0, 4, 8], // Top-left to bottom-right diagonal
                                      [2, 4, 6], // Top-right to bottom-left diagonal
                                        ];

                                          // Check if squares array exists
                                            if (!squares) return null;

                                              // Loop through all winning lines
                                                for (let i = 0; i < lines.length; i++) {
                                                    const [a, b, c] = lines[i];
                                                        if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
                                                              return squares[a]; // Returns 'X' or 'O'
                                                                  }
                                                                    }

                                                                      return null; // Default return (no winner)
                                                                      }

```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR224)