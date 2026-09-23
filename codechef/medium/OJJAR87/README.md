# OJJAR87

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### How React Handles Form Controls

React simplifies form handling by using two main concepts for all form controls:

- Value Binding: Use value for most inputs. Use checked for checkboxes/radios.
- Change Handling: Use onChange to capture user input changes and update state.
### 1. The Select Dropdown

 **In HTML:** 

```
<select>
  <option value="apple">Apple</option>
  <option value="banana" selected>Banana</option>
</select>

```

 **In React:** 

```
const [fruit, setFruit] = React.useState('banana');

return (
  <>
     <select 
       value={fruit} 
       onChange={(e) => setFruit(e.target.value)}
     >
       <option value="apple">Apple</option>
       <option value="banana">Banana</option>
     </select>
      
     <p>You have selected: <strong>{fruit}</strong>.</p>
  </>
);

```

 **Key Points:** 

- Control the selected value with value on <select>.
- Update state using onChange.
- No need for selected attribute on <option>.
### 2. Radio Buttons

 **In HTML:** 

```
<input type="radio" name="color" value="blue" checked>
<input type="radio" name="color" value="red">

```

 **In React:** 

```
const [color, setColor] = React.useState('blue');

return (
  <div>
    <input 
      type="radio" 
      name="color" 
      value="blue" 
      checked={color === 'blue'} 
      onChange={(e) => setColor(e.target.value)} 
    />
    <label>Blue</label>

    <input 
      type="radio" 
      name="color" 
      value="red" 
      checked={color === 'red'} 
      onChange={(e) => setColor(e.target.value)} 
    />
    <label>Red</label>
    <p>You have selected the color {color}.</p>
  </div>
);

```

 **Key Points:** 

- Use the same name for the radio group.
- Control each radio with checked={state === value}.
- Update state using onChange.
### 3. Checkboxes

 **For a Single Checkbox:** 

 **In HTML:** 

```
<input type="checkbox" id="newsletter" checked>

```

 **In React:** 

```
const [subscribed, setSubscribed] = useState(false);

return (
    <div>
      <input 
        type="checkbox" 
        checked={subscribed} 
        onChange={(e) => setSubscribed(e.target.checked)}
      />
      <label>Subscribe to newsletter?</label>

      {subscribed && <p>🎉 Thank you for subscribing!</p>}
    </div>
);

```

 **Key Points:** 

- Use checked instead of value.
- e.target.checked gives a boolean (true/false).
- Works for single checkboxes.
#### Try it Yourself!

Now that you've learned how form elements work in React, write each of the above examples  **inside your `App` component**  and run them. Try modifying the code, experiment with different values, and see how React handles updates. Also, try  **writing the code manually**  instead of copying and pasting. In the next step, we will solve a small project for hands-on practice to boost your confidence!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:17:24.913Z  

```cpp
import React, { useState } from "react";

export default function App() {
  const [fruit, setFruit] = useState('banana');

    return (
        <>
              <select
                      value={fruit}
                              onChange={(e) => setFruit(e.target.value)}
                                    >
                                            <option value="apple">Apple</option>
                                                    <option value="banana">Banana</option>
                                                          </select>

                                                                <p>You have selected: <strong>{fruit}</strong>.</p>
                                                                    </>
                                                                      );
                                                                      }
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR87)