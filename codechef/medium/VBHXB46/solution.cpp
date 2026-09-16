// write your code here

const fs = require('fs');
const path = require('path');

const inputFile = path.resolve(__dirname, 'words.txt');
const outputFile = path.resolve(__dirname, 'short_words.txt');

console.log('Reading words.txt...');

fs.readFile(inputFile, 'utf8', (err, data) => {
if (err) {
return console.error('Error reading file:', err);
}

const words = data.split('\n').map(word => word.trim());
const filtered = words.filter(word => word.length <= 5);
const result = filtered.join('\n');

console.log('Writing short words to short_words.txt...');

fs.writeFile(outputFile, result, 'utf8', (err) => {
if (err) {
return console.error('Error writing file:', err);
}

console.log('Short words written successfully!');
});
});