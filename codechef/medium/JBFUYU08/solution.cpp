trim: true
},
completed: {
type: Boolean,
default: false
// MongoDB Atlas connection URI
MONGO_URI='mongodb+srv://mmaryjones2412_db_user:M.Mary2412@cluster0.efjh5pi.mongodb.net/?appName=Cluster0'
// Connect to MongoDB Atlas
mongoose.connect(MONGO_URI, {
useNewUrlParser: true,
useUnifiedTopology: true,
})
.then(() => console.log('Connected to MongoDB Atlas'))
.catch(err => console.error('MongoDB Atlas connection error:', err));

// Define Todo model
const TodoSchema = new mongoose.Schema({
description: {
type: String,
required: true,
// server.js
const express = require('express');
const mongoose = require('mongoose');
const app = express();

// Middleware to parse JSON
app.use(express.json());
