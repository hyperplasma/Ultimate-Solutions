package MC0007;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 7. 创意标题匹配问题
 */
public class Main {
    public static String solution(int n, String template_, String[] titles) {
        // 将模板中的通配符部分转换为正则表达式
        String regex = template_.replaceAll("\\{[^}]*\\}", ".*");

        // 遍历每个标题并进行匹配
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                result.append(",");
            }
            if (titles[i].matches(regex)) {
                result.append("True");
            } else {
                result.append("False");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // You can add more test cases here
        String[] testTitles1 = {"adcdcefdfeffe", "adcdcefdfeff", "dcdcefdfeffe", "adcdcfe"};
        String[] testTitles2 = {"CLSomGhcQNvFuzENTAMLCqxBdj", "CLSomNvFuXTASzENTAMLCqxBdj", "CLSomFuXTASzExBdj", "CLSoQNvFuMLCqxBdj", "SovFuXTASzENTAMLCq", "mGhcQNvFuXTASzENTAMLCqx"};
        String[] testTitles3 = {"abcdefg", "abefg", "efg"};

        System.out.println(solution(4, "ad{xyz}cdc{y}f{x}e", testTitles1).equals("True,False,False,True"));
        System.out.println(solution(6, "{xxx}h{cQ}N{vF}u{XTA}S{NTA}MLCq{yyy}", testTitles2).equals("False,False,False,False,False,True"));
        System.out.println(solution(3, "a{bdc}efg", testTitles3).equals("True,True,False"));
    }
}