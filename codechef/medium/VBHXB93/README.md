# VBHXB93

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Uppercase Middleware Order

Let's test your understanding of middleware execution order further. We'll build upon the previous example by introducing a new middleware function that modifies the response text. The key is to understand how the order of middleware functions affects the final output.

Here's the scenario:

- We have a basic Express application with a single route (/).
- We'll define two middleware functions: One middleware sets a message on the response object. Another middleware modifies that message by converting it to uppercase.

The challenge is to arrange these middleware functions in different orders and observe the final response in your browser or using a tool like curl.

### Your task is to:
- Write the two middleware functions as described.
- Register the middleware functions in your app in one order, then create a route handler that sends the message.
- Run your server and observe the response.
- Next, swap the order in which you register the middleware functions.
- Run your server again and observe how the response changes.

Test your understanding by comparing the output from both runs and notice how the middleware execution order changes the final response.

### Output:

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-17T10:51:12.465Z  

```cpp
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
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB93)