const express = require("express");
const jwt = require("jsonwebtoken");
const path = require("path");

const app = express();
const SECRET = "mySuperSecretKey123";

app.use(express.json());

app.get("/", (req, res) => {
res.sendFile(path.join(__dirname, "index.html"));
});

app.post("/generate-token", (req, res) => {
const { username } = req.body;
const token = jwt.sign({ sub: username }, SECRET, { expiresIn: "5m" });
res.json({ token });
});

module.exports = { app, SECRET };