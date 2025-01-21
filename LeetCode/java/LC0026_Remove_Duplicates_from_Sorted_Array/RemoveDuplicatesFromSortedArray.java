package LC0026_RemoveDuplicatesFromSortedArray;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">Remove Duplicates from Sorted Array</a>
 * 数组；双指针
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2}));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[cnt]) {
                nums[++cnt] = nums[i];
            }
        }
        return cnt + 1;
    }
}