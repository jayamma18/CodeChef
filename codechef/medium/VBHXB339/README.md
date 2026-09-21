# VBHXB339

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Displaying User-Specific Blogs on My Blogs Page

Our Navbar now reflects login status. Next, make the  **"My Blogs"**  page functional by fetching and showing blogs of the logged-in user.

 **Objective:** 
Implement "My Blogs" so users see only their posts by creating a user-specific backend API and integrating it with the frontend  **`MyBlogs`**  component, ensuring  **`BlogCard`**  displays dynamic data.

 **Task:** 
Your task is to implement the "My Blogs" functionality from end to end:

 **Part 1: Backend API for Fetching User's Blogs** 

- Add Route to backend/routes/blog.js: Define a new GET route for /me. Apply the authenticateToken middleware to this route, as only the logged-in user's blogs should be fetched. Inside the route handler, use Blog.find() to query for blogs where the author field matches req.user.id (the ID of the authenticated user from the JWT). Crucially: Use populate('author', 'username') with your Mongoose query. This will replace the author ObjectId with the actual User object, allowing the frontend to easily display the author's username. Send a 200 (OK) status response with the array of fetched blogs. Include a try...catch block for error handling.

 **Part 2: Frontend "My Blogs" Page Implementation** 

- Implement "My Blogs" Page (frontend/src/pages/MyBlogs.jsx): Remove the placeholder content from MyBlogs.jsx. Use React's useState hook to manage the blogs array, loading status, and error messages. Initialize blogs as an empty array ([]). Use the useEffect hook to perform an asynchronous data fetch when the component mounts. Inside useEffect: Set loading to true. Use your API utility (API.get('/blogs/me')) to fetch the current user's blogs from the backend. On success, update the blogs state with the received data. On failure, catch the error and set the error state. Ensure loading is set back to false in a finally block. Conditionally render: A loading message (<div>Loading your blogs...</div>) if loading is true. An error message (<div>Error:...</div>) if error is present. If blogs array is empty after loading, display a friendly message like "You haven't created any blogs yet. Create one now!" with a link to /create. Otherwise, map over the blogs array and render a BlogCard component for each, passing the blog object as a prop and assigning a unique key. Remove any hardcoded dummy data from this component.
- Update BlogCard Component (frontend/src/components/BlogCard.jsx): The backend will now send blog.author as an object {_id: '...', username: '...'} (because of populate). Adjust where you display the author's name in BlogCard.jsx. Instead of blog.author, you will now use blog.author.username. (Optional but good to note): The existing isOwner check (user.id === blog.author._id) in the BlogCard template you had from Problem 8 will now correctly work with the populated author object.

 **Your App should be work like this**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T08:45:19.303Z  

```cpp
        }
    };

    // useEffect hook to fetch user-specific blogs when the component mounts
    useEffect(() => {
        fetchMyBlogs();
    }, []); 

    // Conditional rendering for loading, error, and no blogs
    if (loading) return <div className="container">Loading your blogs...</div>;
    if (error) return <div className="container error-message">{error}</div>;

    return (
        <div className="container">
            <h1>My Blogs</h1>
            <div className="blog-list">
                {/* Render message if no blogs are found for the user */}
                {blogs.length === 0 ? (
                    <p>You haven't created any blogs yet. <Link to="/create">Create one now!</Link></p>
                ) : (
                    // Map over the blogs array to render BlogCard components
                    blogs.map(blog => (
                        <BlogCard
                            key={blog._id}
                            blog={blog}
                        />
                    ))
                )}
            </div>
        </div>
    );
};

export default MyBlogs;
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB339)