# VASAPROB11

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Match - Practice Problem

You have the following collection called  **`products`** :

```
[
  { "name": "Laptop",     "category": "Electronics", "price": 800,  "inStock": true },
  { "name": "Phone",      "category": "Electronics", "price": 500,  "inStock": false },
  { "name": "Book",       "category": "Education",   "price": 20,   "inStock": true },
  { "name": "Headphones", "category": "Electronics", "price": 100,  "inStock": true },
  { "name": "Pen",        "category": "Stationery",  "price": 5,    "inStock": true }
]

```

 **Task** 

Write a MongoDB aggregation query using  **`$match`**  to find all  **Electronics products that are in stock and cost more than 100**.

 **Expected Output** 

```
[
  { "name": "Laptop", "category": "Electronics", "price": 800, "inStock": true }
]

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T09:53:49.227Z  

```cpp
          const result = db.products.aggregate([
            {
                $match: {
                      category: "Electronics",
                            inStock: true,
                                  price: { $gt: 100 }
                                      }
                                        }
                                        ]).toArray();

                                        db.filteredProducts.insertMany(result);

                                        printjson(db.filteredProducts.find().toArray());
```

---

[View on CodeChef](https://www.codechef.com/problems/VASAPROB11)