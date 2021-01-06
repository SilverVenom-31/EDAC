"use strict";

//Created by @Akhil on 26/11/20.
var read = require("./readFile");

read.rdFile("emp.txt", function (result) {
  console.log("Sum of salary is in client side: " + result);
});