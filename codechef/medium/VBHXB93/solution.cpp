                  });
                app.listen(port, () => {
                  console.log(`Server running on port ${port}`);
              };

              // Register middlewares in order
              app.use(setMessage);
              app.use(convertToUppercase);

              // Route handler for '/'
              app.get('/', (req, res) => {
                res.send(res.message);
                });

                // Start the server on port 3000
                const port = 3000;
              next();