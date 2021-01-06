/*
-->Q13
var d = new Date();
var e = new Date("11/16/2020");
var f = new Date("12/31/2020");

var diff = f.getTime() - e.getTime();
var diffDay = diff / (1000 * 3600 * 24);


var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
var weekNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

document.write("Today is " + weekNames[d.getDay()] + ", " + d.getDate() + " " + monthNames[d.getMonth()] +
    " " + d.getFullYear() + ", Welcome, and Good Afternoon to you" + "<br>" + "Number of days left till end of year: " +
    diffDay);
*/

/*
//-- > Q14
var d = new Date(2012, 0, 03);



function getWeekDay(d) {

    var str = d.toString();


    var arr = str.split(" ");

    var str2 = arr[0];

    var str3 = str2.slice(0, 2);

    return str3.toUpperCase();
}


alert(getWeekDay(d));
*/
/* 
-- > Q15

var arr = [];
for (var i = 0; i < 6; i++) {
    arr[i] = prompt("Enter name of an employee");

}
arr.sort();


for (var i = 0; i < arr.length; i++) {
    document.write("<br>" + arr[i])
}

 */


/*
--Q16
var arr = [];
var status = 0;

for (var i = 0; i < 5; i++) {
    arr[i] = Math.floor(Math.random() * 50) + 1;
}


var inp = prompt("Enter a number");


if (inp >= 1 && inp <= 50) {


    for (var i = 0; i < arr.length; i++) {
        if (inp == arr[i]) {
            document.write("BINGO");

        } else {
            status++;
        }
    }
    if (status > 0) {
        document.write("Hardluck!!! Try again next time!!!");
    }


} else {
    alert("Please input in range of 1 to 50");
}
*/
/*
-->18
var arr = [];
var inp;
for (var i = 0; i < 5; i++) {

    arr[i] = prompt("Enter a word");


}

for (var i = 0; i < arr.length; i++) {
    arr[i] = arr[i].split("").reverse().join("").split(" ").reverse().join(" ");
}



arr.sort();
for (var i = 0; i < arr.length; i++) {

    document.write("<br>" + arr[i]);
}
*/