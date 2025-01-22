package MC0048;

/**
 * 48. a替换函数
 */
public class Main {
    public static String solution(String s) {
        return s.replaceAll("a", "%100");
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdwa").equals("%100bcdw%100"));
        System.out.println(solution("banana").equals("b%100n%100n%100"));
        System.out.println(solution("apple").equals("%100pple"));
    }
}