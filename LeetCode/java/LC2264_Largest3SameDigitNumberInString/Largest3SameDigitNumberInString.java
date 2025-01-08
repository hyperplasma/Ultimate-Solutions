package LC2264_Largest3SameDigitNumberInString;

/**
 * <a href="https://leetcode.cn/problems/largest-3-same-digit-number-in-string/">Largest 3-Same-Digit Number in String</a>
 * 字符串
 */
public class Largest3SameDigitNumberInString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestGoodInteger("6777133339"));
    }
}

class Solution {
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String str = Integer.toString(i).repeat(3);
            if (num.contains(str)) {
                return str;
            }
        }
        return "";
    }
}