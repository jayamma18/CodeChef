# VBHXB333

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Building the User Registration API

Alright, your backend server is connected to the database, and the data models are defined. This sets the perfect stage for our first interaction with that database: creating a new user!

 **Objective:**  To implement the backend API endpoint that allows new users to register an account. This involves receiving user credentials, securely storing the password, and saving the new user to our MongoDB database.

 **Note - First add your MONGO_URI in your.env file** 

 **Context:** 

- You already have installed express, mongoose, dotenv, bcryptjs (for password hashing), and jsonwebtoken (for generating authentication tokens) in your backend directory.
- Remember to add a JWT_SECRET to your backend/.env file if you haven't already. MONGO_URI=paste-your-mongo-uri-here # <-- replace with your actual URI PORT=8080 JWT_SECRET=your_super_secret_jwt_key # <--- Make sure this is a strong, random string!

 **Task:** 
Your task is to create the API route for user registration and integrate it into your server.

- Update the User Model (backend/models/User.js): Import bcryptjs. Add a Mongoose pre-save hook to the userSchema. This hook should: Check if the password has been modified (so it doesn't re-hash an already hashed password). If modified, hash the user.password using bcryptjs before saving the user to the database. Use a salt round of 10. (Note: You will add a method to compare passwords in a later step when implementing login.)
- Create Authentication Routes File (backend/routes/auth.js): Create a new directory backend/routes/. Inside backend/routes/, create a file named auth.js. Import express, User model, and jsonwebtoken. Create an Express Router. Define a POST route for /register. This route should: Extract username and password from req.body. Perform basic validation: ensure both username and password are provided. If not, send a 400 status with an appropriate message. Check if a user with the provided username already exists in the database. If so, send a 400 status. If the user does not exist, create a new User instance, which will automatically hash the password via the pre-save hook. Save the new user to the database. Upon successful registration, generate a JSON Web Token (JWT) using jsonwebtoken.sign(). The payload should include the user's _id. Use process.env.JWT_SECRET as your secret key and set an expiration (e.g., expiresIn: '1h'). Send a 201 (Created) status response with a success message, the generated token, and the new user's id and username. Include a try...catch block to handle potential server errors during database operations or JWT generation.
- Update Main Server File (backend/server.js): Import cors and use app.use(cors()) as middleware. This is essential for allowing your frontend (running on a different port/domain) to make requests to your backend. Use app.use(express.json()) middleware. This tells Express to parse incoming request bodies with JSON payloads, which is how your frontend will send username/password. Import the new authentication routes from backend/routes/auth.js. Mount the authentication routes under the /api/auth path using app.use('/api/auth', authRoutes).

 **Note – Before submitting your code, make sure your backend server is running on port `8080`.** 
To test your code, simply click on the submit button.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T10:13:18.077Z  

```cpp
MONGO_URI=mongodb+srv://sakajayamma2007_db_user:Jaya@cluster0.pjfd3i8.mongodb.net/?appName=cluster0
PORT=8080
JWT_SECRET=your_super_secret_jwt_key


```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB333)