# VBHXB34

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Functions in Timer

The Timers module in Node.js contains various functions that allow us to execute a block of code or a function after a set period of time. The timers module has the following functions:

 **a] Scheduling Timers:**  These are used to run functions after a certain amount of time, or repeatedly.

1]  **setTimeout**  : Runs the function once after the given time (in milliseconds).

```
setTimeout(() => {
 console.log("Runs after 2 seconds");
}, 2000);

```

2]  **setInterval**  : Runs the function repeatedly at regular intervals.

```
setInterval(() => {
 console.log("Runs every second");
}, 1000);

```

3]  **setImmediate**  : Runs the function immediately after the current code finishes, before handling I/O events.

```
setImmediate(() => {
 console.log("Runs after current code block");
});

```

 **b] Canceling Timers:**  These are used to cancel the scheduled timer.

1]  **clearTimeout()** : Cancels setTimeout
2]  **clearInterval()** : Cancels setInterval
3]  **clearImmediate()** : Cancels setImmediate

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-07T09:39:29.889Z  

```cpp
function runImmediate() {
  setImmediate(() => {
    console.log("setImmediate executed");
  });
}

function runTimeout() {
  setTimeout(() => {
    console.log("setTimeout executed");
  }, 1000);
}

function runLimitedInterval() {
  let count = 0;
  const intervalId = setInterval(() => {
    count++;
    console.log(`setInterval run ${count}`);
    if (count === 2) {
      clearInterval(intervalId);
    }
  }, 500);
}

module.exports = {
  runImmediate,
  runTimeout,
  runLimitedInterval,
};

if (require.main === module) {
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB34)