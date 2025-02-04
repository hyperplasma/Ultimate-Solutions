/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParityII = function (nums) {
    for (let i = 0, j = 1; i < nums.length; i += 2) {
        if (nums[i] % 2 !== 0) {
            while (nums[j] % 2 !== 0) {
                j += 2;
            }
            [nums[i], nums[j]] = [nums[j], nums[i]];
        }
    }
    return nums;
};

function test() {
    console.log(sortArrayByParityII([4, 2, 5, 7]));
    console.log(sortArrayByParityII([2, 3]));
}

test();