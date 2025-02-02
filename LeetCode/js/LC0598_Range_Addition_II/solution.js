/**
 * @param {number} m
 * @param {number} n
 * @param {number[][]} ops
 * @return {number}
 */
var maxCount = function(m, n, ops) {
    let mina = m, minb = n;
    for (let op of ops) {
        mina = Math.min(mina, op[0]);
        minb = Math.min(minb, op[1]);
    }
    return mina * minb;
};

function test() {
    console.log(maxCount(3, 3, [[2, 2], [3, 3]]));
}

test();