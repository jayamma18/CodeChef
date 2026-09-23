
return (
<form className="simple-form" onSubmit={handleSubmit}>
<label htmlFor={`${uniqueId}-name`}>Name:</label>
<input
id={`${uniqueId}-name`}
type="text"
value={name}
onChange={(e) => setName(e.target.value)}
/>
<label htmlFor={`${uniqueId}-email`}>Email:</label>
<input
id={`${uniqueId}-email`}
type="email"
value={email}
onChange={(e) => setEmail(e.target.value)}
/>
<button type="submit">Submit</button>
</form>
);
}

export default SimpleForm;