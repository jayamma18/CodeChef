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