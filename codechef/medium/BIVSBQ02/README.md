# BIVSBQ02

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Library Access Control

You are building a simple management system for a library. The system has two types of users: 'librarians' and 'members'.

In this code we implement the core logic for  **authentication**  and  **authorization**  based on a user's role.

#### What we are doing in this code:
- Authentication: In the handleLogin function, you must verify if the provided username and password match a user in our mock users database. This is checking "Who are you?".
- Authorization: In the isLibrarian function, you must check if a given user has the 'librarian' role. This function will be used to protect actions that only librarians can perform, like adding a new book. This is checking "What are you allowed to do?".
#### Task:

Complete the blank in the code to check if the user is librarian or not.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-03T06:58:20.225Z  

```cpp
const users = [
  { username: 'alice', password: 'pass123', role: 'librarian' },
  { username: 'bob', password: 'mypassword', role: 'member' },
  { username: 'charlie', password: 'abc123', role: 'member' },
  ];

  // Authentication: verifies username and password
  function handleLogin(username, password) {
  // Find user by username
  const user = users.find(u => u.username === username);
  if (!user) {
  return null; // user not found
  }
  // Check password
  if (user.password === password) {
  return user; // successful login returns user object
  }
  return null; // wrong password
  }

  // Authorization: checks if user is librarian
  function isLibrarian(user) {
  return user && user.role === 'librarian';
  }

  // Example usage:
  const loggedInUser = handleLogin('alice', 'pass123');
  if (loggedInUser) {
  console.log(`Welcome, ${loggedInUser.username}!`);
  if (isLibrarian(loggedInUser)) {
  console.log('You can add new books.');
  } else {
  console.log('You can browse and borrow books.');
  }
  } else {
  console.log('Invalid username or password.');
  }

```

---

[View on CodeChef](https://www.codechef.com/problems/BIVSBQ02)