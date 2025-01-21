package LC3131_Find_the_Integer_Added_to_Array_I;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-the-integer-added-to-array-i/">Find The Integer Added To Array I</a>
 * 数组
 */
public class FindTheIntegerAddedToArrayI {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addedInteger(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}));
    }
}

class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
}