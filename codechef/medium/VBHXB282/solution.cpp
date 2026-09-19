const express = require("express");
const redisMock = require("redis-mock");

const app = express();
const redisClient = redisMock.createClient();

app.use(express.json());

// --- Without cache route ---
app.get("/without-cache", (req, res) => {
  const freshValue = `Fresh at ${Date.now()}`;
  res.send(freshValue);
});

// --- With cache route ---
app.get("/with-cache", (req, res) => {
  redisClient.get("cachedGreeting", (err, cachedValue) => {
    if (cachedValue) {
      return res.send(`From cache: ${cachedValue}`);
    }
    const freshValue = `Fresh at ${Date.now()}`;
    redisClient.set("cachedGreeting", freshValue);
    res.send(freshValue);
  });
});

module.exports = app;  // export app (NOT listen)
