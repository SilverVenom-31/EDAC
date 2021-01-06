"use strict";

var http = require("http");

var fs = require("fs");

var serv = http.createServer(function (req, res) {
  if (req.method === "GET" && req.url === "/") {
    res.writeHead(200, {
      "Content-type": "text/html"
    });
    fs.createReadStream("./Wel.html").pipe(res);
  } else {
    res.writeHead(404, {
      "Content-type": "text/plain"
    });
    res.end("Page not found");
  }
});
serv.listen(5000, "127.0.0.1");
console.log("Server is running on : http://127.0.0.1:5000/");