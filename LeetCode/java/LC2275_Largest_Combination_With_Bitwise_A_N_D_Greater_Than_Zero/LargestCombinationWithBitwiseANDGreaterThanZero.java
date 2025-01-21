package LC2275_LargestCombinationWithBitwiseANDGreaterThanZero;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/largest-combination-with-bitwise-and-greater-than-zero/">Largest Combination With Bitwise AND Greater Than Zero</a>
 * 位运算；数组；哈希表；计数
 */
public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
    }
}

class Solution {
    public int largestCombination(int[] candidates) {
        int[] cnt = new int[24];
        for (int c : candidates) {
            for (int i = 0; c > 0; i++) {
                cnt[i] += c & 1;
                c >>= 1;
            }
        }
        return Arrays.stream(cnt).max().getAsInt();
    }
}