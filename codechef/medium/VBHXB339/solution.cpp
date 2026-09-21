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