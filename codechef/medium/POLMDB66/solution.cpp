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