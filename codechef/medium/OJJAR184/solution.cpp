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