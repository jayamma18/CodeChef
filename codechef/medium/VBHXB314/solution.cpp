import express from "express";

const app = express();

// URL Versioning
app.get("/api/v1/products", (req, res) => {
  res.json({ version: "v1", products: ["Apple", "Banana"] });
});

app.get("/api/v2/products", (req, res) => {
  res.json({ version: "v2", products: ["Laptop", "Phone"] });
});
