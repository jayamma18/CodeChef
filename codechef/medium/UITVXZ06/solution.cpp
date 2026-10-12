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