/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function (nums1, nums2) {
    if (nums1.length > nums2.length) {
        return intersect(nums2, nums1);
    }

    let map = new Map();
    for (const num of nums1) {
        const cnt = map.get(num) || 0;
        map.set(num, cnt + 1);
    }

    let res = [];
    for (const num of nums2) {
        let cnt = map.get(num) || 0;
        if (cnt > 0) {
            res.push(num);
            cnt--;
            if (cnt > 0) {
                map.set(num, cnt);
            } else {
                map.delete(num);
            }
        }
    }
    return res;
};

function test() {
    console.log(intersect([1, 2, 2, 1], [2, 2]));
    console.log(intersect([4, 9, 5], [9, 4, 9, 8, 4]));
}

test();