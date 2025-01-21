package LC3019_Number_of_Changing_Keys;

/**
 * <a href="https://leetcode.cn/problems/number-of-changing-keys/">Number of Changing Keys</a>
 * 字符串
 */
public class NumberOfChangingKeys {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countKeyChanges("aAbBa"));
    }
}

class Solution {
    public int countKeyChanges(String s) {
        int cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(i - 1))) {
                cnt++;
            }
        }
        return cnt;
    }
}