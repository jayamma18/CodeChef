    // Directly set the active tab index based on the clicked header's index
    setActiveTabIndex(index);
  };

  return (
    <div className="App">
      <h1>Job Application Form</h1>
      {/* 2. Add the onTabClick prop and pass the handler */}
      <Tabs
        activeTabIndex={activeTabIndex}
        onNext={handleNext}
        onPrevious={handlePrevious}
        onTabClick={handleTabClick} // Pass the new handler function
      />
    </div>
  );
}

export default App;
  const handleTabClick = (index) => {
  
  // 1. Define handleTabClick function
    setActiveTabIndex((prevIndex) => Math.max(prevIndex - 1, 0));
  }; 

  const handlePrevious = () => {
  };
    setActiveTabIndex((prevIndex) => Math.min(prevIndex + 1, totalTabs - 1));