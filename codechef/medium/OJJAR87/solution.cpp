import React, { useState } from "react";

export default function App() {
  const [fruit, setFruit] = useState('banana');

    return (
        <>
              <select
                      value={fruit}
                              onChange={(e) => setFruit(e.target.value)}
                                    >
                                            <option value="apple">Apple</option>
                                                    <option value="banana">Banana</option>
                                                          </select>

                                                                <p>You have selected: <strong>{fruit}</strong>.</p>
                                                                    </>
                                                                      );
                                                                      }