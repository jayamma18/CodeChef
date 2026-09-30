import { useState, memo, useCallback } from 'react';
import './App.css';

// Memoized child component
const ChildButton = memo(function ({ onClick }) {
  console.log('Child rendered!');
    return (
        <button className="child-button" onClick={onClick}>
              Increment Counter
                  </button>
                    );
                    });

                    function Parent() {