"use strict";

var fs = require("fs");

fs.stat("emp.txt", function (err, stats) {
  if (err) console.log(err.code + "Error Message : " + err.message);
  fs.open("emp.txt", "r", function (err, fd) {
    if (err) {
      return console.error(err);
    }

    var buffer = Buffer.alloc(stats.size);
    fs.read(fd, buffer, 0, buffer.length, 0, function (error, bytes) {
      if (error) console.log("Write Error : " + error.message);

      if (bytes > 0) {
        var data = buffer.toString().split("\n");
        console.log(buffer.toString());
        var sum = 0;
        console.log("data lenght: " + data.length);

        for (var i = 0; i < data.length; i++) {
          var arr = data[i].split(":");
          sum = parseInt(arr[3]) + sum;
        }

        console.log("Sum of salary is: " + sum);
      }
    });
  });
});