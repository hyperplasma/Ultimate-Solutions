package LC3095_ShortestSubarrayWithORAtLeastKI;

/**
 * 位运算；数组；滑动窗口
 */
public class ShortestSubarrayWithORAtLeastKI {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2, 4, 8, 16}, 15));
    }
}

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int cnt = Integer.MAX_VALUE;
        for (int l = 0; l < nums.length; l++) {
            int val = 0;
            for (int r = l; r < nums.length; r++) {
                val |= nums[r];
                if (val >= k) {
                    cnt = Math.min(cnt, r - l + 1);
                    break;
                }
            }
        }
        if (cnt == Integer.MAX_VALUE) {
            return -1;
        }
        return cnt;
    }
}