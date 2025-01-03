package MC0026;

/**
 * 26. 小U的数字插入问题
 * 贪心
 */
public class Main {
    public static int solution(int a, int b) {
        // 将数字a转换为字符串
        String aStr = String.valueOf(a);
        // 将数字b转换为字符串
        String bStr = String.valueOf(b);

        // 初始化最大结果为插入到最前面的情况
        String maxResult = bStr + aStr;

        // 遍历所有可能的插入位置
        for (int i = 0; i <= aStr.length(); i++) {
            // 构造插入后的字符串
            String newStr = aStr.substring(0, i) + bStr + aStr.substring(i);
            // 比较并更新最大结果
            if (newStr.compareTo(maxResult) > 0) {
                maxResult = newStr;
            }
        }

        // 返回最大结果的整数形式
        return Integer.parseInt(maxResult);
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(76543, 4) == 765443);
        System.out.println(solution(1, 0) == 10);
        System.out.println(solution(44, 5) == 544);
        System.out.println(solution(666, 6) == 6666);
    }
}