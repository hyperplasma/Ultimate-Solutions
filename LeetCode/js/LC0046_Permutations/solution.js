/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
    let res = [];
    let output = [];
    for (let num of nums) {
        output.push(num);
    }

    const backtrack = (cur, n, output, res) => {
        if (cur === n) {
            res.push([...output]);
            return;
        }

        for (let i = cur; i < n; i++) {
            [output[cur], output[i]] = [output[i], output[cur]];
            backtrack(cur + 1, n, output, res);
            [output[cur], output[i]] = [output[i], output[cur]];
        }
    };

    backtrack(0, nums.length, output, res);
    return res;
};

function test() {
    console.log(permute([1, 2, 3]));
    console.log(permute([0, 1]));
}

test();