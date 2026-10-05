db = connect("mongodb://localhost:27017/tech_db");

// --- TASK 1: Insert the products listed above ---
db.inventory.drop();
db.inventory.insertMany([
  { name: "Pro-Book", category: "Laptop", price: 55000 },
    { name: "Budget-Tab", category: "Tablet", price: 15000 },
      { name: "Air-Tab", category: "Tablet", price: 45000 },
        { name: "Smart-Watch", category: "Wearable", price: 20000 }
        ]);

        // --- TASK 2: Find "High-End Essentials" ---
        // Filter for Category (Laptop or Tablet) AND Price (> 40000)
        const highEndEssentials = db.inventory.find({
          category: { $in: ["Laptop", "Tablet"] },
            price: { $gt: 40000 }
            }).toArray();

            print("-- Marketing Team: High-End Essentials --");
            if (highEndEssentials && highEndEssentials.length > 0) {
              printjson(highEndEssentials);
              } else {
                print("No products matched the criteria.");
                }