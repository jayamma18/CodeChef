# OJJAR209

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Re-triggering CSS Animations

When building modern interfaces, it's not just about showing the right data—it's also about how that data appears. Animations can turn a jarring content update into a smooth, delightful experience for users. But if you've ever tried to animate changes in React using standard CSS, you might have noticed something odd: the animation only runs once, and then... nothing.

In this lesson, we’ll explore why that happens—and how to fix it with a clean, React-friendly solution that leverages a familiar prop in a new way.

Now, Just run the App, change the price... and the animation only plays the first time the component loads. Subsequent price changes just update the text instantly, without the animation. Why?

 **Why Standard CSS Animations Only Run Once Here:** 

CSS keyframe animations typically trigger under two conditions:

- On Mount: When the HTML element associated with the animation class is first added to the DOM.
- On Class Addition: When the specific CSS class containing the animation property is added to an existing DOM element.

In our `PriceDisplay` component, the `<div>` with the `styles.animated` class is created once when `PriceDisplay` mounts. When the `price` prop changes, React efficiently updates only the text content inside that existing `<div>`. The element itself isn't removed and re-added, nor is the class removed and re-added. So, the animation doesn't get a new trigger.

 **The Elegant Solution: Leveraging the `key` Prop** 

We know the `key` prop is essential when rendering lists in React. It helps React identify which items have changed, been added, or been removed, allowing for efficient updates.

```
// Standard list example
data.map(item => <ListItem key={item.id} data={item} />);

```

But the `key` prop has a broader implication:  **It provides a unique identity for a React element across render cycles.** 

What happens if we give our animated `div` a `key` that changes whenever the data we want to animate also changes?

```
function PriceDisplay({ price }) {
  console.log(`Rendering PriceDisplay with price: ${price}, key: ${price}`);

  return (
    <div className={styles.wrapper}>
      {/*
        The key prop is crucial here!
        When the 'price' prop changes, React sees a new key.
        It discards the old div and creates a new one.
        This creation/mounting of the new div re-triggers the CSS animation.
      */}
      <div key={price} className={styles.animated}>
        {`$` + price}
      </div>
    </div>
 );
}

```

write the code and check...!  **Oh it is working** 

#### How Does This Work?
- Initial Render: Let's say the initial price is 50. React renders the inner div with key="50". The element is added to the DOM, and the fadeIn animation runs because it's a new element being mounted.
- Price Changes: Now, the price prop updates to 100. The PriceDisplay component re-renders.
- React Reconciliation: React looks at the element tree. It sees an inner div that now has key="100". In the previous render, the corresponding element had key="50".
- Key Change = Different Element: Because the key has changed, React treats this as a completely different element. It doesn't try to update the old key="50" element. Instead, it: Unmounts: Removes the old div (the one with key="50") from the DOM. Mounts: Creates and inserts a brand new div (the one with key="100") into the DOM.
- Animation Re-triggers: Since a new div was just mounted with the styles.animated class, the CSS animation runs again!
#### Why This Isn't a "Hack":

Using `key` this way might initially feel like exploiting a loophole, but it's actually leveraging the core purpose of keys exactly as intended by the React team. Keys are the mechanism for establishing element identity. By changing the key, you are explicitly telling React, "The element associated with the old identity is gone; here is a fundamentally new one." The DOM replacement and subsequent animation trigger are natural consequences of this instruction.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T08:20:28.706Z  

```cpp
import styles from './styles.module.css';

function PriceDisplay({ price }) {
  console.log(`Rendering PriceDisplay with price: ${price}, key: ${price}`);

    return (
        <div className={styles.wrapper}>
              {/* Passing price as key re-triggers animation on value change */}
                    <div key={price} className={styles.animated}>
                            {'$ ' + price}
                                  </div>
                                      </div>
                                        );
                                        }

                                        export default PriceDisplay;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR209)