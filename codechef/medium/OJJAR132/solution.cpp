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