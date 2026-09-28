# OJJAR217

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Organizing Your Reducer with switch-case

Remember our `myReducer` function from the last lesson? It probably used a few `if` and `else if` statements to check the `action.type` and decide what new state to return.

```
// Previous way (using if/else if)
function myReducer(currentState, action) {
    if (action.type === 'CORRECT_ANSWER') {
        // Calculate and return new state...
        return { / *...* / };
    } else if (action.type === 'WRONG_ANSWER') {
        // Calculate and return new state...
        return { / *...* / };
    } else {
        // If action type is unknown, return current state
        return currentState;
    }
}

```

This works perfectly fine! But as you add more and more possible actions, this chain of `if/else if` can get a bit long and maybe slightly harder to scan quickly.

 **Introducing `switch/case`** 

Many developers prefer using a JavaScript feature called `switch/case` inside reducers. It does the  *exact same thing*  as `if/else if` – checking a value against several possibilities – but often looks a little cleaner when you have many conditions based on the  *same*  variable (in our case, `action.type`).

Here's how you'd rewrite the above using `switch/case`:

```
function myReducer(currentState, action) {
    console.log("Reducer processing action:", action.type);

    switch (action.type) {
        case 'CORRECT_ANSWER': {
            const newScore = currentState.score + 10;

            const newLives = (newScore % 100 === 0)
                ? currentState.lives + 1
                : currentState.lives;

            console.log("New state:", {
               ...currentState,
                score: newScore,
                lives: newLives
            });

            return {
               ...currentState,
                score: newScore,
                lives: newLives
            };
        }

        case 'WRONG_ANSWER': {
            const newLives = currentState.lives - 1;

            const newScore = (newLives <= 0)
                ? 0
                : currentState.score;

            console.log("New state:", {
               ...currentState,
                lives: newLives,
                score: newScore
            });

            return {
               ...currentState,
                lives: newLives,
                score: newScore
            };
        }

        default: {
            console.log("Unknown action type, returning current state.");
            return currentState;
        }
    }
}

```

 **Breaking it Down:** 

- switch (action.type): This tells JavaScript we want to check the value of action.type.
- case 'SOME_ACTION_TYPE':: This checks if action.type exactly matches the string 'SOME_ACTION_TYPE'.
- {... } (The Curly Braces): Notice the { and } around the code for each case. Why? Scoping: These braces create a separate "block" or scope for each case. This is really helpful if you need to declare variables (using let or const) inside a case. Without the braces, variables declared in one case might clash with variables of the same name in another case, causing errors! It's good practice to always include them in reducers. Readability: They visually group the logic for each action type.
- return newState;: Just like before, each case needs to calculate and return the new state object. Crucially, when you return from inside a case, it exits the entire myReducer function – it doesn't continue checking other cases. This is exactly what we want!
- default:: This is optional but recommended. It acts like the final else block. If action.type doesn't match any of the case statements above it, the code inside default will run. In reducers, the standard practice for the default case is simply to return currentState unchanged. This handles any unexpected or unknown actions gracefully.

 **What about `break`?** 

You might see `switch` statements in other JavaScript code that use the keyword `break;` at the end of each `case`, like this:

```
// Example NOT typical for reducers
let message = '';
switch (color) {
    case 'red':
        message = 'Stop!';
        break; // <- See the break?
    case 'yellow':
        message = 'Caution!';
        break; // <- See the break?
    default:
        message = 'Go!';
        // No break needed on the last one
}

```

The `break` keyword tells JavaScript to stop executing the `switch` statement  *after*  the matching case is finished. If you forget `break`, JavaScript will confusingly "fall through" and execute the code in the  *next*  case as well!

 **Why don't we usually need `break` in reducers?**  Because we use `return`! As soon as the reducer hits `return newState;`, the entire function stops, so there's no chance of accidentally falling through to the next case. Using `return` is the standard and cleanest way within `useReducer`.

 **Recap: Why Use `switch`?** 

- Convention: It's the most common pattern you'll see in reducers (both useReducer and Redux). Knowing it helps you read other people's code.
- Readability: For many developers, it makes the different actions and their corresponding logic easier to scan than a long if/else if chain.
- Clear Structure: It emphasizes that you're choosing one path based on the single value of action.type.

Now, let's practice using it!

### Your Turn: Build a Counter with switch/case!

Let's build a very simple counter component. We want buttons to increment, decrement, and reset the count. We'll use `useReducer` and implement the reducer logic using a `switch/case` statement.

 **The Goal:**  Make the counter buttons work by writing the `reducer` function.

 **Your Task:** 

Modify the `reducer` function in the `App.js` file. Use a `switch (action.type)` statement with `case` blocks for `'INCREMENT'`, `'DECREMENT'`, and `'RESET'`. Remember to:

- Use curly braces {} for each case.
- Return a new state object (e.g., { count: state.count + 1 }) in each case. Don't modify the existing state directly!
- Make sure you have a default case that returns the state unchanged.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T08:45:06.533Z  

```cpp
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
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR217)