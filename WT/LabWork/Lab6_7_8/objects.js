/*

---Q17
var rect = function(len, bread) {
    this.length = len;
    this.breadth = bread;


    var area = this.length * this.breadth;
    var peri = +this.length + +this.breadth;

    document.write("area: " + area);
    document.write("Perimeter: " + peri);

}


var circle = function(radius) {
    var area = Math.PI * radius * radius;
    var peri = radius;

    document.write("area: " + area);
    document.write("Perimeter: " + peri);

}
rect(4, 5);
circle(4);
*/




-- > Q19.Create an array that holds 4 employee objects and displays each emp detail in a table.
Emp details could be empid, empname and salary.
Use
for each loop to inspect all properties of each object

var arr = [];

function emp(empId, empName, empSal) {

    if ((empSal === undefined) || (empName === undefined) || (empId === undefined)) {
        alert("enter all records of employee");
    }

    this.empId = empId;
    this.empName = empName;
    this.empSal = empSal;

    this.dispDet = function() {
        document.write("Employee ID: " + this.empId + "<br>" +
            "Employee Name: " + this.empName + "<br>" +
            "Employee Salary: " + this.empSal + "<br>");

    };
}

arr[0] = new emp(101, "Initial", 2000);
arr[1] = new emp(102, "Actual", 3000);
arr[2] = new emp(103, "Final", 4000);
arr[3] = new emp(104, "Valid", 5000);


arr.forEach(function() {
    this.dispDet();
});






/*
function disp() {
    this.radius = document.getElementById("t1").value;

    document.getElementById("s1").innerHTML = Math.round(Math.PI * this.radius * this.radius);
    document.getElementById("s2").innerHTML = Math.round(2 * Math.PI * this.radius);
}*/