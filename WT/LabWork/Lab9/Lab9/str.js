var str = prompt("Enter any number");
var arr = str.split("");
var x = 0;
var sum = 0;

for (var i = 0; i < arr.length; i++) {
    x = str % 10;
    sum = x + sum;
    str = parseInt(str / 10);
}

document.write(sum);