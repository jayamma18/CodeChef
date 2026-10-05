# VASAPROB14

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### sort - Practice Problem

You are given a  **`products`**  collection in MongoDB with the following documents:

```
db.products.insertMany([
  { name: "Headphones", price: 5000, rating: 4.2 },
  { name: "Phone", price: 50000, rating: 4.7 },
  { name: "Smartwatch", price: 15000, rating: 4.6 },
  { name: "Laptop", price: 75000, rating: 4.5 },
  { name: "Tablet", price: 30000, rating: 4.3 }
]);

```

 **Problem Statement** 

Write an  **aggregation pipeline**  to:

- Sort the products by price in descending order (highest price first).
- If two products have the same price, then sort them by rating in descending order.

 **Expected Output** 

```
[
  { name: "Laptop", price: 75000, rating: 4.5 },
  { name: "Phone", price: 50000, rating: 4.7 },
  { name: "Tablet", price: 30000, rating: 4.3 },
  { name: "Smartwatch", price: 15000, rating: 4.6 },
  { name: "Headphones", price: 5000, rating: 4.2 }
]

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T10:01:42.404Z  

```cpp
// Drop collections if they exist
db.products.drop();
db.sortedProducts.drop();

// Insert sample dataset (run once)
db.products.insertMany([
  { name: "Headphones", price: 5000, rating: 4.2 },
    { name: "Phone", price: 50000, rating: 4.7 },
      { name: "Smartwatch", price: 15000, rating: 4.6 },
        { name: "Laptop", price: 75000, rating: 4.5 },
          { name: "Tablet", price: 30000, rating: 4.3 }
          ]);

          // Aggregation pipeline: sort by price desc, then rating desc
          var cursor = db.products.aggregate([
            { $sort: { price: -1, rating: -1 } }
            ]);

            // Convert cursor to array
            var sortedArray = cursor.toArray();

            // Print result
            printjson(sortedArray);

            // Insert only if not empty
            if (sortedArray.length > 0) {
              db.sortedProducts.insertMany(sortedArray);
              } else {
                print("No documents found to insert!");
                }
```

---

[View on CodeChef](https://www.codechef.com/problems/VASAPROB14)