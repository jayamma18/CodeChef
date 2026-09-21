# OJJAR47

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Total Price Calculation

In this example, create a simple shopping cart that contains the prices of various items. Your task is to calculate the total price of all items using the `reduce()` method.

Given an array representing the prices of items in our cart:

```
const cartPrices = [29.99, 9.99, 4.99, 14.99, 25.00];

// We will use reduce to calculate the total price of items

```

Use the `reduce()` method to sum up all the prices in the `cartPrices` array. The initial value for the accumulator will be `0`, and we will add each price to this accumulator. And print the value.

Once You write the code, run it to see the total price of our items in the cart. Remember to click the submit button to observe the output!

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T10:29:47.846Z  

```js
const cartPrices = [29.99, 9.99, 4.99, 14.99, 25.00];

// complete the code 
// Using reduce to calculate the total price
const totalPrice =cartPrices.reduce((accumulator,price)=>accumulator+price,0);
console.log(totalPrice);
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR47)