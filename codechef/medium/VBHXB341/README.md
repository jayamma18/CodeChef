# VBHXB341

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Implementing Blog Editing

Implement the "Update" functionality for an existing blog application, allowing users to securely edit their own blog posts.

 **Objective:** 
Enable users to:

- Fetch an existing blog's data.
- Display the data in an editable form.
- Submit updates to the backend API.
- Redirect to the "My Blogs" page upon successful save.

 **Context:** 

- Backend: User and Blog models are already defined. authenticateToken and authorizeOwner middlewares are in place.
- Frontend: AuthContext, an API utility (with token interceptor), PrivateRoute (using <Outlet />), and BlogCard components exist. The "Edit" button in BlogCard already links to /edit/:id.
#### Tasks:

 **Part 1: Backend (API Routes)** 

- GET /api/blogs/:id: Retrieve a single blog post by its ID. Populate the author.username field. Return a 404 status if the blog is not found.
- PUT /api/blogs/:id: Secure this route with authenticateToken and authorizeOwner middlewares. Update the title and content fields of the blog post if they are provided in the request body. Save the changes to the database. Return the updated blog post, with the author field populated.

 **Part 2: Frontend (`EditBlog` Page)** 

- Load Blog Data: In EditBlog.jsx, extract the blog id from the URL using useParams. Fetch the blog's data using API.get("/blogs/:id") within a useEffect hook. Pre-fill the form fields (title and content) with the fetched blog data.
- Authorization Check: Compare the fetched blog's author._id with the currently logged-in user.id (from AuthContext). If the user is not the owner, display an error message (e.g., "Not authorized to edit this blog").
- Handle Form Submission: On form submission, call API.put("/blogs/:id", { title, content }) to send the updated data to the backend. Implement a loading state (e.g., "Updating..."). Upon successful update, redirect the user to /my-blogs. On error, display an appropriate error message to the user.

 **Other Improvements:** 

- Implement visual error and loading states in the UI.
- Ensure the edit form utilizes consistent CSS classes (form-container, blog-form) for a unified look.

 **Your App should be work like this**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-21T08:49:01.462Z  

```cpp
                    <input
                        type="text"
                        id="title"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                        required
                    />
                </div>

                {/* Input group for Content (textarea) */}
                <div className="form-group">
                    <label htmlFor="content">Content:</label>
                    <textarea
                        id="content"
                        value={content}
                        onChange={(e) => setContent(e.target.value)}
                        required
                        rows="10"
                    ></textarea>
                </div>

                {/* Display error message if the error state is not empty */}
                {error && <p className="error-message">{error}</p>}

                {/* Submit button: disabled when submitting, and text changes */}
                <button type="submit" disabled={submitting}>
                    {submitting ? 'Updating...' : 'Update Blog'}
                </button>
            </form>
        </div>
    );
};

export default EditBlog;
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB341)