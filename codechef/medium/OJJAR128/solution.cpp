import React, { useState } from 'react';
import Tabs from './Tabs';
import './App.css';

function App() {
const [activeTabIndex, setActiveTabIndex] = useState(0);
const totalTabs = 3;