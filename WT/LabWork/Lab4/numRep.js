var num1 = window.prompt("enter first number");
var num2 = window.prompt("Enter second number: ");
var op = window.prompt("Enter +,-,/,* operation: ");

var num = 4;

var str = "Bravo"


for (var i = 0; i < num; i++) {
    document.write(str + "\n");
    document.write("<br>");
}
var i = 0;
while (i<= num) {

    if (i % 2 == 0) {
        document.write(i);
    }
    i++;

    
}
document.write("<br>");


var num3;
switch (op) {
    case '+':
        num3 = +num2 + +num1;
        document.write(num3);
        break;

    case '-':
        num3 = +num1 - +num2;
        document.write(num3);
        break;

    case '/':
        num3 = num1 / num2;
        document.write(num3);
        break;
    case '*':
        num3 = num2 * num1;
        document.write(num3);
        break;
    default:
        alert("Invalid operation");

}
