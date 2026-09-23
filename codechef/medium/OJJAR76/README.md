# OJJAR76

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Styling in React with CSS

When building React apps, styling is crucial for creating beautiful components. While you can use regular CSS files,  **CSS Modules**  offer a better way by scoping styles to individual components. This means no more class name clashes! Each component "owns" its styles, making your code cleaner and more maintainable.

 **Example: Creating a Card Component** 
Let's build a Card component with CSS Modules:

- Create the CSS Module (Card.module.css):

```
.card {
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  padding: 16px;
  margin: 12px;
}

.header {
  color: #333;
  font-size: 1.5rem;
  margin-bottom: 8px;
}

.content {
  color: #666;
  line-height: 1.5;
}

```

- Create the React Component:

```
import styles from './Card.module.css';

function Card({ title, children }) {
  return (
    <div className={styles.card}>
      <h2 className={styles.header}>{title}</h2>
      <div className={styles.content}>
        {children}
      </div>
    </div>
 );
}

import Card from './Card';

function App() {
  return (
    <div>
      <Card title="Welcome!">
        A styled component with scoped CSS using Modules.
      </Card>
    </div>
 );
}

```

 **How It Works:** 

- CSS Modules automatically generate unique class names (like Card_card_1xH8Z)
- The styles object maps your CSS class names to these unique identifiers
- Styles only apply to the component they're imported in

 **Another Example: Primary Button** 

```
/ *Button.module.css* /
.primary {
  background: blue;
  color: white;
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.primary:hover {
  background: darkblue;
}

```

```
import styles from './Button.module.css';

function Button({ children }) {
  return (
    <button className={styles.primary}>
      {children}
    </button>
 );
}

```

### Your Task: Style a Success Notification Component

Follow these steps using the provided template files:

- Implement CSS Styles In the Notification.module.css file:
- Set a green background using hex code #4CAF50
- Make text appear white
- Add 12px internal spacing (padding)
- Apply 10px vertical margin (top/bottom) with no horizontal margin
- Create rounded corners with 4px radius
- Add hover effect: slightly darker green background (#45a049)
- Complete the React Component In the app.jsx file:
- Use the CSS Module class notification
- Ensure the component accepts and displays the message prop
- Fix the empty JSX tags (replace them with proper structure)

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:00:11.830Z  

```cpp
import React from 'react';
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR76)