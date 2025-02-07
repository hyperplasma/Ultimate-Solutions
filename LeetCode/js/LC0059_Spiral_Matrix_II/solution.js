/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function (n) {
    let res = new Array(n).fill(0).map(() => new Array(n).fill(0));
    let cur = 1;

    let i = 0, j = 0;
    while (cur <= n * n) {
        while (j < n && res[i][j] === 0) {
            res[i][j++] = cur++;
        }
        j--;
        i++;
        while (i < n && res[i][j] === 0) {
            res[i++][j] = cur++;
        }
        i--;
        j--;
        while (j >= 0 && res[i][j] === 0) {
            res[i][j--] = cur++;
        }
        j++;
        i--;
        while (i >= 0 && res[i][j] === 0) {
            res[i--][j] = cur++;
        }
        i++;
        j++;
    }
    return res;
};

function test() {
    console.log(generateMatrix(3));
    console.log(generateMatrix(1));
}

test();