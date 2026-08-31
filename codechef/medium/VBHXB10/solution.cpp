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