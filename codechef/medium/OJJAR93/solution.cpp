import React from 'react';
import './App.css';

function App() {
  // update the code
    const [guests, setGuests] = React.useState([
        'Bruce Wayne', 'Clark Kent', 'Diana Prince'
          ]);

            return (
                <div className="container">
                      <h1>Guest List</h1>
                            <ul className="guest-list">
                                    {guests.map((guest, index) => (
                                              <li key={guest} className="guest-item">
                                                          <input defaultValue={guests[index]} className="guest-input" />
                                                                      <button
                                                                                    className="remove-btn"
                                                                                                  onClick={() => {
                                                                                                                  const updatedGuests = [...guests];
                                                                                                                                  updatedGuests.splice(index, 1);
                                                                                                                                                  setGuests(updatedGuests);
                                                                                                                                                                }}
                                                                                                                                                                            >
                                                                                                                                                                                          Remove
                                                                                                                                                                                                      </button>
                                                                                                                                                                                                                </li>
                                                                                                                                                                                                                        ))}
                                                                                                                                                                                                                              </ul>
                                                                                                                                                                                                                                  </div>
                                                                                                                                                                                                                                    );
                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                    export default App;