# VBHXB328

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Displaying Blog Posts on the Homepage

Alright, let's continue building out the frontend. We've got the navigation in place, and now it's time to display some actual content on our homepage!

 **Objective:**  To display a list of blog posts on the homepage (`/`) using provided dummy data. This involves completing the `Home` and `BlogCard` React components to render the blog information.

 **Context:** 

- You've already set up the basic React application along with the Navbar component.
- We then updated your App.jsx file by adding routing logic so that the Home component is rendered when the user visits the root path (/). Here's the relevant part of the code: // In frontend/src/App.js <Routes> <Route path="/" element={<Home />} /> </Routes>

This ensures that whenever a user navigates to the base URL of your application, the `Home` component will be displayed.

 **Task:** 

Using the provided template code for `Home.js` and `BlogCard.js`, complete the following:

- In frontend/src/pages/Home.js: Inside the main div with className="container", add a heading (e.g., <h1>Recent Blogs</h1>) to introduce the blog list. Within the div that has className="blog-list", use the already provided blogs state (which is initialized with initialBlogsData) to map over it. For each blog object in the blogs array, render a BlogCard component. Remember to pass the blog object as a prop and assign a unique key (e.g., blog._id). The conditional rendering for "No blogs available..." is already in place; ensure your mapping logic is within the else part of that condition.
- In frontend/src/components/BlogCard.js: Inside the div with className="blog-card", display the following information for the blog prop it receives: The blog.title (e.g., using an <h2> tag). The blog.author (e.g., within a p tag with className="blog-author"). The blog.createdAt value. You can use the provided formatDate helper function to display it in a user-friendly format (e.g., Published on Month Day, Year). Place this in a p tag with className="blog-date". A snippet of the blog.content. Truncate it to, for example, the first 150 characters, and add "..." at the end to indicate more content is available. Place this in a p tag with className="blog-content".
 **Click to get the BlogCard.css!** 

 **Your App should be look like this at the end**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-19T10:48:58.284Z  

```cpp
    },
    {
        _id: 'blog2',
        title: 'Mastering CSS Flexbox',
        content: 'A comprehensive guide to CSS Flexbox, your ultimate tool for laying out content. Learn how to align, justify, and distribute items efficiently.',
        author: 'Bob The Builder',
        createdAt: new Date(Date.now() - 86400000 * 2).toISOString() // 2 days ago
    },
    {
        _id: 'blog3',
        title: 'JavaScript Async/Await Explained',
        content: 'Demystifying asynchronous JavaScript with async/await. Write cleaner, more readable async code and avoid callback hell.',
        author: 'Charlie Chaplin',
        createdAt: new Date(Date.now() - 86400000 * 1).toISOString() // 1 day ago
    }
];

const Home = () => { 
    const [blogs, setBlogs] = useState(initialBlogsData);
    
    return (
        <div className="container">
            <h1>All Blogs</h1>
            <div className="blog-list">
                {blogs.length === 0 ? (
                    <p>No blogs available yet. Be the first to create one!</p>
                ) : (
                    blogs.map(blog => (
                        <BlogCard key={blog._id} blog={blog} />
                    ))
                )}
            </div>
        </div>
    );
};

export default Home;
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB328)