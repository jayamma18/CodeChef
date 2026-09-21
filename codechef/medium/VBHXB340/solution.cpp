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