import React, { useState } from 'react';

// Child Component: Now "controlled" by the parent
function TextInput({ value, onChange }) {
  return <input value={value} onChange={onChange} />;
  }

  // Parent Component: Now holds the state and the logic to update it
  function App() {
    // 1. State is lifted here!
      const [sharedText, setSharedText] = useState('');

        // 2. Handler function lives in the parent
          const handleTextChange = (event) => {
              setSharedText(event.target.value);
                };

                  return (
                      <div>
                            <h2>Type in either box:</h2>
                                  <TextInput value={sharedText} onChange={handleTextChange} />
                                        <br />
                                              <TextInput value={sharedText} onChange={handleTextChange} />
                                                  </div>
                                                    );
                                                    }

                                                    export default App;