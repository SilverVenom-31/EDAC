"use strict";

exports.fsWrite = function (arr) {
  var fs = require("fs");

  fs.writeFile("test", arr[0], function (err) {
    if (err) {
      console.log(err);
    }
  });

  for (var i = 1; i < arr.length; i++) {
    fs.appendFile("test", "\n" + arr[i], function (err) {
      if (err) {
        return console.log(err);
      }
    });
  }
};