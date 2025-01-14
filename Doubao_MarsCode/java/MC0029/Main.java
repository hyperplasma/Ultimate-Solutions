package MC0029;

/**
 * 29. 小D的‘abc‘变换问题
 * 模拟
 */
public class Main {
    public static String solution(String s, int k) {
        // 初始字符串
        String result = s;

        // 重复变换 k 次
        for (int i = 0; i < k; i++) {
            // 创建一个新的字符串来存储当前变换的结果
            StringBuilder newResult = new StringBuilder();

            // 遍历当前字符串的每个字符
            for (char c : result.toCharArray()) {
                // 根据字符进行变换
                if (c == 'a') {
                    newResult.append("bc");
                } else if (c == 'b') {
                    newResult.append("ca");
                } else if (c == 'c') {
                    newResult.append("ab");
                }
            }

            // 更新结果为当前变换后的字符串
            result = newResult.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc", 2).equals("caababbcbcca"));
        System.out.println(solution("abca", 3).equals("abbcbccabccacaabcaababbcabbcbcca"));
        System.out.println(solution("cba", 1).equals("abcabc"));
    }
}