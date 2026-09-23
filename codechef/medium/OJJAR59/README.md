# OJJAR59

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### The Whitespace Gotcha in JSX

In `JSX`, whitespace does not always behave the same way as it does in `HTML`. By default, `JSX` does  **not**  automatically add spaces between elements, which can sometimes lead to unexpected results.

For example, let's say we have the following `JSX` code:

#### Understanding the Issue

When we write `JSX`, we might assume that if we put a variable right next to some text, a space will appear automatically. But `JSX` treats text nodes and variables as  **separate elements**, and it does  **not**  insert spaces between them.

On IDE, you can see an example where the missing space issue occurs.

 **The output will be** 
Incorrect:  **Days left:30** 

As you can see, the number appears  **right next to**  the colon (`:`) without a space. `JSX` is rendering them  **as separate elements**  without inserting any whitespace.

#### Solution: Adding Explicit Whitespace

To fix this issue, we need to  **explicitly add a space**  inside curly braces (`{' '}`), which tells `JSX` that we want an actual space in the output.

 **Corrected Code** 

```
const element = (
  <div>
    <strong>Days left:</strong>
    {' '}
    {eventDays}
  </div>
);

```

Now, the output will be correctly displayed as:
 **Days left: 30** 

#### Why Does This Happen?
- JSX is not HTML—it compiles to JavaScript using React.createElement().
- Spaces between elements are not automatically included unless explicitly added.
- {' '} is used to manually insert whitespace, ensuring the proper format.

Now, try fixing the code in the `IDE` and submit your solution!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T05:20:54.370Z  

```cpp
const eventDays = 30;

export function App() {
  return (
      <div>
            <strong>Days left:</strong>
                  {' '}
                        {eventDays}
                            </div>
                              );
                              }
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR59)