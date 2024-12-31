package LeetCode.LC3280_ConvertDateToBinary;

/**
 * <a href="https://leetcode.cn/problems/convert-date-to-binary/">Convert Date To Binary</a>
 * 数学；字符串
 */
public class ConvertDateToBinary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertDateToBinary("2025-02-32"));
    }
}

class Solution {
    public String convertDateToBinary(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(year));
        sb.append("-");
        sb.append(Integer.toBinaryString(month));
        sb.append("-");
        sb.append(Integer.toBinaryString(day));

        return sb.toString();
    }
}