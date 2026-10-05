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