function grindBeans() {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve("Ground coffee beans");
      }, 500);
    });
  }
  
  function brewCoffee(groundBeans) {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve("Brewed coffee with " + groundBeans);
      }, 500);
    });
  }
  
  function addMilk(brewedCoffee) {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve("Coffee with milk: " + brewedCoffee);
      }, 500);
    });
  }
  
  grindBeans()
    .then((groundBeans) => {
      console.log("1. Beans ground:", groundBeans);
      return brewCoffee(groundBeans);
    })
    .then((brewedCoffee) => {