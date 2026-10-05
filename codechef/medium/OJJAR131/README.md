# OJJAR131

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Validation Infrastructure and On-Blur Feedback

Our form now uses a single `formData` object and a generic `handleInputChange`. The submission process is integrated, but it lacks any checks on the data quality.

 **This Module: Laying the Groundwork for Validation & Immediate Feedback**  We're starting to implement validation. In this first part, we'll:

- Set up the state to store error messages.
- Create a core function to validate individual fields.
- Implement "on-blur" validation, so users get immediate feedback when they move out of a field if they've made an error.
- Ensure error messages are cleared when the user starts correcting an input.
- Display these error messages next to the respective fields on the "Personal Info" tab.

 **Provided Regular Expressions:** 

```
const EMAIL_REGEX = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const PHONE_REGEX = /^[+]?[(]?[0-9]{3}[)]?[-\s.]?[0-9]{3}[-\s.]?[0-9]{4,6}$/;

```

 **Your Task: Implement Basic Validation State, Field Validator, and On-Blur Logic** 

 **Specifically, within `Tabs.jsx` you need to:** 

- Define Initial Error State: Above your Tabs component, define an initialFormErrors object. It should have keys: fullName, email, phone, address, and agreeTerms, all initialized to null. Create the formErrors state variable using useState, initialized with initialFormErrors.
- Create a validateField Function: This function takes name (of the field) and value as arguments. Implement the validation rules: fullName: Required. If empty or value.trim().length <= 2 (let's use 2 for "less than 3"), return "Please enter a valid Name.". email: Required. If empty or doesn't match EMAIL_REGEX, return "Please enter a valid email address." phone: Optional. If a value is present but doesn't match PHONE_REGEX, return "Please enter a valid phone number." address: Required. If empty or value.trim().length <= 4 (let's use 4 for "less than 5"), return "Please provide your full address.". agreeTerms: If value is false (when called with name 'agreeTerms'), return "You must agree to the terms and conditions." Note: Please write the error message properly; otherwise, you will get the wrong answer. If a field is valid according to its rules, the function should return null.
- Implement On-Blur Validation (handleBlur): Modify the handleBlur(e) function. When a user leaves (blurs) fullName, email, address, or phone fields: Get the name and value from e.target. Call validateField(name, value) to get any error. Update formErrors state for that specific field: setFormErrors(prevErrors => ({...prevErrors, [name]: error })); Attach this handleBlur function to the onBlur event of the fullName, email, phone, and address input fields.
- Update handleInputChange and handleAgreeTermsChange to Clear Errors: In handleInputChange: When formData is updated for a field, if formErrors[name] exists, clear it by setting formErrors[name] to null. In handleAgreeTermsChange: If agreeTerms becomes true and formErrors.agreeTerms exists, clear it by setting formErrors.agreeTerms to null.
- Display Error Messages in JSX for Tab 1: For the "Personal Info" tab (activeTabIndex === 0), below each of the input fields (fullName, email, phone, address), conditionally render a <span> with className="error-message" to display the corresponding error message from formErrors. Example: {formErrors.fullName && <span className="error-message">{formErrors.fullName}</span>}

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T09:00:40.751Z  

```cpp
<option value="10+">10+ Years</option>
</select>
</div>
<div className="form-section">
<label htmlFor="skills">Skills:</label>
<textarea id="skills" name="skills" value={formData.skills} onChange={handleInputChange}></textarea>
</div>
</div>
)}
{activeTabIndex === 2 && (
<div>
<h2>Review Your Application</h2>
<div className="review-section">
<p><strong>Full Name:</strong> {formData.fullName || <em>Not Provided</em>}</p>
<p><strong>Email:</strong> {formData.email || <em>Not Provided</em>}</p>
<p><strong>Phone:</strong> {formData.phone || <em>Not Provided</em>}</p>
<p><strong>Address:</strong> {formData.address || <em>Not Provided</em>}</p>
</div>
<div className="form-section terms-section">
<label htmlFor="agreeTerms">
<input type="checkbox" id="agreeTerms" name="agreeTerms" checked={agreeTerms} onChange={handleAgreeTermsChange} onBlur={handleAgreeTermsBlur} />
I confirm that the information provided is accurate
</label>
{formErrors.agreeTerms && <p className="error-message" style={{color:'red'}}>{formErrors.agreeTerms}</p>}
</div>
</div>
)}
</div>
<div className="tab-navigation">
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR131)