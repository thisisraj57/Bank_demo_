sentence = "Java is to JavaScript what Car is to Carpet.";

let check = sentence.startsWith("Java");
console.log(check); // true

let check1 = sentence.startsWith("Java is");
console.log(check1); // true

// case sensitive
let check2 = sentence.startsWith("JavaScript");
console.log(check2); // false

// second argument specifies the starting position
let check3 = sentence.startsWith("JavaScript", 11);
console.log(check3); // true
