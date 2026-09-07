# VBHXB37

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### How the Event Loop Works

Node.js follows these steps to handle operations:

1] Execute Main Script – Runs your JavaScript code line by line (synchronously).
2] Microtasks – Executes process.nextTick() and Promises immediately after main code.
3] Timers – Runs setTimeout() and setInterval() callbacks when their time is up.
4] I/O Callbacks – Handles results of file, network, or system operations.
5] setImmediate – Executes callbacks scheduled with setImmediate().
6] Close Events – Handles cleanup tasks like closing sockets or streams.

 **Let's understand this by the given Example** 

Expected Output:

```
Start
End
Next Tick
Promise
Timeout
Immediate

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-07T10:26:38.177Z  

```cpp
function runOrderExample() {
  console.log("Start");

  process.nextTick(() => {
    console.log("Next Tick");
  });

  Promise.resolve().then(() => {
    console.log("Promise");
  });

  setImmediate(() => {
    console.log("Immediate");
  });

  setTimeout(() => {
    console.log("Timeout");
  }, 0);

  console.log("End");
}

```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB37)