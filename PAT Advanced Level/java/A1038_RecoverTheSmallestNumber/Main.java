package A1038_RecoverTheSmallestNumber;

import java.util.*;

/**
 * 测试点6超时，其他随机超时
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(scanner.next());
        }

        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }

        int cnt = 0;
        while (cnt < sb.length() && sb.charAt(cnt) == '0') {
            cnt++;
        }
        if (cnt == sb.length()) {
            System.out.println("0");
        } else {
            for (; cnt < sb.length(); cnt++) {
                System.out.print(sb.charAt(cnt));//去除前面的0
            }
        }
    }
}



