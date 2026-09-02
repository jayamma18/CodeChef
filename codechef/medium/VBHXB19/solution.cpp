}

async function prepareSandwich() {
  // Your code here
  const bread=await prepareBread();
  const filling=await addFilling();
  console.log(bread);
  console.log(filling);
  const Sandwich=await wrapSandwich();
  console.log(Sandwich);
  return "Sandwich is ready to eat!";
}

prepareSandwich().then(result => console.log(result));
      resolve("Sandwich wrapped!");
    }, 500); // Simulate wrapping for 0.5 seconds
  });
    setTimeout(() => {
      resolve("Filling added!");
    }, 2000); // Simulate adding filling for 2 seconds
  });
}

function wrapSandwich() {
  return new Promise(resolve => {
    setTimeout(() => {