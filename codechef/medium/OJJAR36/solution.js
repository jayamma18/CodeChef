const products = [
  { name: 'Laptop', price: 1200 },
  { name: 'Mouse', price: 25 },
  { name: 'Keyboard', price: 75 }
];

// complete the code 
const prices=products.map(({price})=>price);

console.log(prices);