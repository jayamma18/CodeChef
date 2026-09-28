# OJJAR218

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### React State Updates with Immer

 **The Challenge: Immutability and Nested Data** 

In React, updating state immutably is crucial. While simple state updates (like changing a string or number) are straightforward, updating data nested deep within objects and arrays becomes complex. You need to manually create copies at  *every*  level of nesting leading down to the piece of data you want to change.

 **Our Example: A Calendar App** 

Take a look at the code provided in the IDE section. It's a basic React application that manages a list of calendar `events` in its state. Each event is an object, which might contain nested information, like `metadata` which in turn could contain a list of `invitees`.

The app includes buttons that allow us to modify this state. We'll focus on the task of removing a specific invitee ("Gerarda Nicomedes") from one of the events ("team-meeting"). The code demonstrates two different approaches to achieve this update immutably. This example highlights how tricky manual immutable updates can be for nested data.

Now, Consider our `events` state. To remove an invitee ("Gerarda Nicomedes") from the `team-meeting` event, the path is:

`events` (array) -> `team-meeting` (object) -> `metadata` (object) -> `invitees` (array)

Manually updating this immutably requires:

- Creating a new filtered invitees array.
- Creating a new metadata object, spreading the old properties and adding the new invitees.
- Creating a new team-meeting event object, spreading the old properties and adding the new metadata.
- Creating a new events array (using map), replacing the old team-meeting with the new one.

You can see this verbose process implemented in the `handleRemoveManually` function in the code below. It works correctly, but it's lengthy and prone to errors.

 **Enter Immer: The Simpler Way** 

Immer is a library designed to solve this exact problem. It lets you write code that  *looks like*  you're directly mutating the state, while Immer handles the necessary immutable copying behind the scenes.

 **How Immer Works (The Gist):** 

- You wrap your state update logic inside Immer's produce function.
- produce gives you a special temporary draft version of your state. This draft acts like your photocopy – you can safely "draw" on it.
- You write simple, direct code to modify the draft (e.g., using find to locate an object, push to add to an array, or splice to remove from an array).
- When your logic finishes, Immer analyzes the changes you made to the draft and automatically produces the next, correctly structured, immutable state, with all the necessary copies created for you.

 **The Immer Solution in Action:** 

Look at the `handleRemoveWithImmer` function in the code. Notice how much simpler it is:

```
    setEvents(produce(draft => { // Give produce the current state (implicitly) and a recipe
        // Find the event directly within the draft
        const eventToUpdate = draft.find(
            event => event.eventId === 'team-meeting'
       );
        if (eventToUpdate) {
            // Find the invitee index within the draft's array
            const inviteeIndex = eventToUpdate.metadata.invitees.findIndex(
                invitee => invitee.email === 'gnicomedes@widgetco.com'
           );
            if (inviteeIndex !== -1) {
                // Mutate the draft directly using splice!
                eventToUpdate.metadata.invitees.splice(inviteeIndex, 1);
            }
        }
        // No return needed inside the recipe; Immer handles it.
    }));

```

Inside the `produce` function, we treat `draft` as if it were mutable. We `find` the event and directly use `splice` on the `draft.metadata.invitees` array. Immer takes care of ensuring this results in a brand new, immutable `events` state being passed to `setEvents`.

 **Why Use Immer?** 

- Readability: Code focuses on the intent (remove an invitee) rather than the mechanics of immutable updates.
- Simplicity: Significantly less boilerplate code compared to manual copying.
- Maintainability: Easier to understand and modify state update logic, reducing the chance of bugs, especially with complex state shapes.
### Code / Try It Out

You can run this code.

- Click "Remove Gerarda (Manual Immutable Update)": This uses the verbose, manual copying method.
- Click "Remove Gerarda (Using Immer)": This uses the concise Immer approach.
- Click "Reset State": This resets the state to the initial data.

Observe that both "Remove" buttons achieve the  **exact same result**  in the displayed state – Gerarda is removed from the team meeting invitees. However, the underlying code for the Immer button (`handleRemoveWithImmer`) is significantly cleaner and easier to understand than the manual approach (`handleRemoveManually`).

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T08:48:56.736Z  

```cpp
import React, { useState } from 'react';
import { produce } from 'immer';
import './App.css';

const initialEventsData = [
  {
      eventId: 'event1',
          title: 'Coffee with Samantha',
              date: '2023-11-02T12:00:00.000Z',
                  metadata: {
                        invitees: [
                                { name: 'Samantha', email: 'samantha@example.com' }
                                      ]
                                          }
                                            },
                                              {
                                                  eventId: 'event2',
                                                      title: 'Focus time',
                                                          date: '2023-11-02T13:00:00.000Z',
                                                              metadata: {
                                                                    notes: 'Time for me to focus!'
                                                                        }
                                                                          },
                                                                            {
                                                                                eventId: 'event3',
                                                                                    title: 'Team meeting',
                                                                                        date: '2023-11-02T15:00:00.000Z',
                                                                                            metadata: {
                                                                                                  notes: 'Weekly team catch up call!',
                                                                                                        invitees: [
                                                                                                                { name: 'Lois Fahler', email: 'lfahler@widgets.com' },
                                                                                                                        { name: 'Gerarda Nicosmides', email: 'gnicosmides@widgets.com' }, // Target for removal
                                                                                                                                { name: 'Evgit Popova', email: 'epopova@widgets.com' },
                                                                                                                                        { name: 'Envis Geppe', email: 'egeppe@widgets.com' }
                                                                                                                                              ]
                                                                                                                                                  }
                                                                                                                                                    }
                                                                                                                                                    ];

                                                                                                                                                    const getInitialState = () => JSON.parse(JSON.stringify(initialEventsData));

                                                                                                                                                    export default function App() {
                                                                                                                                                      const [events, setEvents] = useState(getInitialState);

                                                                                                                                                        // Method 1: Manual Immutable Update (Verbose)
                                                                                                                                                          const handleRemoveWithManual = () => {
                                                                                                                                                              setEvents((currentEvents) => {
                                                                                                                                                                    return currentEvents.map((event) => {
                                                                                                                                                                            if (event.title === 'Team meeting') {
                                                                                                                                                                                      const originalInvitees = event.metadata.invitees || [];
                                                                                                                                                                                                const inviteeIndex = originalInvitees.findIndex(
                                                                                                                                                                                                            (i) => i.email === 'gnicosmides@widgets.com'
                                                                                                                                                                                                                      );

                                                                                                                                                                                                                                if (inviteeIndex !== -1) {
                                                                                                                                                                                                                                            const newInvitees = [...originalInvitees];
                                                                                                                                                                                                                                                        newInvitees.splice(inviteeIndex, 1);

                                                                                                                                                                                                                                                                    return {
                                                                                                                                                                                                                                                                                  ...event,
                                                                                                                                                                                                                                                                                                metadata: {
                                                                                                                                                                                                                                                                                                                ...event.metadata,
                                                                                                                                                                                                                                                                                                                                invitees: newInvitees
                                                                                                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                                                                                                                          };
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                    return event;
                                                                                                                                                                                                                                                                                                                                                                                          });
                                                                                                                                                                                                                                                                                                                                                                                              });
                                                                                                                                                                                                                                                                                                                                                                                                };

                                                                                                                                                                                                                                                                                                                                                                                                  // Method 2: Update using Immer (Clean & Mutative Syntax)
                                                                                                                                                                                                                                                                                                                                                                                                    const handleRemoveWithImmer = () => {
                                                                                                                                                                                                                                                                                                                                                                                                        setEvents(
                                                                                                                                                                                                                                                                                                                                                                                                              produce((draft) => {
                                                                                                                                                                                                                                                                                                                                                                                                                      const eventToUpdate = draft.find((event) => event.title === 'Team meeting');
                                                                                                                                                                                                                                                                                                                                                                                                                              if (eventToUpdate && eventToUpdate.metadata && eventToUpdate.metadata.invitees) {
                                                                                                                                                                                                                                                                                                                                                                                                                                        const inviteeIndex = eventToUpdate.metadata.invitees.findIndex(
                                                                                                                                                                                                                                                                                                                                                                                                                                                    (i) => i.email === 'gnicosmides@widgets.com'
                                                                                                                                                                                                                                                                                                                                                                                                                                                              );
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (inviteeIndex !== -1) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    // Directly mutate the draft array
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                eventToUpdate.metadata.invitees.splice(inviteeIndex, 1);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          }
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR218)