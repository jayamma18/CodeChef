# VBHXB21

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Simulated API Call with Error Handling

Let's create a simulated API call that randomly succeeds or fails. This example demonstrates error handling using async/await, promises, and callbacks. Imagine we're fetching user data from a server. Sometimes the server responds correctly, and sometimes it has issues. We'll simulate this randomness.

### Working:

 **1.**  First, let's see the `fetchUserData` function.
This function will simulate fetching user data and randomly resolve or reject the promise.
 **2.**  Now, let's use `async/await` with `try...catch` to handle potential errors: This is the async/await version.
 **3.**  Next, let's see the code to implement the same functionality using `.then()` and `.catch()`
 **4.**  Finally, let's see the function that uses callbacks to handle the request.

Run it, and observe the output. Sometimes you'll see "User data: { id: 123, name: 'John Doe' }", and sometimes you'll see "Error fetching user data: Failed to fetch user data.". This demonstrates how to handle asynchronous errors gracefully using different approaches.

Each time you run the script, the simulated API call has a 50% chance of failing, so observe the different outputs you may receive.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-02T06:37:28.760Z  

```cpp
// Simulated API function
async function fetchUserData() {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        const success = Math.random() > 0.5;
        if (success) {
          resolve({ id: 123, name: "John Doe" });
        } else {
          reject("Failed to fetch user data.");
        }
      }, 50);
    });
  }
  
  // Async/Await version
  async function getUserDataAsyncAwait() {
    try {
      const userData = await fetchUserData();
      console.log("Async/Await → User data:", userData);
    } catch (error) {
      console.error("Async/Await → Error fetching user data:", error);
    }
  }
  
  // Promise .then/.catch version
  function getUserDataPromise() {
    fetchUserData()
      .then(userData => {
        console.log("Promise → User data:", userData);
      })
      .catch(error => {
        console.error("Promise → Error fetching user data:", error);
      });
  }
  
  // Callback-based simulation
  function fetchUserDataCallback(callback) {
    setTimeout(() => {
      const success = Math.random() > 0.5;
      if (success) {
        callback(null, { id: 123, name: "John Doe" });
      } else {
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB21)