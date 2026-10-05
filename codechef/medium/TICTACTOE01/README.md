# TICTACTOE01

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Tic-tac-toe 1
- In this part of the project, you will implement the Square component for a Tic-Tac-Toe game.
- The Square component represents a single cell on the game board. It is a clickable button that shows either 'X', 'O', or remains empty depending on the game state. When clicked, it should notify the game board using the onClick function passed as a prop.

 **Requirements** 

Your goal is to implement the `Square` component by completing the following:

- Display the value passed via the value prop inside a <button>.
- Call the onClick prop function when the button is clicked.
- Add the CSS class "square" to the button for styling purposes.

 **Example Output** 

- If value is "X" and the user clicks the button, the board will update accordingly.
- Should render a button with "X" and call the onClick function on click.

 **Helpful Resources** 

- React Docs – Handling Events https://reactjs.org/docs/handling-events.html
- React Docs – Components and Props https://reactjs.org/docs/components-and-props.html
- Intro to JSX https://reactjs.org/docs/introducing-jsx.html

 **After implementing this component, run the app and verify that clicking the squares on the board updates them with `'X'` and `'O'`.** 

You'll implement the winner logic in the next part of the project!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T10:07:46.916Z  

```cpp
import React from 'react';

function Square({ value, onClick }) {
return (
<button className="square" onClick={onClick}>
{value}
</button>
);
}

export default Square;
```

---

[View on CodeChef](https://www.codechef.com/problems/TICTACTOE01)