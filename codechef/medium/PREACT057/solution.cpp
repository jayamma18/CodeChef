      width: window.innerWidth,
          height: window.innerHeight
            });

              useEffect(() => {
                  function handleResize() {
                        setWindowSize({
                                width: window.innerWidth,
                                        height: window.innerHeight
                                              });
                                                  }

                                                      window.addEventListener('resize', handleResize);