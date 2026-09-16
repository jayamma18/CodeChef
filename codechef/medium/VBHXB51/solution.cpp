const fs = require('fs');
const path = require('path');

const dirName = 'my_directory';

fs.mkdir(dirName, { recursive: true }, (err) => {
if (err) {
return console.error('Error creating directory:', err);
}

console.log(`Directory "${dirName}" created successfully.`);

fs.readdir('.', (err, files) => {
if (err) {
return console.error('Error reading current directory:', err);
}

console.log('Contents of current directory:');
files.forEach(file => {
console.log(file);
});
});
});
