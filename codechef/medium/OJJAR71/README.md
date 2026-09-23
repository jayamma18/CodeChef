# OJJAR71

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### React Keys

Imagine you’re building a list in React using  **`map()`**. Something like showing a list of  **`todos`**,  **`users`**, or  **`products`**.

```
const todos = ['Buy milk', 'Wash car', 'Read book'];

return (
  <ul>
    {todos.map(todo => (
      <li>{todo}</li>
   ))}
  </ul>
);

```

This code will work. It will show all the list items. But there’s a hidden problem.

 **What's the problem?** 

When React needs to update the list - for example, if you remove an item or reorder it - React doesn’t know which list item is which. Inside that  **`map()`**, each  **`li`**  looks the same to React. There's no unique identity.

React depends on this identity to figure out:

- Which items changed?
- Which items are new?
- Which items were removed?

So if you update your list (like delete an item), React won’t know what exactly changed. It might re-render items incorrectly. This can lead to bugs, strange behavior, or performance issues.

#### That’s where keys come in!

By giving each item in a list a  **`key`**, you help React uniquely identify each element. So React can keep track of the items even if they change over time.

Think of it like a name tag. If React sees a new list, and each item has a name tag, it can match them properly.

 **Let’s fix the above code using keys:** 

```
const todos = ['Buy milk', 'Wash car', 'Read book'];

return (
  <ul>
    {todos.map((todo, index) => (
      <li key={index}>{todo}</li>
   ))}
  </ul>
);

```

Here, we added a  **`key`**  to each  **`<li>`**. In this example, we're using the  **`index`**  as a key. That’s okay  **only if**  the list never changes (no adding, deleting, or reordering). But if you can delete or reorder items, using  **`index`**  is not recommended.

If your items have something unique (like an ID), use that:

```
const todos = [
  { id: 1, text: 'Buy milk' },
  { id: 2, text: 'Wash car' },
  { id: 3, text: 'Read book' }
];

return (
  <ul>
    {todos.map(todo => (
      <li key={todo.id}>{todo.text}</li>
   ))}
  </ul>
);

```

Now React knows exactly which item is which, even if the list changes.

 **Important to know** 

- Without keys, React can't uniquely identify elements in a list.
- This causes trouble when items are added, removed, or reordered.
- Keys fix this by giving each list item a unique identity.
- Always try to use something unique and stable, like an ID.

Modify the provided React component to follow React's best practices by adding unique keys to dynamically rendered list elements.

 **Steps to Complete the Task:** 

- Add Unique IDs to Student Data In the students array, add a unique id property to each student object. Use numeric values (e.g., 1, 2, 3, 4). Example modification: // Before { name: "John", age: 20 } // After { id: 1, name: "John", age: 20 }
- Assign Keys to Rendered Components In the JSX map() function, add a key prop to the outermost <div> being returned for each student. Use the student's id as the unique key value. Example modification: // Before <div className="student-card"> {/ *After* /} <div key={student.id} className="student-card">

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T05:56:07.207Z  

```cpp
import React from "react";
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR71)