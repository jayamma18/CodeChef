import React from 'react';
import './App.css';

function CustomInput({ label, id, ...rest }) {
  const generatedId = React.useId();
    const finalId = id || generatedId;

      return (
          <div className="custom-input">
                <label htmlFor={finalId}>{label}</label>
                      <input 
                              id={finalId}
                                      {...rest}
                                            />
                                                </div>
                                                  );
                                                  }

                                                  export default CustomInput;