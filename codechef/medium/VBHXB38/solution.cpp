
  console.log("6. Customer waits");
}
      console.log("4. Coffee ready after 0ms (Timeout)");
    }, 0);
  });
    setTimeout(() => {
    // Schedule a timer to run after 0ms

    console.log("5. Notify customer (Immediate)");
  setImmediate(() => {
  // Schedule a task to run after microtasks but before timers

    console.log("3. Payment confirmed (Promise)");
  });
  Promise.resolve().then(() => {
  // Schedule a microtask to run after nextTick but before timers

  });
    console.log("2. Barista takes the order (nextTick)");
  // Schedule a task to run immediately after the current operation finishes
  process.nextTick(() => {
