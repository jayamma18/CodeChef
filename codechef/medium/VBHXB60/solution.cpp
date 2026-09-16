// write your code here
const http = require('http');

const USERNAME = 'Harry';

const server = http.createServer((req, res) => {
let greeting = 'Hello, Guest!';

if (typeof USERNAME === 'string' && USERNAME.trim() !== '') {
greeting = `Hello, ${USERNAME.trim()}!`;
}

res.writeHead(200, { 'Content-Type': 'text/plain' });
res.write(greeting);
res.end();
});

server.listen(3000, () => {
console.log('Server is running on port 3000');
});