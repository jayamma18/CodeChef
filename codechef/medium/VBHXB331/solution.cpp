// 1. Import the express library
import express from 'express';

// 2. Initialize the Express application
const app = express();

// 3. Define the PORT number
// Remember, for consistency, we're using PORT 8080 for the backend.
const PORT = 8080;

// 4. Create a basic route for the root URL ('/')
// When someone visits your backend's base URL, it should send a simple message.
 app.get('/', (req, res) => {