// function that takes three arguments
function sum(num1, num2 , num3) {
    console.log(num1 + num2 + num3);
}

let num1 = [1, 3, 4, 5];

// pass the first three array elements
sum(...num1); 

// Output: 8
