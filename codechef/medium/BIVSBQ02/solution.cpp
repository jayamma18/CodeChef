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
