package LeetCode.LC3046_SplitTheArray;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/split-the-array/">Split the Array</a>
 * 数组；哈希表；计数
 */
public class SplitTheArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPossibleToSplit(new int[]{1, 1, 1, 1}));
    }
}

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > 2) {
                return false;
            }
        }
        return true;
    }
}