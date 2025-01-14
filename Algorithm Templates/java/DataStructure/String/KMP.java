package DataStructure.String;

/**
 * KMP算法
 */
public class KMP {
    /**
     * KMP算法模式匹配
     */
    public static int kmp(String str, String pattern) {
        int n = str.length(), m = pattern.length();
        if (m == 0) {
            return 0;
        }

        int[] next = new int[m];
        // 求pattern串的next数组
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        // 字符串匹配
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "ababababca";
        String pattern = "ababca";
        System.out.println(kmp(str, pattern));
    }
}
