# UITVXZ06

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Create and read operations practice

In this practice, you will apply what you've learned by performing  **Create**  and  **Read**  operations using the  **Student model**  you've already defined earlier.

We will use the existing schema to:

- Insert new student documents into the MongoDB Atlas database.
- Retrieve all students using a.find() query.
- (Optional) Retrieve a specific student by their _id using.findById().
### Reminder: Student Schema

This is the same schema you created earlier:

```
const studentSchema = new mongoose.Schema({
  fullName: String,
  studentId: String,
  major: String,
  enrollmentDate: Date
});

```

You’ve also created a model using:

```
const Student = mongoose.model('Student', studentSchema);

```

This student schema is stored in `/models/student.js` and we are importing it in this `index.js` file.

### Your Task

You don’t need to redefine the schema or model — it's already in place. Your job now is to: Just add your MongoDB URI.

### Expected Outcome

When you run your script:

- A new student will be inserted into your database.
- All students will be printed to the console.
- (Optional) A specific student will be fetched using their _id.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-12T10:52:31.909Z  

```cpp
                                                                                                                                }
                                                                                                                                }

        useUnifiedTopology: true
        }).then(() => {
            console.log('✅ Connected to MongoDB Atlas!');
                console.log('✅ Student Model Imported Successfully!');
                    console.log('📛 Model Name:', Student.modelName);
                        runPractice();
                        }).catch(err => {
                            console.error('❌ MongoDB Atlas connection error:', err);
                            });

                            // Create Operation
                            async function createStudent() {
                                try {
                                        const newStudent = new Student({
                                                    fullName: 'George Hotz',
                                                                studentId: '01',
                                                                            major: 'Computer Science',
                                                                                        enrollmentDate: new Date('2021-08-01')
                                                                                                });

                                                                                                        const savedStudent = await newStudent.save();
                                                                                                                console.log('📝 Student Created:', savedStudent);
                                                                                                                    } catch (error) {
                                                                                                                            console.error('❌ Error creating student:', error);
const mongoose = require('mongoose');
const Student = require('./models/student');

// MongoDB Atlas Connection URI
const MONGODB_URI = 'mongodb+srv://lakshyatagarapu_db_user:lucky@cluster0.u1ahsol.mongodb.net/?appName=Cluster0';

// Connect to MongoDB and run practice
mongoose.connect(MONGODB_URI, {
    useNewUrlParser: true,
```

---

[View on CodeChef](https://www.codechef.com/problems/UITVXZ06)