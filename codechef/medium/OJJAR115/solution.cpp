
const handleSubmit = async (e) => {
e.preventDefault();
if (!username.trim()) return;

setIsLoading(true);
setError('');
setProfileData(null);

try {
const response = await fetch(`https://api.github.com/users/${username}`);
if (!response.ok) {
throw new Error('Error: User not found');
}
const data = await response.json();
setProfileData(data);
} catch (err) {
setError('Error: User not found');
} finally {
setIsLoading(false);
}
};

return (
<div className="container">
<form onSubmit={handleSubmit}>
<input
type="text"
placeholder="Enter GitHub username"
value={username}
onChange={(e) => setUsername(e.target.value)}
style={{ padding: '8px', marginRight: '8px' }}
/>
<button type="submit">Search</button>
</form>

{isLoading && <p>Loading...</p>}

{error && <p style={{ color: 'red' }}>{error}</p>}

{profileData && (
<div style={{ marginTop: '1rem' }}>
<img
src={profileData.avatar_url}
alt="User's GitHub profile picture"
style={{ width: '100px', borderRadius: '50%' }}
/>
<h2>{profileData.name || profileData.login}</h2>
{profileData.bio && <p>{profileData.bio}</p>}
<p>Followers: {profileData.followers}</p>
</div>
)}
</div>
);
}

export default GitHubProfileFinder;