package MC0031;

import java.util.HashSet;
import java.util.Set;

/**
 * 31. 不同整数的计数问题
 * 哈希表；模拟
 */
public class Main {
    public static int solution(String word) {
        // 使用StringBuilder来构建新的字符串
        StringBuilder sb = new StringBuilder();

        // 遍历字符串中的每一个字符
        for (char c : word.toCharArray()) {
            // 如果字符是数字，则添加到StringBuilder中
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                // 如果不是数字，则添加一个空格
                sb.append(' ');
            }
        }

        // 将StringBuilder转换为字符串并按空格分割
        String[] numbers = sb.toString().split("\\s+");

        // 使用Set来存储不同的整数
        Set<String> uniqueNumbers = new HashSet<>();

        // 遍历分割后的字符串数组
        for (String num : numbers) {
            // 如果字符串不为空，则添加到Set中
            if (!num.isEmpty()) {
                // 去除前导零
                num = num.replaceFirst("^0+(?!$)", "");
                uniqueNumbers.add(num);
            }
        }

        // 返回Set的大小，即不同整数的数目
        return uniqueNumbers.size();
    }

    public static void main(String[] args) {
        System.out.println(solution("a123bc34d8ef34") == 3);
        System.out.println(solution("t1234c23456") == 2);
        System.out.println(solution("a1b01c001d4") == 2);
    }
}