// Drop collections if they exist
db.products.drop();
db.sortedProducts.drop();

// Insert sample dataset (run once)
db.products.insertMany([
  { name: "Headphones", price: 5000, rating: 4.2 },
    { name: "Phone", price: 50000, rating: 4.7 },
      { name: "Smartwatch", price: 15000, rating: 4.6 },
        { name: "Laptop", price: 75000, rating: 4.5 },
          { name: "Tablet", price: 30000, rating: 4.3 }
          ]);

          // Aggregation pipeline: sort by price desc, then rating desc
          var cursor = db.products.aggregate([
            { $sort: { price: -1, rating: -1 } }
            ]);

            // Convert cursor to array
            var sortedArray = cursor.toArray();

            // Print result
            printjson(sortedArray);

            // Insert only if not empty
            if (sortedArray.length > 0) {
              db.sortedProducts.insertMany(sortedArray);
              } else {
                print("No documents found to insert!");
                }