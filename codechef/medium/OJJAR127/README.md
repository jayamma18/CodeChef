# OJJAR127

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Create States and Handlers

Now, Your mission is to modify the `Tabs.jsx` component to capture, store, and manage user input for  *all remaining*  form fields. You will also update the "Review & Submit" tab to display this captured information.

 **Specifically, within `Tabs.jsx` you need to:** 

- Import useState from 'react'.
- For each of the following fields, create its own state variable and dedicated change handler function: Full Name (fullName): State variable (e.g., fullName, setFullName), initialized to ''. Handler function (e.g., handleFullNameChange). Email Address (email): State variable (e.g., email, setemail), initialized to ''. Handler function (e.g., handleEmailChange). Phone Number (phone): State variable (e.g., phone, setPhone), initialized to ''. Handler function (e.g., handlePhoneChange). Address (address): State variable (e.g., address, setAddress), initialized to ''. Handler function (e.g., handleAddressChange). Most Recent Job Title (jobTitle): State variable (e.g., jobTitle, setJobTitle), initialized to ''. Handler function (e.g., handleJobTitleChange). Company Name (company): State variable (e.g., company, setCompany), initialized to ''. Handler function (e.g., handleCompanyChange). Years of Relevant Experience (yearsExperience): State variable (e.g., yearsExperience, setYearsExperience), initialized to '0-1' (the default selected value). Handler function (e.g., handleYearsExperienceChange). Key Skills (skills): State variable (e.g., skills, setSkills), initialized to ''. Handler function (e.g., handleSkillsChange). Agree to Terms (agreeTerms): State variable (e.g., agreeTerms, setAgreeTerms), initialized to false. Handler function (e.g., handleAgreeTermsChange). Remember, for checkboxes, you'll use e.target.checked instead of e.target.value.
- Connect these state variables and handlers to their respective input elements in the JSX: For text inputs and textareas: set the value prop to the state variable and the onChange prop to the handler function. For the select element: set the value prop to the state variable and the onChange prop to the handler function. For the checkbox: set the checked prop to the state variable and the onChange prop to the handler function.
- Update the "Review & Submit" tab: Modify the placeholder text (e.g., [Data Will Go Here]) to display the actual values from the corresponding state variables you've created (phone, address, jobTitle, company, yearsExperience, skills). If a field is optional and empty, you might display "Not Provided" or a similar message.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T09:36:32.600Z  

```cpp
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            <p>Most Recent Job Title: {jobTitle}</p>
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR127)