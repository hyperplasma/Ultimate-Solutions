/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
    let res = [];
    let dfs = function (cur, path) {
        if (cur === nums.length) {
            res.push(path.slice());
            return;
        }
        path.push(nums[cur]);
        dfs(cur + 1, path);
        path.pop();
        dfs(cur + 1, path);
    }
    dfs(0, []);
    return res;
};

function test() {
    console.log(subsets([1, 2, 3]));
    console.log(subsets([0]));
}

test();