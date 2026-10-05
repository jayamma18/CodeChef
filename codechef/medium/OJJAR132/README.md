# OJJAR132

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Implementing Navigation Guards & Final Submission

You've successfully set up the basic infrastructure for form validation! We now have:

- formErrors state to hold error messages.
- A validateField function to check individual field values.
- On-blur validation that provides immediate feedback for fullName, email, phone, and address.
- Error messages displayed below these fields on the "Personal Info" tab.
- Error messages being cleared as the user types or checks the "agreeTerms" box.

 **This Module: Preventing Invalid Navigation and Ensuring Full Form Validity on Submit**  Now, we'll complete the validation logic by:

- Preventing users from navigating to the next tab or clicking forward on tab headers if the current tab has validation errors.
- Ensuring all required fields across the entire form (including the "agree to terms" checkbox) are valid before allowing final submission.
- Displaying an error message for the "agree to terms" checkbox if submission is attempted without it being checked.

 **Your Task: Implement Tab Navigation Guards and Full Submission Validation** 

 **Specifically, within `Tabs.jsx` you need to:** 

- Create validateCurrentTabForNext Function: This function will check if all required fields on the current tab are valid. Tab 1 (Personal Info - activeTabIndex === 0): Validate fullName, email, and address using your validateField function. For phone, call validateField. An error here should only be considered "blocking" for navigation if the phone field is filled but invalid. If it's empty, it's fine since it's optional. If any blocking errors are found (for required fields, or for phone if filled and invalid): Update the formErrors state with all errors found on this tab (even non-blocking ones like an empty optional phone field having its error cleared). Return false. If no blocking errors, update formErrors (to clear any previous errors for fields now valid or to set new non-blocking errors for optional fields like phone) and return true. Tab 2 (Experience - activeTabIndex === 1): This tab has no required fields for navigation to the review tab, so this function can simply return true if activeTabIndex === 1.
- Guard "Next" Button Logic (Modify handleNextClick): In handleNextClick, before calling onNext(): Call validateCurrentTabForNext(). Only call onNext() if validateCurrentTabForNext() returns true.
- Guard Direct Tab Clicks (Modify handleTabHeaderClick) (Step 7 from original task): In handleTabHeaderClick(targetIndex): If the user is trying to move forward (targetIndex > activeTabIndex): Call validateCurrentTabForNext() for the current active tab. If it returns false (invalid), then return; to prevent the onTabClick(targetIndex) call. If moving backward or if moving forward and the current tab is valid, proceed to call onTabClick(targetIndex).
- Create validateAllFieldsForSubmit Function: This function validates all fields required for final submission. Validate fullName, email, address. Validate phone only if it has a value (to check its format). Validate agreeTerms by calling validateField('agreeTerms', agreeTerms). Collect all errors found. Update formErrors state with these errors. Return true if no errors were found for these required fields (and phone if filled). Otherwise, return false.
- Update handleFormSubmit: At the beginning of handleFormSubmit: Call validateAllFieldsForSubmit(). Only proceed to log data and call setIsSubmitted(true) if validateAllFieldsForSubmit() returns true. Optionally, if validation fails, you can console.log a message like "Form has validation errors. Please correct them." and log the formErrors object.
- Display Error Message for "Agree to Terms": On the "Review & Submit" tab (activeTabIndex === 2), below the "agreeTerms" checkbox and its label, conditionally render a <span> with className="error-message" to display formErrors.agreeTerms. It's good practice to style it to be noticeable (e.g., display: 'block', marginTop: '5px').

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T09:03:51.316Z  

```cpp
<h2>Experience</h2>
<div className="form-section">
<label>Job Title:</label>
<input type="text" name="jobTitle" value={formData.jobTitle} onChange={handleInputChange} />
</div>
<div className="form-section">
<label>Company:</label>
<input type="text" name="company" value={formData.company} onChange={handleInputChange} />
</div>
</div>
)}
{activeTabIndex === 2 && (
<div>
<h2>Review Your Application</h2>
<p><strong>Full Name:</strong> {formData.fullName || "Not Provided"}</p>
<p><strong>Email:</strong> {formData.email || "Not Provided"}</p>
<p><strong>Phone:</strong> {formData.phone || "Not Provided"}</p>
<p><strong>Address:</strong> {formData.address || "Not Provided"}</p>
<div className="form-section">
<label>
<input type="checkbox" name="agreeTerms" checked={formData.agreeTerms} onChange={handleInputChange} onBlur={handleBlur} />
I agree to terms *
</label>
{formErrors.agreeTerms && <p className="error" style={{color:'red'}}>{formErrors.agreeTerms}</p>}
</div>
</div>
)}
</div>
<div className="tab-navigation">
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR132)