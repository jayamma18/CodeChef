function runCountdown() {
    setImmediate(() => {
        console.log("Countdown is starting...");
            let seconds = 3;
                const intervalId = setInterval(() => {
                      console.log(`${seconds} seconds left`);
                            seconds--;
                                  if (seconds === 0) {
                                          clearInterval(intervalId);
                                                  setTimeout(() => {
                                                            console.log("Countdown complete!");
                                                                    }, 1000);
                                                                          }
                                                                              }, 1000);
                                                                                });
                                                                                }

                                                                                module.exports = { runCountdown };
                                                                                if (require.main === module) {
                                                                                  runCountdown();
                                                                                  }
