function disp() {
    var ordDet = new Object();
    ordDet.ordId = document.getElementById("t1").value;
    ordDet.custName = document.getElementById("t2").value;
    ordDet.billDate = document.getElementById("d1").value;
    ordDet.shipDate = document.getElementById("d2").value;
    ordDet.ordTot = document.getElementById("t3").value;

    if (ordDet.custName.length <= 5) {

        document.getElementById("s1").innerHTML = "Customer name cannot be <6 characters";
        return 0;
    } else {
        document.getElementById("s1").innerHTML = "";
    }
    if (ordDet.shipDate < ordDet.billDate) {

        document.getElementById("s2").innerHTML = "Billing date cannot be greater than shipping date";
        return 0;
    } else {
        document.getElementById("s2").innerHTML = "";
    }

    var win = window.open("", "", "height=200,width=200");

    win.document.write('<p>Order id: ' + ordDet.ordId + '</p> <p>Customer Name: ' + ordDet.custName + '</p><p>Billing Date: ' + ordDet.billDate + '</p> <p>Shipping Date: ' + ordDet.shipDate + '</p> <p>Order Total: Rs.' + ordDet.ordTot + '</p>');

    return 1;
}