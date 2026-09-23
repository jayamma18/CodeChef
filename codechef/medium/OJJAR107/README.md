# OJJAR107

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Stale Values in React

When working with React, especially with hooks like  **`useState`**  and  **`useEffect`**, you might encounter  **stale values**. This happens when a function or effect uses an outdated value of a state variable instead of the latest one. Let's break this down in simple terms.

 **What Causes Stale Values?** 

- Closures: JavaScript functions "close over" the variables they use, capturing their values at the time the function is created.
- Effects with Dependencies: If an effect depends on a state variable but isn't re-run when that variable changes, it retains the old value.

Let's use a  **light switch**  example to understand stale values. Imagine a room with a physical switch and a clapper (you control it by clapping). Both should toggle the same light, but sometimes they get out of sync!

#### Example: Stale Light Switch 🌟

In our IDE, you can see a code snippet—this is our example code.

 **Component Goal:** 

- A light that can be toggled by a button OR by pressing the "L" key.
- Display the current status: "Light is ON/OFF".

 **Note - first go and click on our web Side, then try turning the light ON or OFF using the keyword.** 

#### What's Happening?
- First Render: isOn = false (light is off). The handleKeyPress function is created with isOn = false.
- Press "L" Key: Toggles isOn to true (light turns on). BUT: The handleKeyPress still uses the old isOn (false) because the effect doesn't re-run.
- Press "L" Again: Toggles isOn to false again (light turns off). The keyboard shortcut seems "broken"—It only works for the first time!
#### Fixes

 **Fix 1: Add `isOn` to Dependencies** 

```
useEffect(() => {
  const handleKeyPress = (e) => {
    if (e.code === 'KeyL') {
      setIsOn(!isOn); // Now uses latest isOn
    }
  };
  
  window.addEventListener('keydown', handleKeyPress);
  return () => window.removeEventListener('keydown', handleKeyPress);
}, [isOn]); // 👈 Re-run effect when isOn changes

```

 **How it Works:** 

- The effect now re-runs every time isOn changes, creating a fresh handleKeyPress with the latest value.

 **Tradeoff:** 

- Slightly less efficient (because it frequently re-creates the event listener).

 **Fix 2: Use Functional Update** 

```
useEffect(() => {
  const handleKeyPress = (e) => {
    if (e.code === 'KeyL') {
      // 👇 Get FRESH isOn value from React
      setIsOn(current => !current);
    }
  };
  
  window.addEventListener('keydown', handleKeyPress);
  return () => window.removeEventListener('keydown', handleKeyPress);
}, []); // 👈 No dependencies needed

```

 **How it Works:** 

- setIsOn(current => !current) always gets the latest value from React, avoiding staleness.

 **Best For:** 

- Effects that shouldn’t re-run often (e.g., event listeners).
#### Your Task
- Reproduce the Bug: Use the "broken" code. Click the button to toggle the light → It works. Press "L" → It works once, then seems broken.
- Apply Fix 1: Add isOn to the dependency array. Test again → Both button and key now work!
- Apply Fix 2: Replace setIsOn(!isOn) with a functional update. Verify it works smoothly.
# Key Takeaway
- Stale values happen when functions "remember" old state.
- Dependencies or functional updates ensure you always use fresh state.
- Choose the fix based on your needs → (Frequency of updates vs Performance).

 **Now, just submit the problem and continue your learning.**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T10:38:42.310Z  

```cpp

function LightSwitch() {
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR107)