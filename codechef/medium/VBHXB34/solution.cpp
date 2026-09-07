function runImmediate() {
  setImmediate(() => {
    console.log("setImmediate executed");
  });
}

function runTimeout() {
  setTimeout(() => {
    console.log("setTimeout executed");
  }, 1000);
}

function runLimitedInterval() {
  let count = 0;
  const intervalId = setInterval(() => {
    count++;
    console.log(`setInterval run ${count}`);
    if (count === 2) {
      clearInterval(intervalId);
    }
  }, 500);
}

module.exports = {
  runImmediate,
  runTimeout,
  runLimitedInterval,
};

if (require.main === module) {