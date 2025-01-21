package LC2266_CountNumberOfTexts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/count-number-of-texts/">Count Number of Texts</a>
 * 哈希表；数学；字符串；动态规划
 */
public class CountNumberOfTexts {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countTexts("22233"));
    }
}

class Solution {
    public int countTexts(String pressedKeys) {
        int m = 1000000007;
        int n = pressedKeys.length();
        List<Long> dp3 = new ArrayList<>(Arrays.asList(1L, 1L, 2L, 4L));   // 连续按多次3个字母按键对应的方案数
        List<Long> dp4 = new ArrayList<>(Arrays.asList(1L, 1L, 2L, 4L));   // 连续按多次4个字母按键对应的方案数
        for (int i = 4; i <= n; ++i) {
            dp3.add((dp3.get(i - 1) + dp3.get(i - 2) + dp3.get(i - 3)) % m);
            dp4.add((dp4.get(i - 1) + dp4.get(i - 2) + dp4.get(i - 3) + dp4.get(i - 4)) % m);
        }
        long res = 1;   // 总方案数
        int cnt = 1;    // 当前字符连续出现的次数
        for (int i = 1; i < n; ++i) {
            if (pressedKeys.charAt(i) == pressedKeys.charAt(i - 1)) {
                ++cnt;
            } else {
                // 对按键对应字符数量讨论并更新总方案数
                if (pressedKeys.charAt(i - 1) == '7' || pressedKeys.charAt(i - 1) == '9') {
                    res = (res * dp4.get(cnt)) % m;
                } else {
                    res = (res * dp3.get(cnt)) % m;
                }
                cnt = 1;
            }
        }
        // 更新最后一段连续字符子串对应的方案数
        if (pressedKeys.charAt(n - 1) == '7' || pressedKeys.charAt(n - 1) == '9') {
            res = (res * dp4.get(cnt)) % m;
        } else {
            res = (res * dp3.get(cnt)) % m;
        }
        return (int) res;
    }
}