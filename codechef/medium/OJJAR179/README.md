# OJJAR179

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### React Context to Avoid Prop Drilling

As React applications grow, one common problem developers face is  **prop drilling**. This happens when you need to pass data from a high-level component (like `App`) to a deeply nested component (like `ModuleLessons`), even though many intermediate components don’t need that data.

Let’s break this down clearly,

#### What is Prop Drilling?

Imagine you’re trying to deliver a letter (user data) from the top of a building (App component) to someone on the 10th floor (ModuleLessons). But instead of a direct delivery system, you’re handing it to someone on each floor, floor by floor, until it finally reaches the person it's meant for.

Here's an example of this in code:

```
function App() {
  const user = { name: "Sarah", progress: "Module 3" };
  return <Layout user={user} />;
}

function Layout({ user }) {
  return <CoursePage user={user} />;
}

function CoursePage({ user }) {
  return <ModuleLessons user={user} />;
}

function ModuleLessons({ user }) {
  return <div>Progress: {user.progress}</div>;
}

```

Even though only `ModuleLessons` needs the `user`, every component in-between has to pass it down.

This works okay for small apps with few levels, but in large applications, it quickly becomes messy and hard to maintain.

#### What Does React Context Solve?

 **Context lets you share values like `user` across the entire component tree without explicitly passing props at every level.** 

To reuse the building analogy – with Context, it's like installing a direct elevator from the top floor straight to the 10th floor. You skip every floor in-between.

Let’s see how we can use React Context to solve prop drilling.

#### Step-by-Step Example Using Context

Let’s take the same app and refactor it to use Context.

- Create a context file

```
// UserContext.js
import React from 'react';
const UserContext = React.createContext(null);
export default UserContext;

```

 **Explanation** :

- React.createContext() creates a new Context object we can use in our app.
- We export it so that all files in our app can use the same shared context.
- Provide the context at a high level

```
// App.jsx
import UserContext from './UserContext';
import Layout from './Layout';

function App() {
  const user = { name: "Sarah", progress: "Module 3" };

  return (
    <UserContext.Provider value={user}>
      <Layout />
    </UserContext.Provider>
 );
}

export default App;

```

 **Explanation** :

- We wrap the top-level component (Layout) with UserContext.Provider.
- Every component inside Layout can now access the user object via context — no need for props!
- You’re setting the value (value={user}) you want all children to access.
- Consume the context in deeply nested components

Even though `Layout` and `CoursePage` don’t care about `user`, now they don’t need to worry about it.

```
// ModuleLessons.jsx
import { useContext } from 'react';
import UserContext from './UserContext';

function ModuleLessons() {
  const user = useContext(UserContext);

  return <div>Progress: {user.progress}</div>;
}

```

 **Explanation** :

- useContext(UserContext) allows you to grab the value directly from the context.
- Now ModuleLessons can use user.progress without anyone passing it down as a prop.
- This means Layout and CoursePage don’t even need to know about user.

Here, `ModuleLessons` reaches directly into the context and grabs the `user` object, without prop-drilling through every parent.

In our IDE, you can see the code provided — go ahead and run it to check how it works.

#### Why This Is Useful

Let’s picture another scenario. The design team updates the UI and moves `ModuleLessons` under a totally new parent. With props, you'd have to rewire every component in the new path to start passing the `user` again. With context, you don't have to touch anything — any component inside the tree can access the user data whenever it needs to.

No more forgetting to update props. No more messy component signatures filled with unused props.

👉 Once you're done exploring and understand how it works, just click Submit to complete this problem and move on to the next one.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-03T05:19:47.421Z  

```cpp
import ModuleLessons from './ModuleLessons';

function CoursePage() {
  return (
    <div className="course-page">
      <h2>Introduction to Context</h2>
      <ModuleLessons />
    </div>
  );
}

export default CoursePage;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR179)