package LC0047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations-ii/">Permutations II</a>
 * 数组；回溯；排序
 */
public class PermutationsII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(solution.permuteUnique(new int[]{1, 2, 3}));
    }
}

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);
        backtrack(0, nums, path, visited, res);
        return res;
    }

    private void backtrack(int cur, int[] nums, List<Integer> path, boolean[] visited, List<List<Integer>> res) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            backtrack(cur + 1, nums, path, visited, res);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}