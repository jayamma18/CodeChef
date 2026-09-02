
function addToppings(frozenIceCream) {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve("Ice cream with toppings: " + frozenIceCream);
      }, 500);
    });
  }

// Your code starts here: Create the Promise chain that calls these functions in order.
console.log("Ice cream making in progress...");
     .then((ingredients) => {
getIngredients()
      console.log(ingredients);
      return mixIngredients(ingredients);
    })
     .then((mixedIngredients)=>{
      console.log(mixedIngredients);
      return freezeMixture(mixedIngredients);
    })
     .then((frozenIceCream)=>{
      console.log(frozenIceCream);
      return addToppings(frozenIceCream);
    })
     .then((result)=>{
      console.log(result);
    })
     .catch((error)=>{
      console.log(error);
    })