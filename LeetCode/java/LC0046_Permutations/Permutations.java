package LC0046_Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/">Permutations</a>
 * 数组；回溯
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
        System.out.println(solution.permute(new int[]{0, 1}));
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        backtrack(0, nums.length, output, res);
        return res;
    }

    private void backtrack(int cur, int n, List<Integer> output, List<List<Integer>> res) {
        if (cur == n) {   // 所有数都填完了
            res.add(new ArrayList<>(output));
        }

        for (int i = cur; i < n; i++) {
            Collections.swap(output, cur, i); // 动态维护数组
            backtrack(cur + 1, n, output, res);   // 继续递归填下一个数
            Collections.swap(output, cur, i); // 撤销操作
        }
    }
}