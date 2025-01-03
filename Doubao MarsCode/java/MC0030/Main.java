package MC0030;

/**
 * 30. 组成字符串ku的最大次数
 * 哈希表
 */
public class Main {
    public static int solution(String s) {
        // 将字符串转换为小写以便统一处理
        s = s.toLowerCase();

        // 统计字符 'k' 和 'u' 的数量
        int countK = 0;
        int countU = 0;

        for (char c : s.toCharArray()) {
            if (c == 'k') {
                countK++;
            } else if (c == 'u') {
                countU++;
            }
        }

        // 返回 'k' 和 'u' 数量的最小值
        return Math.min(countK, countU);
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution("AUBTMKAxfuu") == 1); // true
        System.out.println(solution("KKuuUuUuKKKKkkkkKK") == 6); // true
        System.out.println(solution("abcdefgh") == 0); // true
    }
}