const path = require('path');

// 1. Construct the file path
const reportsDir = 'reports';
const yearDir = '2024';
const fileName = 'sales.txt';

// Use path.join() to create the full file path
const relativePath = path.join(reportsDir, yearDir, fileName);

// 2. Resolve to absolute path
const absolutePath = path.resolve(relativePath);

// 3. Extract and print information
const baseName = path.basename(absolutePath);
const extName = path.extname(absolutePath);
const dirName = path.dirname(absolutePath);

console.log('Relative Path:', relativePath);
console.log('Absolute Path:', absolutePath);
console.log('Base Name:', baseName);
console.log('Extension:', extName);
console.log('Directory Name:', dirName);
