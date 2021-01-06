//Created by @Akhil on 26/11/20.
exports.rdFile = (filePath, callback) => {
    const fs = require("fs");
    let sum = 0;
    fs.readFile(filePath, (err, data) => {
        if (err) {
            console.log(err);
        } else {
            let arr = data.toString().split("\n");

            for (let i = 0; i < arr.length; i++) {
                let arr1 = arr[i].split(":");
                sum = parseInt(arr1[3]) + sum;
            }
            console.log("Sum of salary is: " + sum);
            callback(sum);
        }
    });
}