package LC0081_Search_in_Rotated_Sorted_Array_II;

/**
 * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/">Search in Rotated Sorted Array II</a>
 * 数组；二分查找
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(s.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(s.search(new int[]{1, 1, 1, 1, 1, 1, 1}, 0));
        System.out.println(s.search(new int[]{1, 1, 1, 1, 1, 1, 1}, 1));
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}