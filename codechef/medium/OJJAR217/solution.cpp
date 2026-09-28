import { useReducer } from 'react';
import './styles.css'; // We'll provide this CSS

// 1. Define the initial state
const initialState = { count: 0 };

// 2. Write the Reducer function <-- YOU WILL FILL THIS IN!
function reducer(state, action) {
  console.log(`Reducer received action: ${action.type}`);

    switch (action.type) {
        case 'INCREMENT':
              return { count: state.count + 1 };

                  case 'DECREMENT':
                        return { count: state.count - 1 };

                            case 'RESET':
                                  return { count: 0 };

                                      default:
                                            console.log('Unknown action type');
                                                  return state;
                                                    }
                                                    }

                                                    // 3. The Counter Component
                                                    function Counter() {
                                                      // Setup useReducer
                                                        const [state, dispatch] = useReducer(reducer, initialState);

                                                          return (
                                                              <div className="counter">
                                                                    <h2>Counter</h2>
                                                                          <p className="count-display">Count: {state.count}</p>
                                                                                <div className="button-group">
                                                                                        <button onClick={() => dispatch({ type: 'DECREMENT' })}>-</button>
                                                                                                <button onClick={() => dispatch({ type: 'RESET' })}>Reset</button>
                                                                                                        <button onClick={() => dispatch({ type: 'INCREMENT' })}>+</button>
                                                                                                              </div>
                                                                                                                  </div>
                                                                                                                    );
                                                                                                                    }

                                                                                                                    export default function App() {
                                                                                                                      return <Counter />;
                                                                                                                      }