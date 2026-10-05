const express = require('express');
const app = express();
app.use(express.json());

let tasks = [];

// Get all tasks
app.get('/tasks', (req, res) => {
  res.json(tasks);
  });

  // Create a new task
  app.post('/tasks', (req, res) => {
    const task = { id: tasks.length + 1, text: req.body.text };
      tasks.push(task);
        res.status(201).json(task);
        });

        // Get a single task by ID
        app.get('/tasks/:id', (req, res) => {
          const task = tasks.find(t => t.id == req.params.id);
            if (task) {
                res.json(task);
                  } else {
                      res.status(404).json({ error: 'Task not found' });
                        }
                        });

                        // Update a task by ID
                        app.put('/tasks/:id', (req, res) => {
                          const task = tasks.find(t => t.id == req.params.id);
                            if (task) {
                                task.text = req.body.text;
                                    res.json(task);
                                      } else {
                                          res.status(404).json({ error: 'Task not found' });
                                            }
                                            });

                                            // Delete a task by ID
                                            app.delete('/tasks/:id', (req, res) => {
                                              const index = tasks.findIndex(t => t.id == req.params.id);
                                                if (index !== -1) {
                                                    tasks.splice(index, 1);
                                                        res.status(204).send();
                                                          } else {
                                                              res.status(404).json({ error: 'Task not found' });
                                                                }
                                                                });

                                                                const PORT = 8080;
                                                                app.listen(PORT, () => {
                                                                  console.log(`Server running on port ${PORT}`);
                                                                  });