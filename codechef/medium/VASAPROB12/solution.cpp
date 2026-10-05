db = connect('mongodb://localhost:27017/hr_db');

db.staff.drop();

const employees = [];
for (let i = 1; i <= 5000; i++) {
  employees.push({
      name: "Employee " + i,
          empId: 1000 + i,
              department: "Engineering"
                });
                }
                db.staff.insertMany(employees);

                const slowSearch = db.staff.find({ empId: 4500 }).explain("executionStats");
                print("Documents scanned before index: " + slowSearch.executionStats.totalDocsExamined);

                // YOUR TASK ---
                // Write the command to create a Single Field Index on 'empId' in Ascending order.

                // WRITE YOUR CODE HERE:
                db.staff.createIndex({ empId: 1 });

                const fastSearch = db.staff.find({ empId: 4500 }).explain("executionStats");
                print("Documents scanned after index: " + fastSearch.executionStats.totalDocsExamined);