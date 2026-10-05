// Connect to the database
db = connect("mongodb://localhost:27017/test");

// Drop old collections if any
db.articles.drop();
db.paginatedArticles.drop();

// Insert sample dataset (run once)
db.articles.insertMany([
{ title: "Intro to MongoDB", author: "Alice", views: 120 },
{ title: "Mastering Aggregation", author: "Bob", views: 450 },
{ title: "Indexes Explained", author: "Charlie", views: 300 },
{ title: "Schema Design", author: "Daisy", views: 280 },
{ title: "Transactions in MongoDB", author: "Eve", views: 600 },
{ title: "Sharding Deep Dive", author: "Frank", views: 150 }
]);

// Aggregation pipeline
var pagedb = db.articles.aggregate([
{ $skip: 2 },
{ $limit: 3 }
]).toArray();

// Print result
printjson(pagedb);

// Store result in separate collection
db.paginatedArticles.insertMany(pagedb);