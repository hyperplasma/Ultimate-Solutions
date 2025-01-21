package LC3097_Shortest_Subarray_with_OR_at_Least_K_II;

/**
 * <a href="https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-ii/">Shortest Subarray With OR At Least K II</a>
 * 位运算；数组；滑动窗口
 */
public class ShortestSubarrayWithORAtLeastKII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2, 4, 3, 1}, 2));
    }
}

class Solution {
    /**
     * 思路：A | B >= A
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[30];
        int res = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < nums.length; r++) {
            for (int i = 0; i < 30; i++) {  // 将nums[r]的每一位加到bits中
                bits[i] += (nums[r] >> i) & 1;
            }
            while (l <= r && calc(bits) >= k) { // 当bits中每一位的和大于等于k时，尝试缩小窗口
                res = Math.min(res, r - l + 1);
                for (int i = 0; i < 30; i++) {  // 将nums[l]的每一位从bits中减去
                    bits[i] -= (nums[l] >> i) & 1;
                }
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int calc(int[] bits) {
        int ans = 0;
        for (int i = 0; i < bits.length; i++) { // 计算bits中每一位的和
            if (bits[i] > 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}