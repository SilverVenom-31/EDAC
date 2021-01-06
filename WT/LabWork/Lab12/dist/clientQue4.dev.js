"use strict";

var cir = require("./circle");

var rect = require("./rectangle");

var tri = require("./triangle");

console.log(cir.calcArea(4));
console.log(cir.calcCircumference(4));
console.log(cir.calcDiameter(4));
console.log(rect.calcArea(4, 3));
console.log(rect.calcPerimeter(4, 3));
console.log(tri.isEquilateral(4, 4, 4));
console.log(tri.calcPerimeter());