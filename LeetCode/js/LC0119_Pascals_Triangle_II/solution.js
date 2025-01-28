/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function(rowIndex) {
    let row = [1];
    for (let i = 1; i <= rowIndex; ++i) {
        row.push((row[i - 1] * (rowIndex - i + 1)) / i);
    }
    return row;
};

function test() {
    console.log(getRow(3));
}

test();