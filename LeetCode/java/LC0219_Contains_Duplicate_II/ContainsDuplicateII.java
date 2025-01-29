package LC0219_Contains_Duplicate_II;

import java.util.HashMap;

/**
 * 数组；哈希表；滑动窗口
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();    // nums[i] -> i
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}