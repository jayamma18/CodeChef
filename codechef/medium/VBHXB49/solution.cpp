const path = require('path');

// 1. Construct relative path
const relativePath = path.join('books', 'fiction', 'The_Great_Novel.pdf');

// 2. Convert to absolute path
const originalAbsolutePath = path.resolve(relativePath);

// 3. Extract directory and filename, change extension to .epub
const dir = path.dirname(originalAbsolutePath);
const nameWithoutExt = path.basename(originalAbsolutePath, '.pdf');
const newFileName = `${nameWithoutExt}.epub`;
const newAbsolutePath = path.join(dir, newFileName);

// 4. Print results
console.log('Original Absolute Path:', originalAbsolutePath);
console.log('New Absolute Path:', newAbsolutePath);// write your code here
