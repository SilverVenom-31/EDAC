exports.fsWrite = (arr) => {

    const fs = require("fs");

    fs.writeFile("test", arr[0], err => {
        if (err) {
            console.log(err);
        }
    });

    for (let i = 1; i < arr.length; i++) {
        fs.appendFile("test", "\n" + arr[i], err => {
            if (err) {
                return console.log(err);
            }
        });
    }
}