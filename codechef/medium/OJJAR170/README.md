# OJJAR170

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Understanding the Component Spectrum

In React, components are the building blocks of your application. But not all components are the same—some are small and reusable (like buttons), while others are big and specific (like a whole page).

The  **Spectrum of Components**  is a way to think about how components range from small and reusable to large and specific. Unlike strict categories (like "atoms" or "molecules"), this idea says components exist on a  **fluid scale** —meaning they can be anywhere between super reusable and very specific.

#### Why is this important?
- Avoids unnecessary debates – No need to argue whether a component is an "atom" or "molecule."
- Easier to organize – Instead of forcing components into strict folders, you can keep them in a simple structure.
- More flexible – Real-world components don’t always fit into neat boxes, and that’s okay!

To demonstrate the  **Spectrum of Components**, let's create a reusable  **`Card`**  component that uses our existing  **`Button`**  component. This shows how small, reusable components (Button) can be combined into larger, still-reusable components (Card), which are then used in a specific page (HomePage).

 **1. Reusable `Card` Component (Medium Reusability)** 

This  **`Card`**  accepts  **`title`**,  **`content`**, and  **`actionButtons`**  props. It uses the  **`Button`**  component internally.

```
// Card.jsx
import React from 'react';
import Button from './Button';

function Card({ title, content, actionButtons }) {
  return (
    <div className="card">
      <h2>{title}</h2>
      <p>{content}</p>
      <div className="card-actions">
        {actionButtons}
      </div>
    </div>
 );
}

export default Card;

```

 **2. Updated `HomePage` (Specific Component)** 

Now,  **`HomePage`**  uses the  **`Card`**  component with our reusable  **`Button`**  inside it.

```
// HomePage.jsx
import React from 'react';
import Card from './Card';
import Button from './Button';

function HomePage() {
  const handleLearnMore = () => alert('Learn more clicked!');
  const handleSubscribe = () => alert('Subscribe clicked!');

  return (
    <div>
      <h1>Welcome to Our Platform</h1>
      
      {/ *Reusable Card with Buttons* /}
      <Card
        title="Featured Post"
        content="Discover our latest updates and features."
        actionButtons={
          <>
            <Button text="Learn More" onClick={handleLearnMore} />
            <Button text="Subscribe" onClick={handleSubscribe} />
          </>
        }
      />
    </div>
 );
}

export default HomePage;

```

- Reusable Card: The Card component is flexible enough to work with any content and buttons.
- No Duplication: Buttons are reused via the Button component, avoiding manual <button> tags.
- Spectrum Illustrated: Button → Small, highly reusable. Card → Medium, reusable structure. HomePage → Large, specific layout using smaller components.

This approach avoids rigid categories and focuses on  **scalable reusability**  across the component spectrum.

Components can vary in size and reusability, like building blocks. A small, reusable  **Button**  (used multiple times) sits inside a larger, specific  **HomePage** —this shows how components exist on a spectrum: from tiny, flexible pieces (used everywhere) to big, purpose-built sections (used once). Focus less on labels and more on creating components that scale from general to specific as needed.

#### Task:

Now you can review the flow of the code and experiment with it to better understand how it works. Once you're done and everything looks good, go ahead and  **submit**  it. After that, move on to the  **next problem**.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T10:46:23.845Z  

```cpp
import './App.css'; 

function Button({ text, onClick }) {
  return <button className="btn" onClick={onClick}>{text}</button>;
}

export default Button;

```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR170)