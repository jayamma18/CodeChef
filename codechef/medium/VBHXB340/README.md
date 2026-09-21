# VBHXB340

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Implementing Blog Deletion

Okay, we're making fantastic progress! Users can register, log in, and even create their own blog posts, which are then correctly displayed on their "My Blogs" page. Now, let's empower them further by allowing them to  **delete**  their own blog posts.

This is a critical full-stack feature, requiring both a backend API endpoint and frontend integration with proper authorization.

 **Objective:**  To enable logged-in users to delete  *only*  their own blog posts. This involves creating a secure backend API endpoint for deletion and integrating it with the "My Blogs" page and the `BlogCard` component on the frontend.

 **Context:** 

- Your backend has User and Blog models, and authenticateToken middleware is in place.
- Your frontend MyBlogs.jsx currently displays the logged-in user's blogs using BlogCard.jsx.
- The BlogCard.jsx already has isOwner logic to determine if the current user is the author, which is crucial for showing the delete button.

 **Task:** 

Your task is to implement the "Delete Blog" functionality across both frontend and backend:

 **Part 1: Backend API for Blog Deletion** 

- Enhance Authentication Middleware (backend/middleware/authMiddleware.js): Import the Blog model into this file. Define a new middleware function called authorizeOwner. This middleware should: Accept req, res, next. Fetch the blog post by id from req.params.id. If the blog is not found, send a 404 (Not Found) status. Check if blog.author.toString() matches req.user.id. If they don't match, send a 403 (Forbidden) status, as the user is not the owner. If they match, call next() to proceed. Include a try...catch block. Export this new authorizeOwner middleware alongside authenticateToken.
- Add Delete Route (backend/routes/blog.js): Define a new DELETE route at /:id. Apply both authenticateToken and authorizeOwner middleware to this route. This ensures the user is logged in and is the owner of the blog they are trying to delete. Inside the route handler: Find the blog by ID using Blog.findById(req.params.id). (The authorizeOwner middleware already ensures ownership, so just finding it is enough here.) If not found (though authorizeOwner should ideally prevent this if called first), send a 404 status. Delete the blog from the database using blog.deleteOne(). Send a 200 (OK) status response with a success message (e.g., Blog removed). Include a try...catch block.

 **Part 2: Frontend "My Blogs" Page & BlogCard Integration** 

- Implement Delete Functionality in MyBlogs.jsx (frontend/src/pages/MyBlogs.jsx): Add an async function named handleDelete that takes blogId as an argument. Inside handleDelete: (Optional but recommended): Add a window.confirm() dialog to ask the user for confirmation before deleting. Call API.delete(/blogs/${blogId}) to send the delete request to your backend. On success, update the blogs state in MyBlogs.jsx using setBlogs and the filter method (blogs.filter(blog => blog._id !== blogId)) to remove the deleted blog from the UI immediately without reloading the page. On failure, catch the error and set an appropriate error message. Pass this handleDelete function as a prop (onDelete) to the BlogCard components when mapping over blogs.
- Activate Delete Button in BlogCard.jsx (frontend/src/components/BlogCard.jsx): Ensure BlogCard is receiving the onDelete prop. Locate the "Delete" button within the isOwner conditional block. Add an onClick handler to this button that calls onDelete(blog._id).

 **Your App should be work like this**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T08:48:13.058Z  

```cpp
                await API.delete(`/blogs/${id}`); // Call backend DELETE API
                setBlogs(blogs.filter(blog => blog._id !== id)); // Update UI by filtering out the deleted blog
            } catch (err) {
                setError(err.response?.data?.message || 'Failed to delete blog.');
                console.error('Error deleting blog:', err);
            }
        }
    };


    if (loading) return <div className="container">Loading your blogs...</div>;
    if (error) return <div className="container error-message">{error}</div>;

    return (
        <div className="container">
            <h1>My Blogs</h1>
            <div className="blog-list">
                {blogs.length === 0 ? (
                    <p>You haven't created any blogs yet. <Link to="/create">Create one now!</Link></p>
                ) : (
                    blogs.map(blog => (
                        <BlogCard
                            key={blog._id}
                            blog={blog}
                            onDelete={handleDelete} // Pass handleDelete as onDelete prop
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

[View on CodeChef](https://www.codechef.com/problems/VBHXB340)