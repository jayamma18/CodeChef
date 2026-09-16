# VBHXB46

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Filter Long Words

You are given a file named `words.txt` containing a list of words, one word per line. Your task is to read this file asynchronously, filter out the words that have more than 5 letters, and then write the remaining words to a new file named `short_words.txt`.

Given the file named `words.txt` with the following content:

```
apple
banana
kiwi
orange
grape
fig
plum
date
strawberry
lime

```

### Task:
- Read the content of words.txt asynchronously.
- Split the content into an array of words (assuming each word is on a new line).
- Filter the array to keep only words that have 5 or fewer letters.
- Join the filtered array back into a string, with each word on a new line.
- Write the filtered string to short_words.txt asynchronously.

The terminal should show output given below:

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:25:55.701Z  

```cpp
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
```

---

[View on CodeChef](https://www.codechef.com/problems/VBHXB46)