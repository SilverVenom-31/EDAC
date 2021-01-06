"use strict";

//Created by @Akhil on 26/11/20.
exports.rdFile = function (filePath, callback) {
  var fs = require("fs");

  var sum = 0;
  fs.readFile(filePath, function (err, data) {
    if (err) {
      console.log(err);
    } else {
      var arr = data.toString().split("\n");

      for (var i = 0; i < arr.length; i++) {
        var arr1 = arr[i].split(":");
        sum = parseInt(arr1[3]) + sum;
      }

      console.log("Sum of salary is: " + sum);
      callback(sum);
    }
  });
};