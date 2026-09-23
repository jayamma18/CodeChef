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