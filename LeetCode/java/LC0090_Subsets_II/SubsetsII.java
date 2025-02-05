package LC0090_Subsets_II;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/subsets-ii/">Subsets II</a>
 * 位运算；数组；回溯
 */
public class SubsetsII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(solution.subsetsWithDup(new int[]{0}));
    }
}

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(false, 0, nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(boolean choosePre, int cur, int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(false, cur + 1, nums, path, res);
        if (!choosePre && cur > 0 && nums[cur] == nums[cur - 1]) {
            return;
        }
        path.add(nums[cur]);
        dfs(true, cur + 1, nums, path, res);
        path.remove(path.size() - 1);
    }
}