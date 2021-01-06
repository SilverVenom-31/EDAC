exports.greet = () => {
    let dateTime = require('node-datetime');
    var dt = dateTime.create();
    var format = dt.format('H');

    if (format >= 6 && format < 12) {
        return ("Good Morning Friend");
    } else if (format >= 12 && format < 18) {
        return ("Good Afternoon Friend");

    } else if (format >= 18 && format < 24) {
        return ("Good Evening Friend");
    }

}