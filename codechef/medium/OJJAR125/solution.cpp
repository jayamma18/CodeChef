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