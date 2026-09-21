# OJJAR36

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Destructuring Nested Arrays of Objects

You have an array of objects, where each object represents a product with a name and price. Your goal is to create a new array containing only the `price` of each product. You must use the `.map()` method.

### Sample 1:
Input
Output

```
[
  { name: 'Laptop', price: 1200 },
  { name: 'Mouse', price: 25 },
  { name: 'Keyboard', price: 75 }
]
```

```
[ 1200, 25, 75 ]

```

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T09:42:25.513Z  

```js
const products = [
  { name: 'Laptop', price: 1200 },
  { name: 'Mouse', price: 25 },
  { name: 'Keyboard', price: 75 }
];

// complete the code 
const prices=products.map(({price})=>price);

console.log(prices);
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR36)