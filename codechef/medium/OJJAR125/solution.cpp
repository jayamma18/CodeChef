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