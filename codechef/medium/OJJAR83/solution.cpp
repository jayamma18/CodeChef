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