# OJJAR210

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### React Counter App

We're working on a  **React counter app**  that should display a small animated "fling" message (like `+5`) every time the user clicks the increment button.

 **Application should be working like this** 

However, the current implementation isn’t working as expected. You’re already familiar with the concept — now it’s time to fix the behavior.

#### What You Need to Do
- Ensure the fling message shows every time the user clicks an increment button — even if the same button is clicked quickly multiple times! Solution Hint: Use the key property to help React re-render the element.
- Ensure the fling message doesn't show on initial render, but only when the count is incremented.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T08:40:38.164Z  

```cpp
                  setCount((prev) => prev + amount);

                      // 2. Set the fling message & unique key to re-trigger animation
                          setFlingMessage(`+${amount}`);
                              setFlingKey(Date.now());

                                  // 3. Clear existing timeout
                                      if (flingTimeoutRef.current) {
                                            clearTimeout(flingTimeoutRef.current);
                                                }

                                                    // 4. Set new timeout to reset the message
                                                        flingTimeoutRef.current = setTimeout(() => {
                                                              setFlingMessage('');
                                                                    flingTimeoutRef.current = null;
                                                                        }, 1200);
                                                                          };

                                                                            return (
                                                                                <div className={styles.container}>
                                                                                      <h1>Animated Counter</h1>

                                                                                            {/* Counter Display Area */}
                                                                                                  <div className={styles.counterDisplayWrapper}>
                                                                                                          <div className={styles.counterDisplay}>
                                                                                                                    {/* Animated count value */}
                                                                                                                              <span key={count} className={styles.animatedValue}>
                                                                                                                                          {count}
                                                                                                                                                    </span>
                                                                                                                                                            </div>

                                                                                                                                                                    {/* Fling Message */}
                                                                                                                                                                            <div key={flingKey} className={styles.flingMessage}>
                                                                                                                                                                                      {flingMessage}
                                                                                                                                                                                              </div>
                                                                                                                                                                                                    </div>

                                                                                                                                                                                                          {/* Control Buttons */}
                                                                                                                                                                                                                <div className={styles.controls}>
                                                                                                                                                                                                                        <button onClick={() => handleIncrement(1)}>+1</button>
                                                                                                                                                                                                                                <button onClick={() => handleIncrement(5)}>+5</button>
                                                                                                                                                                                                                                        <button onClick={() => handleIncrement(10)}>+10</button>
                                                                                                                                                                                                                                              </div>
                                                                                                                                                                                                                                                  </div>
                                                                                                                                                                                                                                                    );
                                                                                                                                                                                                                                                    }
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR210)