# OJJAR115

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### GitHub Profile Finder App

Create a simple React application that lets users search for GitHub profiles using the GitHub API. Follow these steps:

#### Step 1: Set Up Component Structure

Create a functional component  **`GitHubProfileFinder`**  with:

- State variables for username, profile, loading, and error
- A form with an input field and a submit button
- Conditional rendering for loading/error states
#### Step 2: Implement API Fetch

Use GitHub's API:  **`https://api.github.com/users/{username}`**  Example response:

```
{
  "login": "octocat",
  "name": "The Octocat",
  "avatar_url": "https://...",
  "bio": "A mysterious creature",
  "followers": 42
}

```

#### Step 3: Display Profile Data
- Show these properties when available: Profile picture (avatar_url) Name (name) or username (login) Bio (bio) Number of followers (followers)
- Display "Error: User not found" when no user is found.
#### your app should be look like this
#### Hints
- How to fetch data

```
// Fetch user data from GitHub API  
const response = await fetch(`https://api.github.com/users/${username}`);

// Throw an error if the user is not found  
if (!response.ok) throw new Error('User not found');  

// Parse response as JSON  
const data = await response.json();

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T10:27:45.577Z  

```cpp

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
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR115)