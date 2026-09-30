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
                                                        // 1. Reverse each row of the board
                                                          let reversedBoard = board.map(row => [...row].reverse());
                                                            
                                                              // 2. Compress to slide tiles to the "left" of the reversed board
                                                                let compressedBoard = compress(reversedBoard);
                                                                  
                                                                    // 3. Reverse each row back to restore original orientation
                                                                      let newBoard = compressedBoard.map(row => [...row].reverse());
                                                                        
                                                                          return newBoard;
                                                                          }

                                                                          function App() {
                                                                            const [board, setBoard] = useState(() => addRandomTile(addRandomTile(getEmptyBoard())));

                                                                              const handleKeyDown = (event) => {
                                                                                  let updatedBoard;

                                                                                      if (event.key === 'ArrowLeft') {
                                                                                            updatedBoard = moveLeft(board);
                                                                                                } else if (event.key === 'ArrowRight') {
                                                                                                      console.log('ArrowRight pressed');
                                                                                                            updatedBoard = moveRight(board);
                                                                                                                } else if (event.key === 'ArrowUp') {
                                                                                                                      console.log('ArrowUp pressed');
                                                                                                                            return;
                                                                                                                                } else if (event.key === 'ArrowDown') {
                                                                                                                                      console.log('ArrowDown pressed');
                                                                                                                                            return;
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