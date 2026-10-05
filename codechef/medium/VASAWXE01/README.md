# VASAWXE01

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### MongoDB - Databases, Collections and Records

In MongoDB, a database stores related collections, and a collection stores documents. Managing databases and collections is one of the fundamental tasks when working with MongoDB.

In this exercise, you will practice creating and dropping collections, as well as dropping a database.

 **Your Task :** 
Complete the following tasks:

- Create a collection named students.
- Create a collection named courses.
- Drop the courses collection.
- Drop the college_db database by uncommenting the provided line after verifying the collections.

Note: Keep the `db.dropDatabase()` line commented while verifying your collections. Uncomment it only after you have confirmed that the collections were created and dropped correctly.

 **Expected Output :** 

Before uncommenting `db.dropDatabase()`:

```
Current Collections:
[
  "students"
]

Database operations completed successfully.

```

 **How to Test** 

 **Step 1: Run the script** 

 **Step 2: Verify the collections** 

- Open the MongoDB shell - in terminal write:

```
mongosh

```

- Switch to the database:

```
use college_db

```

- List the collections:

```
show collections

```

You should see:

```
students

```

 **The courses collection should not be present because it was dropped.** 

 **Step 3: Verify database deletion** 

- Uncomment:

```
db.dropDatabase();

```

- Run the script again
- Open the MongoDB shell and list all databases:

```
show dbs

```

 **The `college_db` database should no longer appear in the list**.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T09:51:29.633Z  

```cpp

// TASK 1: Create the 'students' collection
db.createCollection('students');

// TASK 2: Create the 'courses' collection
db.createCollection('courses');

// TASK 3: Drop the 'courses' collection
db.courses.drop();

// TASK 4: Drop the current database.
db.dropDatabase();

// -----------------------------
print("Current Collections:");
printjson(db.getCollectionNames());
print("\nDatabase operations completed successfully.");
```

---

[View on CodeChef](https://www.codechef.com/problems/VASAWXE01)