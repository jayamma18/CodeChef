const fs = require('fs');

fs.readFile('my_missing_file.txt', 'utf8', (err, data) => {
if (err) {
console.error('Error: File not found!');
console.error(err.message);
} else {
console.log('File read successfully:');
console.log(data);
}
});
