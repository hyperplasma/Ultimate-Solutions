/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function (nums) {
    let length = 0;
    let end = 0;
    let maxPos = 0;
    let steps = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        maxPos = Math.max(maxPos, i + nums[i]);
        if (i === end) {
            end = maxPos;
            steps++;
        }
    }
    return steps;
};

function test() {
    console.log(jump([2, 3, 1, 1, 4]));
}

test();