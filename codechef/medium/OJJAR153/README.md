# OJJAR153

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task Statement

 **Problem:** 
We have a parent component (**`ParentComponent`**) that updates a counter. However, every time the counter changes, it causes the child component (**`ExpensiveOperationChild`**) to re-render unnecessarily, even though the child's props never change. This child component simulates a heavy computation (like processing a large list) with a loop, making unnecessary re-renders costly.

 **Your task**  is to optimize this using  **`React.memo`**  so that the child component only re-renders when its props actually change.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T10:40:28.330Z  

```cpp
import React, { useState, memo } from 'react';
import './App.css';

// Child Component (Optimized with memo)
const ExpensiveOperationChild = memo(function ExpensiveOperationChild({ data }) {
  // Heavy computation simulation
    let sum = 0;
      for (let i = 0; i < 1000000; i++) {
          sum += i;
            }

              console.log('Child rendered!');

                return (
                    <div className="child-container">
                          Heavy Calculation Result: {sum} (Data: {data})
                              </div>
                                );
                                });

                                // Parent Component
                                function ParentComponent() {
                                  const [count, setCount] = useState(0);

                                    return (
                                        <div className="parent-container">
                                              <button
                                                      className="counter-button"
                                                              onClick={() => setCount((c) => c + 1)}
                                                                    >
                                                                            Click to Increment: {count}
                                                                                  </button>
                                                                                        <ExpensiveOperationChild data="hello" />
                                                                                            </div>
                                                                                              );
                                                                                              }

                                                                                              export default ParentComponent;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR153)