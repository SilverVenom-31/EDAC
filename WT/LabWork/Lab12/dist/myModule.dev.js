"use strict";

exports.factorial = function (x) {
  var fact = 1;

  for (var i = 1; i <= x; i++) {
    fact = fact * i;
  }

  return fact;
};

exports.myPrime = function (x) {
  if (x != 2 || x != 3 || x != 5 || x != 7) {
    if (x % 2 == 0 || x % 3 == 0 || x % 5 == 0 || x % 7 == 0) {
      console.log("Not a Prime Number");
    } else {
      console.log("Number is Prime Number");
    }
  } else {
    console.log("Number is Prime Number");
  }
};

exports.printTable = function (x) {
  for (var i = 1; i <= 10; i++) {
    console.log(x * i);
  }
};