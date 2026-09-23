# OJJAR66

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Children Prop in React

The `children` prop in React allows a component to wrap and display other components or elements inside it. This makes it useful for creating flexible and reusable components.

#### Example of children Prop

```
function Wrapper ({ children }) {
    return <h1>{children}</h1>;
};
  
function App() {
    return (
      <Wrapper>
        Hello, World!
      </Wrapper>
   );
}
export default App;

```

#### Output

#### Explanation
- The Wrapper component accepts a children prop and renders any content placed inside it.
- In App.js, <Wrapper> is used to wrap a <h1> element (Hello, World!).
- This setup ensures any content inside <Wrapper> is displayed with a border and padding.
#### Task for You

You have a `Message` component that currently receives a `text` prop to display a message. Your task is to modify the component so that it uses the `children` prop instead of a regular prop (`text`).

 **Note: You can also use arrow functions to define components.**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T05:44:25.445Z  

```cpp
const Message = ({ text }) => {
  return <p>{text}</p>;
};

function App() {
  return (
    <div>
      <Message text="Hello, this is a message!" />
    </div>
  );
}

export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR66)