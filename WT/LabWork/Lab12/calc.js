 exports.add = function(a, b) {
     return a + b;

 }
 exports.sub = function(a, b) {
     return a - b;

 }
 exports.multiply = function(a, b) {
     return a * b;
 }
 exports.divide = function(a, b) {
     if (b != 0) {
         return a / b;
     }
 }
 exports.square = function(a) {
     return a * a;

 }

 exports.sum = function() {
     let s = 0;
     for (let i = 0; i < arguments.length; i++) {
         s = arguments[i] + s;
     }
     return s;
 }