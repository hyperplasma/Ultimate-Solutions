package LC3270_Find_the_Key_of_the_Numbers;

/**
 * <a href="https://leetcode.cn/problems/find-the-key-of-the-numbers/">Find the Key of the Numbers</a>
 * 数学
 */
public class FindTheKeyOfTheNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateKey(123, 456, 789));
    }
}

class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int key = 0;
        for (int p = 1; num1 > 0 && num2 > 0 && num3 > 0; p *= 10) {
            key += Math.min(Math.min(num1 % 10, num2 % 10), num3 % 10) * p;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return key;
    }
}