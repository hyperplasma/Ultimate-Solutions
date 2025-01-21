/**
 * @param {number[][]} piles
 * @param {number} k
 * @return {number}
 */
var maxValueOfCoins = function (piles, k) {
    let f = new Array(k + 1).fill(-1);
    f[0] = 0;
    for (let pile of piles) {
        for (let i = k; i > 0; --i) {
            let value = 0;
            for (let t = 1; t <= pile.length; t++) {
                value += pile[t - 1];
                if (i >= t && f[i - t] !== -1) {
                    f[i] = Math.max(f[i], f[i - t] + value);
                }
            }
        }
    }
    return f[k];
};

// test
console.log(maxValueOfCoins([[1, 100, 3], [7, 8, 9]], 2));