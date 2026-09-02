# VBHXB15

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Simulate Coffee Brewing Process

Let's create a worked example that simulates making a cup of coffee! We'll break the process down into asynchronous steps using Promises and chain them together. This will demonstrate how Promise chains can manage a sequence of operations.

Here's the scenario:

- Grind Beans: This asynchronous function will simulate grinding coffee beans. It will resolve with the string "Ground coffee beans".
- Brew Coffee: This asynchronous function will take the ground beans as input and simulate brewing the coffee. It will resolve with the string "Brewed coffee".
- Add Milk: This asynchronous function will take the brewed coffee as input and simulate adding milk. It will resolve with the string "Coffee with milk".

We'll use `setTimeout` to simulate the time each step takes. We'll also include a final `console.log` to confirm the entire process is asynchronous.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-02T05:25:30.846Z  

```cpp
function grindBeans() {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve("Ground coffee beans");
      }, 500);
    });
  }
  
  function brewCoffee(groundBeans) {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve("Brewed coffee with " + groundBeans);
      }, 500);
    });
  }
  
  function addMilk(brewedCoffee) {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve("Coffee with milk: " + brewedCoffee);
      }, 500);
    });
  }
  
  grindBeans()
    .then((groundBeans) => {
      console.log("1. Beans ground:", groundBeans);
      return brewCoffee(groundBeans);
    })
    .then((brewedCoffee) => {
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB15)