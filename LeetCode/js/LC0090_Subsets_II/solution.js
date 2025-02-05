/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function (nums) {
    nums.sort((a, b) => a - b);
    let res = [];
    const dfs = (choosePre, cur, nums, path) => {
        if (cur === nums.length) {
            res.push(path.slice());
            return;
        }
        dfs(false, cur + 1, nums, path);
        if (!choosePre && cur > 0 && nums[cur - 1] === nums[cur]) {
            return;
        }
        path.push(nums[cur]);
        dfs(true, cur + 1, nums, path);
        path.pop();
    };
    dfs(false, 0, nums, []);
    return res;
};

function test() {
    console.log(subsetsWithDup([1, 2, 2]));
    console.log(subsetsWithDup([0]));
}

test();