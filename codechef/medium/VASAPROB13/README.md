# VASAPROB13

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Tech Store Filter

You are developing the backend for a tech store. The marketing team wants a list of  **"High-End Essentials"**  to feature on the homepage. They define these as products that:

- Belong to either the "Laptop" or "Tablet" categories.
- Have a price greater than 40,000.

 **Task** 
Write a script in `index.js` to perform the following:

 **1. Populate the Data** 
Use `insertMany` to add the following products to the `inventory` collection in the `tech_db` database:

- { name: "Pro-Book", category: "Laptop", price: 55000 }
- { name: "Budget-Tab", category: "Tablet", price: 15000 }
- { name: "Air-Tab", category: "Tablet", price: 45000 }
- { name: "Smart-Watch", category: "Wearable", price: 20000 }

 **2. Filter the Results** 
Write a `find()` query using `$in` and `$gt` to retrieve only the products that match the marketing team's  **"High-End Essentials"**  criteria.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T09:59:54.936Z  

```cpp
db = connect("mongodb://localhost:27017/tech_db");

// --- TASK 1: Insert the products listed above ---
db.inventory.drop();
db.inventory.insertMany([
  { name: "Pro-Book", category: "Laptop", price: 55000 },
    { name: "Budget-Tab", category: "Tablet", price: 15000 },
      { name: "Air-Tab", category: "Tablet", price: 45000 },
        { name: "Smart-Watch", category: "Wearable", price: 20000 }
        ]);

        // --- TASK 2: Find "High-End Essentials" ---
        // Filter for Category (Laptop or Tablet) AND Price (> 40000)
        const highEndEssentials = db.inventory.find({
          category: { $in: ["Laptop", "Tablet"] },
            price: { $gt: 40000 }
            }).toArray();

            print("-- Marketing Team: High-End Essentials --");
            if (highEndEssentials && highEndEssentials.length > 0) {
              printjson(highEndEssentials);
              } else {
                print("No products matched the criteria.");
                }
```

---

[View on CodeChef](https://www.codechef.com/problems/VASAPROB13)