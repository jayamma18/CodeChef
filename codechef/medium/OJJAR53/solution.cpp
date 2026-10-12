import React from 'react';
export function App() {
const username = "Chef";
const currentYear = new Date().getFullYear();
return (
<div>
Welcome, {username}! Happy {currentYear}!
</div>
);