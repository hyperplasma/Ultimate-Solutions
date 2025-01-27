package LC0045_JumpGameII;

/**
 * <a href="https://leetcode.cn/problems/jump-game-ii/">Jump Game II</a>
 * 贪心；数组；动态规划
 */
public class JumpGameII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
    }
}

class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxPos = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }
}
