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