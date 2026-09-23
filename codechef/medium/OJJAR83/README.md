# OJJAR83

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Build a Temperature Converter in React

Complete the given template code by implementing a Temperature Converter in React. The converter should allow users to:

- Increase the temperature.
- Decrease the temperature.
- Convert between Celsius (°C) and Fahrenheit (°F).

Your app should be look like this

 **What You Need to Implement:** 

- State Variables: temperature: A number storing the current temperature value. unit: A string storing the current unit ("C" or "F").
- Function to Convert Temperature: Implement the convertTemperature() function. If the unit is "C", convert it to Fahrenheit using: $F = \left(\frac{C \times 9}{5}\right) + 32$ If the unit is "F", convert it to Celsius using: $C = \left(\frac{F - 32}{9}\right) \times 5$
- Temperature Display Show temperature with 2 decimal places using.toFixed(2) Display unit symbol (°C or °F) using a <span>
- Buttons for Interaction: Increase temperature by 1 when the first button is clicked. (button name should be Increase) Decrease temperature by 1 when the second button is clicked. (button name should be Decrease) Convert temperature between Celsius and Fahrenheit when the third button is clicked. (The button name should be "Convert to Celsius", and for degrees Celsius, it should be "Convert to Fahrenheit")

 **Example Flow:** 

- User sees "25.00°C"
- Clicks "Convert to Fahrenheit" → shows "77.00°F"
- Clicks Increase → shows "78.00°F"
- Clicks "Convert to Celsius" → shows "25.56°C"

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T07:08:51.453Z  

```cpp
import React, { useState } from 'react';
import styles from './App.module.css';
export function Temperature({ defaultTemperature = 0 }) {
const [temperature, setTemperature] = useState(defaultTemperature);
const [unit, setUnit] = useState('C');
const handleConvert = () => {
if (unit === 'C') {
setTemperature((temperature * 9) / 5 + 32);
setUnit('F');
} else {
setTemperature(((temperature - 32) * 5) / 9);
setUnit('C');
}
};
return (
<div className={styles.wrapper}>
<h1>Temperature Converter</h1>
<div className={styles.display}>
{temperature.toFixed(2)}°{unit}
</div>
<div className={styles.controls}>
<button onClick={() => setTemperature(temperature + 1)}>Increase</button>
<button onClick={() => setTemperature(temperature - 1)}>Decrease</button>
<button onClick={handleConvert}>
{unit === 'C' ? 'Convert to Fahrenheit' : 'Convert to Celsius'}
</button>
</div>
</div>
);
}
export default function App() {
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR83)