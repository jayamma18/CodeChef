const fs = require('fs');

const initialFilePath = 'file.txt';
const renamedFilePath = 'newFile.txt';

// Check if the initial file exists
if () {
    // Create the file if it doesn't exist
    try {
        fs.writeFileSync(initialFilePath, ''); // creates an empty file
        console.log('File created successfully!');
    } catch (err) {
        console.error('Error creating file:', err);
    }
} else {
    console.log('File already exists!');
}