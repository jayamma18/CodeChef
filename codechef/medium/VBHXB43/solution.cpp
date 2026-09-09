const initialFilePath = path.resolve(__dirname, initialFileName);
const organizedFilePath = path.resolve(__dirname, organizedFileName);

// Check if file exists, create if it doesn't
if (!fs.existsSync(initialFilePath)) {
    fs.writeFileSync(initialFilePath, "");
        console.log(`Created new file: ${initialFileName}`);
        }

        // Append text
        fs.appendFileSync(initialFilePath, "File organized!");
        console.log(`Appended "File organized!" to ${initialFileName}`);

        // Rename the file
        fs.renameSync(initialFilePath, organizedFilePath);
        console.log(`File renamed to ${organizedFileName}`);