/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
    if (nums.length === 0) {
        return -1;
    }
    if (nums.length === 1) {
        return nums[0] === target ? 0 : -1;
    }

    let l = 0;
    let r = nums.length - 1;
    while (l <= r) {
        let mid = Math.floor((l + r) / 2);
        if (nums[mid] === target) {
            return mid;
        }

        if (nums[l] <= nums[mid]) {
            if (nums[l] <= target && target < nums[mid]) { // left sorted
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } else {    // right sorted
            if (nums[mid] < target && target <= nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }

    return -1;
};

function test() {
    console.log(search([4, 5, 6, 7, 0, 1, 2], 0));
    console.log(search([4, 5, 6, 7, 0, 1, 2], 3));
}

test();