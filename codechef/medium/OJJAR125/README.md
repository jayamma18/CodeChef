# OJJAR125

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Populating the Personal Info Tab

You've successfully set up the basic structure of your `Tabs.jsx` component with clickable tab headers and navigation buttons ("Previous" / "Next"). Currently, each tab displays simple placeholder text.

 **This Module: Building the First Form Section - Personal Information**  Our goal is to start building the actual form content. In this first step, we'll focus  *only*  on the "Personal Info" tab (Tab 0). We will replace its placeholder text with the necessary HTML form fields (`input`, `textarea`) to collect a user's personal details.

 **Important:**  For this task, we are only concerned with adding the static HTML structure within the JSX.  **Do not**  add `value` or `onChange` props to any of the input or textarea elements yet.

 **Your Task: Add Static Form Fields to the "Personal Info" Tab** 

To begin, open your `Tabs.jsx` file and locate the `tab-content` section. Inside this section, find the conditional rendering block where `activeTabIndex === 0`. Within this block, remove the placeholder paragraph (e.g., `<p>Content for the personal info tab goes here.</p>`).as you’ll now replace it with the actual form fields and supporting content outlined in the steps below.

- Add Heading and Intro: Keep or re-add the <h2>Personal Information</h2>. Add the introductory paragraph: <p>Please provide your contact details. Fields marked with * are required.</p>
- Add Form Fields for Personal Info: Within the div for activeTabIndex === 0, add the following, ensuring each label/input pair is wrapped in a <div className="form-section">: Full Name: A <label htmlFor="fullName"> with the text "Full Name:  *". An <input type="text" id="fullName" name="fullName" />. Email Address: A <label htmlFor="email"> with the text "Email Address:* ". An <input type="email" id="email" name="email" />. Phone Number: A <label htmlFor="phone"> with the text "Phone Number (Optional):". An <input type="tel" id="phone" name="phone" />. Address: A <label htmlFor="address"> with the text "Address: *". A <textarea id="address" name="address" rows="3"></textarea>.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-25T08:20:27.514Z  

```cpp
<div>
<label htmlFor="phone">Phone</label>
<input type="tel" id="phone" name="phone" />
</div>
<div>
<label htmlFor="address">Address</label>
<input type="text" id="address" name="address" />
</div>
</form>
</div>
)}

{activeTabIndex === 1 && (
<div>
<h2>Work Experience & Skills</h2>
<p>Content for the experience tab goes here.</p>
</div>
)}

{activeTabIndex === 2 && (
<div>
<h2>Review Your Application</h2>
<p>Content for the review tab goes here.</p>
</div>
)}
</div>

<div className="tab-navigation">
<button onClick={onPrevious} disabled={isFirstTab}>
Previous
</button>
<button onClick={onNext} disabled={isLastTab}>
Next
</button>
</div>
</div>
);
}

export default Tabs;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR125)