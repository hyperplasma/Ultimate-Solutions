/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function (candidates, target) {
    let res = [];
    candidates.sort((a, b) => a - b);
    backtrack(candidates, target, 0, [], res);
    return res;
};

function backtrack(candidates, target, start, path, res) {
    if (target === 0) {
        res.push([...path]);
        return;
    }
    for (let i = start; i < candidates.length; i++) {
        if (i > start && candidates[i] === candidates[i - 1]) {
            continue;
        }
        if (target - candidates[i] < 0) {
            break;
        }
        path.push(candidates[i]);
        backtrack(candidates, target - candidates[i], i + 1, path, res);
        path.pop();
    }
}

function test() {
    console.log(combinationSum2([10, 1, 2, 7, 6, 1, 5], 8));
}

test();