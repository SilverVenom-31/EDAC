let a, b, c;
exports.isEquilateral = function(s1, s2, s3) {
    a = s1;
    b = s2;
    c = s3;

    if (s1 == s2 && s2 == s3 && s1 == s3) {
        return "It is an equilateral triangle";
    } else {
        return "It is not an equilateral triangle";

    }

}

exports.calcPerimeter = function() {
    return a + b + c;
}