# POLMDB66

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Blog Posts and Comments Modeling

Imagine you are building a simple blogging application using Node.js and MongoDB with Mongoose. In this application, users can create blog posts, and other users can write comments on these posts. A single blog post can have many comments (from zero to potentially hundreds or thousands).

### Your Task:

 **Define Mongoose Schemas** :

- Create a Post schema that includes basic fields like title, content, author,'createdAt' and a way to associate it with comments.
- Create a Comment schema that includes basic fields like text, author,'createdAt' and a way to associate it with the post it belongs to.
- Be sure to reflect your chosen approach (embedding or referencing) accurately when modeling the relationship.
#### Expected Output:

 **Post** 

 **Comments** 

You can check that the post's id is refrenced in comment's schema.

🧠  *Hint:*  Think about how you might handle thousands of comments, how you'd query individual comments, and what kind of schema relationships Mongoose supports.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T06:58:46.511Z  

```cpp
.catch(err => console.error("❌ MongoDB connection error:", err));

// Comment Schema
const commentSchema = new mongoose.Schema({
  text: {
    type: String,
    required: true

const uri="mongodb+srv://sakajayamma2007_db_user:Jaya@cluster0.pjfd3i8.mongodb.net/?appName=Cluster0"
// Connect to MongoDB Atlas
mongoose.connect(uri, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
})
.then(() => console.log("✅ Connected to MongoDB Atlas"))
const mongoose = require('mongoose');

// MongoDB Atlas Connection String
```

---

[View on CodeChef](https://www.codechef.com/problems/POLMDB66)