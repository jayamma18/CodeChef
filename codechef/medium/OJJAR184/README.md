# OJJAR184

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Building a Custom FAQ Accordion

Radix UI provides unstyled, accessible building blocks like the  **Accordion**  primitive. This primitive lets you create collapsible content sections (like an FAQ) where clicking a heading (Trigger) reveals associated content. Radix handles the functionality, accessibility (ARIA attributes, keyboard navigation), and state management, while you control the visual appearance entirely with your own CSS.

Key components involved:

- Accordion.Root: The main container managing overall behavior (e.g., only one item open).
- Accordion.Item: Represents a single question/answer pair.
- Accordion.Header: A semantic wrapper for the trigger.
- Accordion.Trigger: The clickable element (the question) that toggles the content.
- Accordion.Content: The container for the hidden/shown answer.

Radix uses `data-state` attributes (like `data-state="open"`) on these elements, allowing you to apply specific CSS styles when an item is open or closed.

### Task

 **Your Goal:**  Create a simple "Frequently Asked Questions" (FAQ) section for a fictional product website. Users should be able to click on a question to reveal its answer. Only one answer should be visible at a time. You will use Radix UI's Accordion primitive for the core functionality and write your own CSS to style it.

 **Your application should function as shown.** 

#### Task Statement
- Set Up Root: Replace the placeholder comment ({/ *--- YOUR ACCORDION IMPLEMENTATION GOES HERE ---* /}) with <Accordion.Root>. Add props: className={styles.container}: Apply base styling. type="single": Purpose: Allow only one item open at once. collapsible={true}: Purpose: Allow closing the currently open item.
- Render Items: Inside <Accordion.Root>, map over the items prop: {items.map(({ id, question, answer }) => (...))}. For each item, render <Accordion.Item> with props: key={id}: Purpose: React list key. value={id}: Purpose: Radix identifier for item state. className={styles.item}: Apply item styling.
- Add Trigger: Inside <Accordion.Item>, add <Accordion.Header>. Inside <Accordion.Header>, add <Accordion.Trigger className={styles.trigger}>. Place the question variable inside the <Accordion.Trigger>.
- Add Content: Inside <Accordion.Item> (after </Accordion.Header>), add <Accordion.Content className={styles.content}>. Place the answer variable inside the <Accordion.Content>.
- Verify: Run the app and test the accordion functionality: clicking questions should toggle answers, only one answer should show, and open questions should be closable. Check that styles from FAQAccordion.module.css (like.item,.trigger,.content, and styles using [data-state='open']) are applied.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-03T05:50:27.595Z  

```cpp
import FAQAccordion from './FAQAccordion';
import './App.css';

const faqItems = [
{
id: 'item-1',
question: 'What is an unstyled component library?',
answer:
'It provides functional and accessible UI components (like buttons, dialogs, accordions) without any built-in visual styles, allowing you to apply your own custom look and feel.',
},
{
id: 'item-2',
question: 'Why use Radix UI?',
answer:
'Radix UI focuses on accessibility, developer experience, and customization. It gives you solid building blocks so you dont have to reinvent the wheel for common UI patterns.',
},
{
id: 'item-3',
question: 'Can I style Radix components easily?',
answer:
'Yes! Since they are unstyled, you apply styles using standard CSS, CSS Modules, Tailwind CSS, Styled Components, or any other styling method you prefer.',
},
];

function App() {
return (
<div className="AppContainer">
<h1>Frequently Asked Questions</h1>
<FAQAccordion items={faqItems} />
</div>
);
}

export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR184)