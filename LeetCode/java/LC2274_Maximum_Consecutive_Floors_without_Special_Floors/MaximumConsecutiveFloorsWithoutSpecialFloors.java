package LC2274_Maximum_Consecutive_Floors_without_Special_Floors;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors/">Maximum Consecutive Floors Without Special Floors</a>
 * 数组；排序
 */
public class MaximumConsecutiveFloorsWithoutSpecialFloors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxConsecutive(2, 9, new int[]{4, 6}));
    }
}

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res = Math.max(special[0] - bottom, top - special[special.length - 1]);
        for (int i = 1; i < special.length; i++) {
            res = Math.max(res, special[i] - special[i - 1] - 1);
        }
        return res;
    }
}