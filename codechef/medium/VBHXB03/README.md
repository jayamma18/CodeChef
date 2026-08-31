# VBHXB03

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Benefits of Nodejs
- Runs JavaScript outside the browser You can now use JavaScript for backend development, scripting, automation, and more.
- Single Language for Full-Stack Development Node.js enables developers to write both client-side and server-side code using JavaScript.
- Fast Execution with V8 The V8 engine compiles JavaScript to native machine code for blazing-fast execution.
- Efficient Handling of Concurrent Operations Thanks to its event-driven, non-blocking architecture, Node.js can handle thousands of simultaneous connections with minimal resources.
- Vast Ecosystem with npm Node.js comes bundled with npm (Node Package Manager), which offers access to a massive library of third-party packages for extending functionality.
### Running JavaScript with Node.js

To run a JavaScript file using Node.js:

- Create a file called my_script.js.
- Write your code (e.g., console.log("Hello from Node.js!");).
- Open your terminal, navigate to the file’s directory.
- Run the file using: node my_script.js
- You’ll see the output in your terminal.

This simple example demonstrates how Node.js lets you execute JavaScript code directly on your machine—just like any other programming language.

Now, let's create a JavaScript program that converts a temperature from Celsius to Fahrenheit. This is a simple calculation that demonstrates running JavaScript outside the browser using Node.js.

Here's how we'll do it:

- We'll define a Celsius temperature.
- We'll use the formula to convert Celsius to Fahrenheit: F = (C * 9/5) + 32.
- We'll print the Fahrenheit temperature to the console.

The output should show `25°C is equal to 77°F` as show in below image:

```
Node.js will execute the code, and you'll see the Fahrenheit equivalent of the Celsius temperature printed in your terminal.

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T10:17:39.742Z  

```cpp
// Define the Celsius temperature
let celsius=25;
// Convert Celsius to Fahrenheit using the formula: F = (C * 9/5) + 32
let fahrenheit=(celsius*9/5)+32


// Print the result
console.log(`${celsius}°C is equal to ${fahrenheit}°F`);
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB03)