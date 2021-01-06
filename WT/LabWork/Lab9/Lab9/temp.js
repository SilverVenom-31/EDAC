var arr = [];

function initTemp() {
    arr = [34.5, 32.4, 27.8, 45.2, 40.2];


}

function meanTemp() {

    initTemp();
    var sum = 0;
    for (var i = 0; i < arr.length; i++) {
        sum = arr[i] + sum
    }
    document.getElementById("p1").innerHTML = ("Mean of temperature: " + sum / arr.length);
}


function maxTemp() {
    initTemp();

    document.getElementById("p1").innerHTML = ("Max temperature: " + Math.max(...arr));
}

function minTemp() {
    initTemp();

    document.getElementById("p1").innerHTML = ("Min temperature: " + Math.min(...arr));
}

function dispTemp() {

    var sel = document.getElementById("sel");
    document.getElementById("p1").innerHTML = sel.value;
    switch (sel.value) {
        case 'meanTemp':
            meanTemp();
            break;
        case 'maxTemp':
            maxTemp();
            break;
        case 'minTemp':
            minTemp();
            break;
        case 'initTemp':
            initTemp();
            arr.sort();
            document.getElementById("p1").innerHTML = arr.join("<br>");
            break;


            break;
        default:
            document.getElementById("p1").innerHTML = "Please select correct option"

    }


}