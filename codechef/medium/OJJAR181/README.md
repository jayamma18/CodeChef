# OJJAR181

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Understanding Modals

Modals are small popup windows that appear inside your application. They don't take you to a new page — they float over the current content, allowing you to interact with something extra like confirming an action, displaying a message or even showing a form. They’re commonly known as dialog boxes too.

Visually, they may seem simple: a box in the center of the screen with some text and a few buttons. But under the hood, creating a proper modal involves more than just designing a nice UI. If we want it to be accessible (usable by keyboard users, screen readers, etc.), we have to handle several hidden details too.

### What Makes a Modal Accessible and Usable?

Let’s walk through how we can build a modal from scratch while making sure it’s functional, usable, and accessible for everyone — not just mouse users.

#### 1. Conditional Rendering (Show/Hide the Modal)

In React, the first requirement is to conditionally show the modal. Usually, this is controlled by a `useState()` variable like:

```
const [isOpen, setIsOpen] = useState(false);

```

When `isOpen` is true, the modal appears. When it’s false, it disappears. This is the basic setup.

#### 2. Focus Management (Keyboard Navigation)

A major concern is  **focus**  — where the keyboard input goes. This is one of the trickiest parts and is often overlooked.

 **Key points here:** 

- When the modal opens, the first interactive element inside it (like the close button) should automatically get focus.
- While the modal is open, the user shouldn’t be able to tab outside of it.
- When the modal closes, the focus should go back to the element the user clicked before opening the modal.

You can do this manually in React by:

- Saving the last focused element before the modal opens
- Using.focus() on the close button inside the modal
- Restoring focus when it closes

But this is tedious and error-prone.

 **Better Solution: Use a Focus Management Library** 

There are libraries designed to help us here, like `react-focus-lock`. It automatically:

- Focuses the modal content when it opens
- Traps focus inside the modal
- Restores focus when it's closed

All you have to do is wrap your modal content like this:

```
import FocusLock from 'react-focus-lock';

<FocusLock returnFocus={true}>
  {/ *Modal content here* /}
</FocusLock>

```

This removes the need to manually handle `.focus()` or `document.activeElement`.

#### 3. Escape Key to Close the Modal

Another common behavior is letting users press the  **Escape**  key to close the modal.

You can handle this inside a `useEffect()`:

```
useEffect(() => {
    const handleKeyDown = (event) => {
      if (event.code === 'Escape') onClose();
    };
    window.addEventListener('keydown', handleKeyDown);
    return () => window.removeEventListener('keydown', handleKeyDown);
}, [onClose]);

```

This ensures the modal is closed when the user hits the Escape key.

#### 4. Clicking Outside (Backdrop Click to Close)

A good modal also allows users to click the dimmed background (often called the "backdrop") to close it. That can be as simple as:

```
<div onClick={handleClose} className="modal-backdrop"></div>

```

But be careful! You need to make sure that clicking inside the modal doesn’t trigger this same close action. So usually you'll need to stop the click from propagating inside the modal content.

#### 5. Disable Background Scrolling

When the modal is open, users shouldn't be able to scroll the main page behind it. This helps people focus where they’re meant to focus.

There’s a library called `react-remove-scroll` that makes this super easy. Wrap your modal like this:

```
import { RemoveScroll } from 'react-remove-scroll';

<RemoveScroll>
  <div>{/ *Modal content* /}</div>
</RemoveScroll>

```

This removes the scrollbar from the page while the modal is active, locking attention to just the modal.

#### 6. Making it Screen Reader Friendly (ARIA)

Screen readers need clues to understand what kind of dialog is being presented. This is where ARIA attributes help.

Inside your modal box, use:

```
<div 
  role="dialog" 
  aria-modal="true"
  aria-label="Modal Title"
>

```

This tells screen readers that this is a modal dialog and should act like one. Without this, screen readers just see another regular div.

Also, you should make the close button readable. Even if you’re just showing an icon (like an X), use hidden text so screen readers know what it's for:

```
<button onClick={handleClose}>
  <CloseIcon />
  <VisuallyHidden>Dismiss Modal</VisuallyHidden>
</button>

```

This visually hides helpful text, while still making it available to assistive tools.

That’s it — a fully functional, accessible modal! Explore the example in the IDE, tweak things around, and see accessibility in action.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-03T05:35:35.978Z  

```cpp
import { useState, useRef } from 'react';
import Modal from './Modal';
import './App.css';

function App() {
  const [isModalOpen, setIsModalOpen] = useState(false);
    const openModalButtonRef = useRef(null);

      const handleOpenModal = () => {
          setIsModalOpen(true);
            };

              const handleCloseModal = () => {
                  setIsModalOpen(false);
                    };

                      return (
                          <div className="App">
                                <header className="App-header">
                                        <h1>Accessible Modal Example</h1>
                                                <p>Click the button below to open the modal.</p>
                                                        <button
                                                                  ref={openModalButtonRef}
                                                                            onClick={handleOpenModal}
                                                                                      className="open-button"
                                                                                              >
                                                                                                        Open Confirmation Modal
                                                                                                                </button>
                                                                                                                      </header>

                                                                                                                            {/* Main content */}
                                                                                                                                  <div style={{ height: '150vh', paddingTop: '20px', borderTop: '1px solid #ccc', marginTop: '20px' }}>
                                                                                                                                          <p>Scrollable background content... try scrolling when the modal is open!</p>
                                                                                                                                                </div>

                                                                                                                                                      {/* Conditionally render the Modal */}
                                                                                                                                                            <Modal
                                                                                                                                                                    isOpen={isModalOpen}
                                                                                                                                                                            onClose={handleCloseModal}
                                                                                                                                                                                    title="Confirm Action"
                                                                                                                                                                                          >
                                                                                                                                                                                                  <p>Are you sure you want to proceed with this action? This cannot be undone.</p>
                                                                                                                                                                                                          <div className="modal-actions">
                                                                                                                                                                                                                    <button onClick={handleCloseModal} className="button-secondary">
                                                                                                                                                                                                                                Cancel
                                                                                                                                                                                                                                          </button>
                                                                                                                                                                                                                                                    <button 
                                                                                                                                                                                                                                                                onClick={() => { alert('Action Confirmed!'); handleCloseModal(); }} 
                                                                                                                                                                                                                                                                            className="button-primary"
                                                                                                                                                                                                                                                                                      >
                                                                                                                                                                                                                                                                                                  Confirm
                                                                                                                                                                                                                                                                                                            </button>
                                                                                                                                                                                                                                                                                                                    </div>
                                                                                                                                                                                                                                                                                                                          </Modal>
                                                                                                                                                                                                                                                                                                                              </div>
                                                                                                                                                                                                                                                                                                                                );
                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR181)