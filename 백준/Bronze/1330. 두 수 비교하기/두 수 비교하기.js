const fs = require('fs');

const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ").map(Number);

const [a, b] = [input[0], input[1]];

if(a > b) console.log(">");
else if(a < b) console.log("<");
else console.log("==");