package LC0541_Reverse_String_II;

/**
 * <a href="https://leetcode.cn/problems/reverse-string-ii/">Reverse String II</a>
 * 双指针；字符串
 */
public class ReverseStringII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("abcdefg", 2));
    }
}

class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            reverse(arr, i, Math.min(i + k, s.length()) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}