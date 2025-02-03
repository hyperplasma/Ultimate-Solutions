package LC0680_Valid_Palindrome_II;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome-ii/">Valid Palindrome II</a>
 * 贪心；双指针；字符串
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("aba"));
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("abc"));
    }
}

class Solution {
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return checkPalindrome(s, low, high - 1) || checkPalindrome(s, low + 1, high);
            }
        }
        return true;
    }

    private boolean checkPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
