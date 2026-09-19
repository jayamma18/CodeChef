# POLMDB02B

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Developer Directory
- You are building a directory for a coding community. In a SQL database, you would have to create one table for "Users," another for "Projects," and another for "Social Links."
- In MongoDB, your task is to create a single document that holds all of this information together.

 **Your Goal:** 
Create a collection named developers.

- Insert a single document representing yourself or a fictional developer.
- The document must include: A simple field (String/Number). An Array (a list of your top 3 programming languages). A Nested Object (an object containing your GitHub and LinkedIn URLs).

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:30:28.072Z  

```cpp

if (myProfile && Array.isArray(myProfile.tech_stack) && typeof myProfile.socials === 'object') {
    print("\nSuccess! You've mastered the 'Everything is Together' concept of Documents.");
} else {
    print("\nCheck your document structure. Make sure you have an array and a nested object!");
}
```

---

[View on CodeChef](https://www.codechef.com/problems/POLMDB02B)