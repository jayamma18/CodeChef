// Synchronous message
console.log("Order placed!");
// Asynchronous operation with 2-second delay
setTimeout(() => {
    console.log("Confirming order...")
},2000);
// Synchronous message continues immediately
console.log("Order confirmed!");