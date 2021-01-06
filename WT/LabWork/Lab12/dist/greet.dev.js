"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.greet = greet;

function greet() {
  var dateTime = require('node-datetime');

  var dt = dateTime.create();
  var format = dt.format('H');

  if (format >= 6 && format < 12) {
    console.log("Good Morning Friend");
  } else if (format >= 12 && format < 18) {
    console.log("Good Afternoon Friend");
  } else if (format >= 18 && format < 24) {
    console.log("Good Evening Friend");
  }
}