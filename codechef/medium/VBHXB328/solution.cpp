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