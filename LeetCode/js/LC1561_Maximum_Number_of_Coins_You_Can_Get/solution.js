/**
 * @param {number[]} piles
 * @return {number}
 */
var maxCoins = function (piles) {
    piles.sort();
    let sum = 0;
    for (let i = piles.length / 3; i < piles.length; i += 2) {
        sum += piles[i];
    }
    return sum;
};

// test
console.log(maxCoins([2, 4, 1, 2, 7, 8]));