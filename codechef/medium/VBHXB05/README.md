# VBHXB05

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Greeting message based on the time of day

Let's create a JavaScript program that displays a greeting message based on the current time of day. This is a common task in web development, and Node.js allows us to do it outside the browser.

Here's how we'll do it:

- We'll get the current hour of the day.
- We'll use if/else statements to determine the appropriate greeting. If time is between 12 and 18(6 PM) print Good Afternoon! and starting from 18(6 PM) it should print Good Evening!.
- We'll print the greeting to the console. Node.js will execute the code, and you'll see a greeting message printed in your terminal based on the current time. There is no need to change anything in the code, you can use the "RUN" button to run the file or write node greeting.js yourself in the terminal to see the output.

 **Expected Output** : When time is 2PM IST

```
14
Good Afternoon!

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T10:22:32.102Z  

```cpp
console.log(currentHour);

// complete your code from here
}else if(currentHour < 17) {
    greeting = "Good Morning!";
if (currentHour < 12) {

let greeting;

    greeting= "Good Afternoon!"
}else {
    greeting= "Good Evening!"
}
console.log(greeting);
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB05)