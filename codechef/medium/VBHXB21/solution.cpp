// Simulated API function
async function fetchUserData() {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        const success = Math.random() > 0.5;
        if (success) {
          resolve({ id: 123, name: "John Doe" });
        } else {
          reject("Failed to fetch user data.");
        }
      }, 50);
    });
  }
  
  // Async/Await version
  async function getUserDataAsyncAwait() {
    try {
      const userData = await fetchUserData();
      console.log("Async/Await → User data:", userData);
    } catch (error) {
      console.error("Async/Await → Error fetching user data:", error);
    }
  }
  
  // Promise .then/.catch version
  function getUserDataPromise() {
    fetchUserData()
      .then(userData => {
        console.log("Promise → User data:", userData);
      })
      .catch(error => {
        console.error("Promise → Error fetching user data:", error);
      });
  }
  
  // Callback-based simulation
  function fetchUserDataCallback(callback) {
    setTimeout(() => {
      const success = Math.random() > 0.5;
      if (success) {
        callback(null, { id: 123, name: "John Doe" });
      } else {