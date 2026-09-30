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