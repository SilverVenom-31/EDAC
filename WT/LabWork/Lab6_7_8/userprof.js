function snd() {
    let obj = new Object();
    obj.name = document.getElementById("t1").value;


    if (typeof obj.name != "string") {
        alert("Only alphabets are alowed in Name field");
        return 0;
    }


    obj.bmon = document.getElementById("m1").value;
    obj.bdate = document.getElementById("n1").value;
    obj.byr = document.getElementById("n2").value;
    obj.email = document.getElementById("e1").value;


    if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(obj.email)) {
        document.getElementById("s1").innerHTML = "";

    } else {
        document.getElementById("s1").innerHTML = "(Use format name@company.com)";

    }


    if (document.getElementById("rx1").checked) {

        obj.gender = document.getElementById("rx1").value;
    } else {
        obj.gender = document.getElementById("rx2").value;

    }

    obj.luckyNo = parseInt(document.getElementById("t2").value);

    if (obj.luckyNo < 1 || obj.luckyNo > 100) {
        document.getElementById("s2").innerHTML = "(A number between 1 to 100)";
        return 0;
    } else {
        document.getElementById("s2").innerHTML = "";
    }


    obj.favfood = "";
    if (document.getElementById("cx1").checked) {

        obj.favfood = document.getElementById("cx1").value;

    }

    if (document.getElementById("cx2").checked) {

        obj.favfood = obj.favfood + " " + document.getElementById("cx2").value;

    }
    if (document.getElementById("cx3").checked) {

        obj.favfood = obj.favfood + " " + document.getElementById("cx3").value;

    }


    document.getElementById("p1").innerHTML = ("You entered: <br> Name: " + obj.name + "<br> Birth Date: " + obj.bmon + "/" + obj.bdate + "/" + obj.byr + "<br> Email Address: " + obj.email + "<br> Gender: " + obj.gender + "<br> Lucky Number: " + obj.luckyNo + "<br> Favourite Food: " + obj.favfood);


    var win = window.open();

    win.document.write("<p>You entered: <br> Name: " + obj.name + "<br> Birth Date: " + obj.bmon + "/" + obj.bdate + "/" + obj.byr + "<br> Email Address: " + obj.email + "<br> Gender: " + obj.gender + "<br> Lucky Number: " + obj.luckyNo + "<br> Favourite Food: " + obj.favfood + "</p>");



    return 1;
}