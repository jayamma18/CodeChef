  });

  /**
   * POST /store
    * Body: { "key": "someKey", "value": "someValue" }
     * TODO: Store the key-value pair in Redis
      */
      app.post("/store", (req, res) => {
        const { key, value } = req.body;

          redisClient.set(key, value, (err, reply) => {
              if (err) {
                    return res.status(500).send("Error storing value");
                        }
                            res.send(`Stored key: ${key} with value: ${value}`);
                              });
                              });

                              /**
                               * GET /retrieve/:key
                                * TODO: Retrieve value from Redis by key
                                 */
                                 app.get("/retrieve/:key", (req, res) => {
                                   const { key } = req.params;

                                     redisClient.get(key, (err, value) => {
                                         if (err) {
                                               return res.status(500).send("Error retrieving value");
                                                   }
                                                       if (value === null || value === undefined) {
                                                             return res.send("Key not found");
                                                                 }
                                                                     res.send(`Retrieved: ${value}`);
                                                                       });
                                                                       });

                                                                       module.exports = app;