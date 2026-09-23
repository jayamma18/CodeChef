# OJJAR94

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Understanding Lifting State Up in React

Imagine several components need the same piece of information, like siblings needing to know the family dinner plan. Instead of each sibling keeping their own (possibly different) plan, we "lift the state up". This means the parent component holds the official dinner plan ("state") and tells all the siblings, ensuring everyone is working from the same information.

 **The Problem:** 

Let's say we have two separate input fields (`<TextInput>`) on a page. We want whatever you type in  *either*  box to appear in  *both*  boxes instantly.

If each `<TextInput>` component managed its  *own*  text value using its own `useState`, typing in one wouldn't affect the other. They'd be independent and out of sync.

```
// Problematic Approach - State is NOT lifted
function TextInput() {
  const [text, setText] = useState(''); // Each box has its own 'text' state
  return <input value={text} onChange={(e) => setText(e.target.value)} />;
}

function App() {
  return (
    <div>
      <TextInput /> {/ *This box's state is separate* /}
      <TextInput /> {/ *This box's state is separate* /}
    </div>
 );
}
// Result: Typing in one box does nothing to the other.

```

 **The Solution: Lifting State Up** 

- Identify the Shared State: Both <TextInput> components need access to the same text value.
- Find the Common Parent: The closest component that contains both <TextInput> components is the App component.
- Lift the State: Move the useState for the text value from TextInput up into the App component.
- Pass State Down: Pass the text value from App down to each TextInput as a prop (e.g., value={text}).
- Pass Handler Down: Create a function in App (e.g., handleTextChange) that updates the state. Pass this function down to each TextInput as a prop (e.g., onChange={handleTextChange}). The child component will call this function when its input changes.

 **Example Code (Solution):** 

```
import React, { useState } from 'react';

// Child Component: Now "controlled" by the parent
// It receives the value and the function to call when it changes.
function TextInput({ value, onChange }) {
  return <input value={value} onChange={onChange} />;
}

// Parent Component: Now holds the state and the logic to update it
function App() {
  // 1. State is lifted here!
  const [sharedText, setSharedText] = useState('');

  // 2. Handler function lives in the parent
  const handleTextChange = (event) => {
    setSharedText(event.target.value); // Updates the parent's state
  };

  return (
    <div>
      <h2>Type in either box:</h2>
      {/ *3. Pass state value AND handler function down as props* /}
      <TextInput value={sharedText} onChange={handleTextChange} />
      <br />
      <TextInput value={sharedText} onChange={handleTextChange} />
      <p>Current Shared Text: {sharedText}</p>
    </div>
 );
}

export default App;

```

 **How it Works Now:** 

- You type into either <TextInput>.
- The input's onChange event fires.
- The TextInput calls the onChange function it received as a prop (handleTextChange from App).
- handleTextChange in App calls setSharedText, updating the state in the parent.
- App re-renders because its state changed.
- App passes the new sharedText value down to both TextInput components via their value prop.
- Both input fields now display the same, updated text.
#### Task

Write the example solution in our `IDE` and test how it works. Afterward, submit it to verify whether the code is correct.

 **Key Takeaway:** 

When multiple components need to reflect the same changing data, move that data's state up to their closest common ancestor. The ancestor then becomes the "single source of truth" and passes the data (and functions to update it) down to the children via props.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:27:23.774Z  

```cpp
import React, { useState } from 'react';

// Child Component: Now "controlled" by the parent
function TextInput({ value, onChange }) {
  return <input value={value} onChange={onChange} />;
  }

  // Parent Component: Now holds the state and the logic to update it
  function App() {
    // 1. State is lifted here!
      const [sharedText, setSharedText] = useState('');

        // 2. Handler function lives in the parent
          const handleTextChange = (event) => {
              setSharedText(event.target.value);
                };

                  return (
                      <div>
                            <h2>Type in either box:</h2>
                                  <TextInput value={sharedText} onChange={handleTextChange} />
                                        <br />
                                              <TextInput value={sharedText} onChange={handleTextChange} />
                                                  </div>
                                                    );
                                                    }

                                                    export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR94)