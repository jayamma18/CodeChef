# VBHXB10

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Asynchronous Data Processing: Squaring Numbers

Let's create a worked example to solidify your understanding of callbacks. Imagine you have an array of numbers, and you want to square each number, but you want to do it asynchronously using callbacks to simulate a time-consuming operation.

 **What the code is doing:** 

This code takes an array of numbers and asynchronously squares each element using `setTimeout` to simulate delay. For every squared number, it invokes a callback to process it (e.g., log it), and once all numbers are processed, it calls a final callback with the complete list of squared numbers.

 **Explanation of the code:** 

- squareNumbersAsync(numbers, callback, finalCallback): This is the main function that takes the array of numbers, an individual callback to be executed after squaring each number, and a finalCallback to be executed when all numbers are squared.
- The for loop iterates through the numbers array.
- setTimeout(...): Simulates an asynchronous operation. Inside the setTimeout: callback(number, squared): Calls the callback function with the original number and its squared result.
- Math.random() * 1500: This introduces a random delay (up to 1500 milliseconds) to simulate varying processing times for each number, emphasizing the asynchronous nature of the operation.
#### Note:

Try to remove the `Math.random()` function to see that all the values are printed in sequence

 **The example usage**  demonstrates how to call squareNumbersAsync with an array of numbers and two callback functions: one to log each squared number individually and another to log the entire array of squared numbers once all numbers are processed.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T10:44:18.064Z  

```cpp
function squareNumbersAsync(numbers, callback, finalCallback) {
  const squaredNumbers = [];
  let completedCount = 0;

  if (numbers.length === 0) {
    finalCallback(squaredNumbers);
    return;
  }

  for (let i = 0; i < numbers.length; i++) {
    const number = numbers[i];
    setTimeout(function () {
      const squared = number * number;
      squaredNumbers.push(squared);
      callback(number, squared); // Pass both original and squared number
      completedCount++;

      if (completedCount === numbers.length) {
        finalCallback(squaredNumbers);
      }
    }, Math.random() * 1500);
  }
}

// Example Usage:
const numbers = [1, 2, 3, 4, 5];

squareNumbersAsync(
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB10)