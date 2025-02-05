package LC0078_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/">Subsets</a>
 * 位运算；数组；回溯
 */
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
        System.out.println(solution.subsets(new int[]{0}));
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int cur, int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[cur]);
        dfs(cur + 1, nums, path, res);
        path.remove(path.size() - 1);
        dfs(cur + 1, nums, path, res);
    }
}