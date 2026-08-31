// ✅ Step 1: Connect to MongoDB Atlas (Update URI with your credentials)
const uri="mongodb+srv://sakajayamma2007_db_user:Jaya@cluster0.pjfd3i8.mongodb.net/?appName=Cluster0"

const mongoose = require('mongoose');

mongoose.connect(uri, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
})
.then(() => console.log('✅ Connected to MongoDB Atlas'))
.catch(err => console.error('❌ MongoDB connection error:', err));

// ✅ Step 2: Define the Author Schema
const authorSchema = new mongoose.Schema({
  name: String,
  bio: String,
});
const Author = mongoose.model('Author', authorSchema);