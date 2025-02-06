/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
    let res = [];
    let path = [];
    const n = nums.length;
    let visited = new Array(n).fill(false);

    const backtrack = (cur) => {
        if (cur === n) {
            res.push([...path]);
            return;
        }

        for (let i = 0; i < n; i++) {
            if (visited[i] || (i > 0 && nums[i] === nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            path.push(nums[i]);
            backtrack(cur + 1);
            path.pop();
            visited[i] = false;
        }
    }

    nums.sort((a, b) => a - b);
    backtrack(0);
    return res;
};

function test() {
    console.log(permuteUnique([1, 1, 2]));
    console.log(permuteUnique([1, 2, 3]));
}

test();