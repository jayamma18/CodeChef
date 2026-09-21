# VBHXB332

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Connecting to MongoDB Atlas & Defining Models

Alright, your basic backend server is up and running – that's a critical first step! Now, let's get it talking to a database, which is where all our blog posts and user information will live.

 **Objective:**  To establish a connection between our Node.js backend and a MongoDB Atlas database, and to define the essential data structures (models) for `User` and `Blog` posts using Mongoose.

 **Context:** 

- We'll be using MongoDB Atlas, a cloud-hosted database service, for our database. You should have your MONGO_URI ready from MongoDB Atlas (it looks like mongodb+srv://youruser:yourpassword@clustername.mongodb.net/yourDatabaseName?retryWrites=true&w=majority&appName=YourApp).
- The mongoose and dotenv are already installed in your backend.

 **Task:** 

Your task is twofold: connect your backend to MongoDB Atlas and create the schema definitions for our application's data.

- Setup.env (inside backend/): MONGO_URI=your-mongo-uri-here PORT=8080 If you face any issues connecting the backend server to MongoDB, you can refer to this YouTube tutorial on MongoDB connection
- Update server.js: Import dotenv, mongoose. Call dotenv.config(). Use mongoose.connect(process.env.MONGO_URI) with.then() /.catch() to log success or error.
- Update models/User.js: Define schema: username: String, required, unique, trim. password: String, required. Export model as User.
- Update models/Blog.js: Define schema: title: String, required, trim. content: String, required. author: ObjectId, ref: User, required. Add { timestamps: true }. Export model as Blog.

 **To Verify Your Work:** 
Simply click the Run button and check your terminal to see if you receive the message:

- "MongoDB Connected successfully!"
- "Server running on port 8080"

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T09:10:13.933Z  

```cpp
MONGO_URI=mongodb+srv://sakajayamma2007_db_user:Jaya@cluster0.pjfd3i8.mongodb.net/?appName=cluster0
PORT=8080
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB332)