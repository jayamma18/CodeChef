        const fetchBlogs = async () => {
            try {
                const res = await API.get('/blogs'); // ✅ backend route to get all blogs
                setBlogs(res.data);
            } catch (error) {
                console.error('Error fetching blogs:', error);
            } finally {
                setLoading(false);
            }
        };

        fetchBlogs();
    }, []);

    return (
        <div className="container">
            <h1>All Blogs</h1>
            <div className="blog-list">
                {loading ? (
                    <p>Loading blogs...</p>
                ) : blogs.length === 0 ? (
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
