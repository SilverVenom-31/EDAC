"use strict";

exports.palindrome = function (str) {
  var st = str.split("").reverse().join("");

  if (st == str) {
    return "String is palindrome";
  } else {
    return "string is not palindrome";
  }
};

exports.upper = function (str) {
  return str.toUpperCase();
};

exports.urls = function (str) {
  var arr = ["www.google.com", "www.msn.com", "www.amazon.co.in", "answers.yahoo.com", "en.m.wikipedia.com", "codehs.gitbooks.io", "www.coderanch.com"];

  for (var i = 0; i < arr.length; i++) {
    if (arr[i].includes(str)) {
      console.log("arr[i]");
    }
  }
};