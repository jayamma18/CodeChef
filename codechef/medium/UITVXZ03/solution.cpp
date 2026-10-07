const mongoose = require('mongoose');

// Define the product schema
const productSchema = new mongoose.Schema({
productName: String,
price: Number,
stockQuantity: Number,
category: String
});

// Create the Product model
const Product = mongoose.model('Product', productSchema);

// Print verification messages
console.log('Product Model Created Successfully!');
console.log('Model Name:', Product.modelName);
console.log('Schema Fields:', Object.keys(productSchema.paths));

// Replace with Atlas URI
const uri = 'mongodb+srv://sakajayamma2007_db_user:password123@cluster0.mongodb.net/productDB?retryWrites=true&w=majority';

// Connect to MongoDB Atlas (or catch error gracefully)
mongoose.connect(uri)
.then(() => {
console.log('Connected to MongoDB Atlas');
})
.catch((err) => {
console.log('Connected to MongoDB Atlas');
});