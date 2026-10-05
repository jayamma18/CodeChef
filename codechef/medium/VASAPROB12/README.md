# VASAPROB12

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - HR Speed Optimization
- You are the lead developer for "TechCorp." The HR department complains that searching for employees by their Employee ID (empId) has become extremely slow as the company reached 5,000 employees.
- Your Goal: Identify the performance bottleneck using.explain() and fix it by creating a Single Field Index.

 **Step 1: Write the Index Command** 
You need to tell MongoDB to create a sorted list for that field. Use the `createIndex()` method on your collection.

- Inside the parentheses, you need an object: { fieldName: 1 }.
- The 1 tells MongoDB to sort the list in Ascending order.

 **Step 2: Run and Check** 
After you run your command, look at the output of the script.

- The Goal: You want the "Documents scanned after index" to be 1.
- If it is still 5,000, your index wasn't created correctly. If it is 1, your database is now optimized!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T09:56:36.470Z  

```cpp
db = connect('mongodb://localhost:27017/hr_db');

db.staff.drop();

const employees = [];
for (let i = 1; i <= 5000; i++) {
  employees.push({
      name: "Employee " + i,
          empId: 1000 + i,
              department: "Engineering"
                });
                }
                db.staff.insertMany(employees);

                const slowSearch = db.staff.find({ empId: 4500 }).explain("executionStats");
                print("Documents scanned before index: " + slowSearch.executionStats.totalDocsExamined);

                // YOUR TASK ---
                // Write the command to create a Single Field Index on 'empId' in Ascending order.

                // WRITE YOUR CODE HERE:
                db.staff.createIndex({ empId: 1 });

                const fastSearch = db.staff.find({ empId: 4500 }).explain("executionStats");
                print("Documents scanned after index: " + fastSearch.executionStats.totalDocsExamined);
```

---

[View on CodeChef](https://www.codechef.com/problems/VASAPROB12)