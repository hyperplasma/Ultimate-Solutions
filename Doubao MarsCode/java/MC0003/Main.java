package MC0003;

/**
 * 3. 数字字符串格式化
 * 模拟
 */
public class Main {
    public static String solution(String s) {
        // 去除前导零
        s = s.replaceFirst("^0+(?!$)", "");

        // 分离整数和小数部分
        String[] parts = s.split("\\.");
        String integerPart = parts[0];
        String decimalPart = parts.length > 1 ? "." + parts[1] : "";

        // 格式化整数部分
        StringBuilder formattedInteger = new StringBuilder();
        int count = 0;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            formattedInteger.append(integerPart.charAt(i));
            count++;
            if (count % 3 == 0 && i != 0) {
                formattedInteger.append(",");
            }
        }
        formattedInteger.reverse();

        // 合并整数和小数部分
        return formattedInteger.toString() + decimalPart;
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution("1294512.12412").equals("1,294,512.12412"));
        System.out.println(solution("0000123456789.99").equals("123,456,789.99"));
        System.out.println(solution("987654321").equals("987,654,321"));
    }
}
