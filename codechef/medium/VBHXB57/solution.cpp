const http = require('http');

// Function to get the appropriate greeting based on current hour
function getGreeting() {
const now = new Date();
const hour = now.getHours();

if (hour < 12) {
return "Good morning!";
} else if (hour >= 12 && hour < 18) {
return "Good afternoon!";
} else {
return "Good evening!";
}
}

// Create the HTTP server
const server = http.createServer((req, res) => {
res.writeHead(200, { 'Content-Type': 'text/plain' });
res.end(getGreeting());
});

// Start the server on port 3000
server.listen(3000, () => {
console.log('Server running on port 3000');
});

// will be taught in future lessons
module.exports = server;