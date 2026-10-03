import { useState } from 'react';
import './App.css';
import Layout from './components/Layout';
import UserContext from './UserContext';
import ThemeContext from './ThemeContext';

function App() {
const [theme, setTheme] = useState('light');
const [user] = useState({ name: 'Sarah' });

const toggleTheme = () => {
setTheme((prevTheme) => (prevTheme === 'light' ? 'dark' : 'light'));
};

return (
<UserContext.Provider value={user}>
<ThemeContext.Provider value={{ theme, toggleTheme }}>
<div className={`app ${theme}`}>
<Layout />
</div>
</ThemeContext.Provider>
</UserContext.Provider>
);
}

export default App;