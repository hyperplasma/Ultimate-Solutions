package LC0350_Intersection_of_Two_Arrays_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii/">Intersection of Two Arrays II</a>
 * 数组；哈希表；双指针；二分查找；排序
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);
        }

        int[] res = new int[nums1.length];
        int len = 0;
        for (int num : nums2) {
            int cnt = map.getOrDefault(num, 0);
            if (cnt > 0) {
                res[len++] = num;
                cnt--;
                if (cnt > 0) {
                    map.put(num, cnt);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, len);
    }
}