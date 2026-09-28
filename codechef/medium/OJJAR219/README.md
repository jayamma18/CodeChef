# OJJAR219

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Build a Simple Profile Editor

 **Introducing `useImmer`** 

Now that we know how  **Immer's**  `produce` function simplifies immutable updates by letting us work with a `draft` state, let's see how  **Immer**  integrates even more smoothly with React components using the `useImmer` hook.

The `useImmer` hook, provided by the Immer library, is designed specifically to simplify these kinds of updates. It lets you write code that  *looks like*  you are directly modifying the state, while Immer handles the necessary immutable copying behind the scenes.

 **How `useImmer` Works:** 

- Replace useState: You import useImmer from the use-immer package and use it instead of useState. It returns the current state and an updater function, just like useState. import { useImmer } from 'use-immer'; // Inside your component: const [user, updateUser] = useImmer(initialUserState);
- Use the Updater with a "Recipe": The key difference is how you use the updater function (e.g., updateUser). Instead of passing the new state value directly, you pass it a function. This function is often called a "recipe".
- Modify the draft: Immer calls your recipe function and provides it with a special draft version of your current state. Inside this recipe, you can write code to modify the draft object directly, as if it were mutable. const handleStreetChange = (event) => { const newStreet = event.target.value; updateUser(draft => { // Directly "mutate" the draft state! draft.address.street = newStreet; }); };
- Immer Creates the Next State: When your recipe function finishes, Immer analyzes the changes you made to the draft and automatically produces the correctly structured, immutable next state for you.

This approach dramatically simplifies your update logic, making it more readable and less prone to errors, especially for complex state shapes.

 **Our Project: Simple Profile Editor** 

In this task, we'll build a very basic profile editor. It will display a user's name, email, and address (street and city). You'll be able to type into input fields to update this information. The user's information will be stored in a  *nested state object*, making it a perfect scenario to practice using Immer for easier updates.

#### Your Task

Your goal is to take the provided template code and modify it to use `useImmer` to manage and update the user's profile information.

 **Steps:** 

- Import useImmer: Import the useImmer hook at the top of your App.js file.
- Replace useState: Find the line using React.useState to manage the user state. Replace it with useImmer. Remember, useImmer returns the state and an updater function, just like useState.
- Implement handleInputChange: Complete the handleInputChange function. This function will be called whenever you type into any of the input fields.
- Use the Immer Updater: Inside handleInputChange, call the updater function you got from useImmer. Pass it a function that receives the draft state.
- Modify the Draft: Inside that function, write code to directly modify the correct property of the draft object based on which input field triggered the change. You can get the name (like 'name', 'email', 'street', 'city') and the new value from the event target (event.target.name and event.target.value). For 'name' and 'email', update draft[name] = value;. For 'street' and 'city', update the nested address object: draft.address[name] = value;.
- Test: Run your component. You should see the initial profile data. As you type into the input fields, the displayed profile information below the inputs should update in real-time. Notice how Immer lets you write simple assignment code (draft.address.street =...) instead of complex spreading.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T08:50:41.870Z  

```cpp
import { useImmer } from "use-immer";
import "./App.css"; // Assuming you have the CSS in App.css or styles.css

function ProfileEditor() {
  // 1. Initial state managed with useImmer
    const [user, updateUser] = useImmer({
        name: "Alice Wonderland",
            email: "alice@example.com",
                address: {
                      street: "123 Imagination Lane",
                            city: "Storybook City",
                                },
                                  });

                                    // 2. Handle input changes using Immer's mutable-style updates
                                      const handleInputChange = (event) => {
                                          const { name, value } = event.target;

                                              updateUser((draft) => {
                                                    if (name === "name" || name === "email") {
                                                            draft[name] = value;
                                                                  } else if (name === "street" || name === "city") {
                                                                          draft.address[name] = value;
                                                                                }
                                                                                    });
                                                                                      };

                                                                                        return (
                                                                                            <div className="profile-editor">
                                                                                                  <h2>Edit Your Profile</h2>

                                                                                                        <div className="form-group">
                                                                                                                <label htmlFor="name">Name:</label>
                                                                                                                        <input
                                                                                                                                  type="text"
                                                                                                                                            id="name"
                                                                                                                                                      name="name"
                                                                                                                                                                value={user.name}
                                                                                                                                                                          onChange={handleInputChange}
                                                                                                                                                                                  />
                                                                                                                                                                                        </div>

                                                                                                                                                                                              <div className="form-group">
                                                                                                                                                                                                      <label htmlFor="email">Email:</label>
                                                                                                                                                                                                              <input
                                                                                                                                                                                                                        type="email"
                                                                                                                                                                                                                                  id="email"
                                                                                                                                                                                                                                            name="email"
                                                                                                                                                                                                                                                      value={user.email}
                                                                                                                                                                                                                                                                onChange={handleInputChange}
                                                                                                                                                                                                                                                                        />
                                                                                                                                                                                                                                                                              </div>

                                                                                                                                                                                                                                                                                    <div className="form-group">
                                                                                                                                                                                                                                                                                            <label htmlFor="street">Street:</label>
                                                                                                                                                                                                                                                                                                    <input
                                                                                                                                                                                                                                                                                                              type="text"
                                                                                                                                                                                                                                                                                                                        id="street"
                                                                                                                                                                                                                                                                                                                                  name="street"
                                                                                                                                                                                                                                                                                                                                            value={user.address.street}
                                                                                                                                                                                                                                                                                                                                                      onChange={handleInputChange}
                                                                                                                                                                                                                                                                                                                                                              />
                                                                                                                                                                                                                                                                                                                                                                    </div>

                                                                                                                                                                                                                                                                                                                                                                          <div className="form-group">
                                                                                                                                                                                                                                                                                                                                                                                  <label htmlFor="city">City:</label>
                                                                                                                                                                                                                                                                                                                                                                                          <input
                                                                                                                                                                                                                                                                                                                                                                                                    type="text"
                                                                                                                                                                                                                                                                                                                                                                                                              id="city"
                                                                                                                                                                                                                                                                                                                                                                                                                        name="city"
                                                                                                                                                                                                                                                                                                                                                                                                                                  value={user.address.city}
                                                                                                                                                                                                                                                                                                                                                                                                                                            onChange={handleInputChange}
                                                                                                                                                                                                                                                                                                                                                                                                                                                    />
                                                                                                                                                                                                                                                                                                                                                                                                                                                          </div>

                                                                                                                                                                                                                                                                                                                                                                                                                                                                <div className="display-info">
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        <h3>Current Profile Information:</h3>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                <p><strong>Name:</strong> {user.name}</p>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        <p><strong>Email:</strong> {user.email}</p>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                <p><strong>Address:</strong> {user.address.street}, {user.address.city}</p>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      </div>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          </div>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            export default ProfileEditor;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR219)