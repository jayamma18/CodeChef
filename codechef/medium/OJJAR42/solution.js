let names = ["John", "Emily", "Michael", "Sara", "Chris", "Kate"];
let shortNames = names.filter((name) => {
    return name.length <= 5;
});
console.log(shortNames);
