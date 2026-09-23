# OJJAR90

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Create Simple Todo List

Create a React todo list that allows users to:

- Add new todos through an input field
- Mark todos as completed
- See all todos in a list
- Display a message when no todos exist
#### Requirements

 **1. State Initialization (Critical)** 

- Initialize todos state as empty array
- Initialize newTodo state as empty string

 **2. Form Submission Handling (`handleSubmit`)** 

- Prevent default form behavior with e.preventDefault()
- Validate input: reject empty/whitespace-only submissions
- Add new todo object with: Unique id (use Date.now()) text (trimmed input value) completed: false initial state
- Clear input field after submission

 **3. Todo Completion Toggle (`toggleComplete`)** 

- Implement state update logic using map()
- Toggle completed property for matching todo ID
- Ensure immutability (no direct state mutation)

 **4. UI Implementation** 

- Form Requirements: Add onSubmit={handleSubmit} Input field must have: value={newTodo} binding onChange handler for state updates Placeholder text
- Todo List Display: Show "No todos" message when array is empty (use empty-message class) For each todo: Add key={todo.id} Implement dynamic className: todo-item ${todo.completed ? 'completed' : ''} Create checkbox with: type="checkbox" checked={todo.completed} onChange handler for completion toggle
- Styling Requirements
- Ensure CSS classes exist:.todo-item.completed for strikethrough effects.empty-message for empty state styling
#### Your App should be look like this

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:22:30.875Z  

```cpp
                                      text: newTodo.trim(),
                                            completed: false,
                                                };

                                                    setTodos([...todos, newTodoObj]);

                                                        // Clear the input field after adding
                                                            setNewTodo("");
                                                              };

                                                                // Function to toggle the 'completed' status of a todo
                                                                  const toggleComplete = (id) => {
                                                                      setTodos(
                                                                            todos.map((todo) =>
                                                                                    todo.id === id ? { ...todo, completed: !todo.completed } : todo
                                                                                          )
                                                                                              );
                                                                                                };

                                                                                                  return (
                                                                                                      <div className="App">
                                                                                                            <h1>Todo List</h1>

                                                                                                                  {/* Form for adding new todos */}
                                                                                                                        <form onSubmit={handleSubmit} className="todo-form">
                                                                                                                                <input
                                                                                                                                          type="text"
                                                                                                                                                    value={newTodo}
                                                                                                                                                              onChange={(e) => setNewTodo(e.target.value)}
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR90)