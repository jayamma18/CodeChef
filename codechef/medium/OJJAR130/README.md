# OJJAR130

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Smarter State Management

Great thinking on the last question! We correctly identified that when sending form data to a backend, it's best to bundle it all together. Our current `handleFormSubmit` function already creates a nice object with all our form data right before logging it.

So far in our `Tabs.jsx` component, we've created a separate `useState` variable for  *every single input field* :

- useState for fullName
- useState for email
- useState for phone
-...and so on for all 9 fields!

We also created a separate handler function for each one (`handleNameChange`, `handleEmailChange`, etc.). This works, but imagine if our form had 20 or 30 fields! That would be a lot of `useState` lines and a lot of similar-looking handler functions.

 **Think about it:**  When we submit the form, we gather all these separate pieces of data into  *one object*  to log it. What if we could store all our form data in  *one object in our state*  from the very beginning?

This approach has a couple of nice benefits:

- Less Code: We'd only need one useState call for all our form data.
- Simpler Updates: We might be able to use one main function to handle changes for most of our input fields.
- Data Ready: Our form data in the state would always look like that single bundle we want to send to a backend.

 **Your Task: Refactor to a Single Form Data State Object** 

Your mission is to refactor the `Tabs.js` component to manage all its form data using a single state object. You'll also create a more generic input change handler.

 **Specifically, within `Tabs.jsx` you need to:** 

- Define a Single State for Form Data: Remove all the individual useState calls for fullName, email, phone, address, jobTitle, company, yearsExperience, and skills. (Keep useState for agreeTerms and isSubmitted separate for now, as agreeTerms is a boolean and often handled slightly differently, and isSubmitted controls UI flow). Create one useState variable called formData. Initialize formData to an object containing all these fields with their initial values (e.g., fullName: '', email: '', yearsExperience: '0-1', etc.).
- Create a Generic Input Change Handler: Remove all the individual handler functions (handleNameChange, handleEmailChange, etc., except handleAgreeTermsChange and handleFormSubmit). Create a new, single function called handleInputChange. This function will be used by most of your input fields. Inside handleInputChange(e): Get the name and value from e.target. (The name attribute on your input HTML elements will be very important here!) Update the formData state. You'll need to use the setFormData function. Hint: When updating an object in state, you need to make sure you don't lose the other properties. You'll want to spread the previous state (...prevData) and then update the specific property that changed using its name. setFormData(prevData => ({...prevData, [name]: value })); (The [name] syntax is called "computed property names" and is key here!)
- Update Input Fields in JSX: For each text input, textarea, and select element: Change its value prop to get the data from the formData object (e.g., value={formData.fullName}). Change its onChange prop to call your new generic handleInputChange function (e.g., onChange={handleInputChange}). Crucially, ensure each of these input elements has a name attribute that exactly matches the property key in your formData object (e.g., <input name="fullName"... />).
- Update Data Display in Review Tab: Modify the "Review & Submit" tab to display values from formData.fullName, formData.email, etc.
- Update handleFormSubmit: When logging the data in handleFormSubmit, you can now directly log the formData object (and agreeTerms if you're logging it too).

 **Keep `agreeTerms` and `isSubmitted` as they are for this task.**  The checkbox for `agreeTerms` uses `e.target.checked` which makes its handler slightly different from typical text inputs, and `isSubmitted` controls a different aspect of the component's behavior.

This refactor will make your code cleaner and is a very common pattern in React forms!

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T08:58:26.448Z  

```cpp
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
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR130)