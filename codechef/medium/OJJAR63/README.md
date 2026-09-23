# OJJAR63

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Props in React

Until now, we have created simple  **React components**  that display static content. But what if we want to make our components  **dynamic and reusable** ?

That’s where  **props**  come in! 🚀

### What Are Props in React?

 **Props (short for "properties")**  allow us to  **pass data**  from one component to another. Think of  **props like function arguments** —they help us customize what a component displays.

 **With props:** 

- The same component can show different content.
- We can make our components more flexible and reusable. Instead of hardcoding values, we can dynamically pass data to components.
#### Example: Passing Props to a Component

Let’s create a  **Greeting Component**  that  **accepts a name as a prop**  and displays a custom message.

#### Step 1: Define the Component

```
function Greeting(props) {
  return <h2>Hello, {props.name}! Welcome to React! 🎉</h2>;
}

```

- We use props.name inside JSX to display the dynamic name.
- props is an object that holds the values passed to the component.
#### Step 2: Use the Component with Props

Now, let’s use the `Greeting` component  **inside `App.jsx`**  and pass different names!

```
function App() {
  return (
    <div>
      <Greeting name="John" /> {/ *Passing "John" as a prop* /}
      <Greeting name="Emma" /> {/ *Passing "Emma" as a prop* /}
    </div>
 );
}

export default App;

```

#### Output Screen:

```
Hello, John! Welcome to React! 🎉  
Hello, Emma! Welcome to React! 🎉

```

As you can see, the  **same component**  (`Greeting`)  **shows different messages**  based on the data (props) we pass to it!

In the example above, we passed strings as props. But what if we want to pass numbers or other data types?

#### Use {} for Non-String Props

When passing numbers, variables, or JavaScript expressions, wrap them in curly braces `{}`. This tells React:  *“Hey, this is JavaScript, not a string!”* 

Let’s  **`add`**  an age prop to our  **`Greeting`**  component:

```
function Greeting(props) {
  return (
    <h2>
      Hello, {props.name}! You are {props.age} years old. Welcome to React! 🎉
    </h2>
 );
}

```

Now pass the  **`age`**  prop as a number using  **`{}`** :

```
function App() {
  return (
    <div>
      <Greeting name="John" age={25} /> {/ *✅ Correct: age is a number* /}
      <Greeting name="Emma" age={28} />
    </div>
 );
}

```

 **Why Not Use Quotes?** 
If you write  **`age="25"`**  (with quotes), React treats it as a  **string**. Curly braces ensure it’s parsed as a  **number**  or JavaScript expression.

Key Takeaway:

- Use " " for strings.
- Use { } for numbers, variables, or dynamic values.
### Your Task

 **Task: Create a `UserProfile` Component Using Props** 

Now that you’ve learned about props, let’s put this knowledge into practice!

- Create a new function UserProfile inside App.jsx.
- Inside this function, return a <div> that contains: A heading: "User Profile:" A paragraph to display the name (using props.name) A paragraph to display the age (using props.age)
- Use UserProfile inside App and pass different values for name and age.
- Ensure the component appears twice with different names and ages.
#### Expected Output on Screen:

```
User Profile:  
Name: Alice  
Age: 25  

User Profile:  
Name: Bob  
Age: 30  

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T05:41:28.711Z  

```cpp
// UserProfile component: A reusable component to display user information
function UserProfile(props) {
return (
<div>
<h2>User Profile</h2>
<p>Name: {props.name}</p>
<p>Age: {props.age}</p>
</div>
);
}

// App component: Renders multiple UserProfile components with different data
function App() {
return (
<div>
<UserProfile name="John" age={25} />
<UserProfile name="Emma" age={30} />
</div>
);
}

export default App; // Exporting the App component for use in the application
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR63)