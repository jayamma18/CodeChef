if (!isNaN(parsedAge)) {
setUser(prev => ({ ...prev, age: parsedAge }));
setAgeInput("");
}
};
const updateCity = () => {
if (cityInput.trim() !== "") {
setUser(prev => ({
...prev,
address: { ...prev.address, city: cityInput }
}));
setCityInput("");
}
};
return (
<div className="profile-container">
<p>Name: {user.name}</p>
<p>Age: {user.age}</p>
<p>Address: {user.address.city}, {user.address.country}</p>
<div className="input-group">
<input
type="text"
placeholder={`Current name: ${user.name}`}
value={nameInput}
onChange={(e) => setNameInput(e.target.value)}
/>
<button onClick={updateName}>Update Name</button>
</div>
<div className="input-group">