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

                                                                          // 1. Implement merge(board)
                                                                          function merge(board) {
                                                                            for (let r = 0; r < SIZE; r++) {
                                                                                for (let c = 0; c < SIZE - 1; c++) {
                                                                                      if (board[r][c] !== 0 && board[r][c] === board[r][c + 1]) {
                                                                                              board[r][c] *= 2;
                                                                                                      board[r][c + 1] = 0;
                                                                                                            }
                                                                                                                }
                                                                                                                  }
                                                                                                                    return board;
                                                                                                                    }

                                                                                                                    // 2. Integrate merge into moveLeft(board)
                                                                                                                    // Sequence: compress -> merge -> compress
                                                                                                                    function moveLeft(board) {
                                                                                                                      let newBoard = compress(board);
                                                                                                                        newBoard = merge(newBoard);
                                                                                                                          newBoard = compress(newBoard);
                                                                                                                            return newBoard;
                                                                                                                            }

                                                                                                                            function moveRight(board) {
                                                                                                                              let reversed = reverse(board);
                                                                                                                                let moved = moveLeft(reversed);
                                                                                                                                  let newBoard = reverse(moved);
                                                                                                                                    return newBoard;
                                                                                                                                    }

                                                                                                                                    function moveUp(board) {
                                                                                                                                      let transposed = transpose(board);
                                                                                                                                        let moved = moveLeft(transposed);
                                                                                                                                          let newBoard = transpose(moved);
                                                                                                                                            return newBoard;
                                                                                                                                            }

                                                                                                                                            function moveDown(board) {
                                                                                                                                              let transposed = transpose(board);
                                                                                                                                                let moved = moveRight(transposed);
                                                                                                                                                  let newBoard = transpose(moved);
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
                                                                                                                                                                                          updatedBoard = moveUp(board);
                                                                                                                                                                                              } else if (event.key === 'ArrowDown') {
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