/*var num = 2;

for (var i = 1; i <= 10; i++) {
    document.write(num + " * " + i + " = " + num * i);
    document.write("<br>");

}
==============================================

var str = "55555";

var num2 = 0;


for (var i = 0; i < str.length; i++) {
    num2 = +str.charAt(i) + +num2;

}
document.write(num2);
document.write("<br>");
=====================================================
-->Q6.
var char = [];
var num3 = window.prompt("number");

for (var i = 0; i < num3.length; i++) {
    char[i] = num3.charAt(i);
}

var temp;



for (var i = 0; i < char.length; i++) {
    for (var j = i + 1; j < char.length; j++) {
        if (char[i] > char[j]) {
            temp = char[i];
            char[i] = char[j];
            char[j] = temp;


        }
    }
}
document.write("<br>");

document.write(char[0]);
=========================================================
*/
/*  --->Q7
var dist = window.prompt("Enter distance in inches");


document.write(dist * 2.54 + " cms");
*/
//===============================================
//Q8.
/*function power(x, p) {

    var s = 1;
    for (var i = 0; i < p; i++) {
        s = x * s;
    }
    return s;

}

var z = power(2, 3);
document.write(z);*/

/*
var arg = window.prompt("enter argumnent of integers");

var char = [];

for (var i = 0; i < arg.length; i++) {
    char[i] = arg.charAt(i);
}

var m = 0;
for (var i = 0; i < char.length; i++) {
    m = +char[i] + +m;
}

var a = m / char.length;

document.write("Sum: " + m);
document.write("Avg: " + a);*/

/*---->Q10
var even = window.prompt("enter N");
var e = 0;
for (var i = 0; i <= even; i++) {
    if (i % 2 == 0) {
        //   document.write(i * i);
        document.write("<br>");
        e = (i * i) + +e;


    }
}
document.write("Sum of even numbers: " + e);*/

//=============================================================
/*  --->>Q11.
var j = 0;
var k = 1;

document.write(j);
document.write(k);
var h = window.prompt(" enter n for fibonacci series: ");

for (var i = 0; i < h - 2; i++) {
    var l = +j + +k;

    j = k;
    k = l;
    document.write(l);
}*/
/*
var carName = document.getElementById("test").value;
document.write(carName);*/
//=================================================================
//Q12.
var principle = window.prompt("Principle");

var rate = prompt("rate");
var period = prompt("Period");


var f = Math.pow((+1 + (rate / 100)), period);

var ci = (principle * f) - principle;
document.getElementById("princi").innerHTML = principle;
document.getElementById("rate").innerHTML = rate;
document.getElementById("period").innerHTML = period;
document.getElementById("ci").innerHTML = ci;