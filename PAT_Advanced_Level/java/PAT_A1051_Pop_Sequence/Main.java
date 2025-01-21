package PAT_A1051_Pop_Sequence;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();  // 栈容量
        int n = scanner.nextInt();  // 数字数量
        int k = scanner.nextInt();  // 测试例数量

        while (k-- > 0) {
            Stack<Integer> stack = new Stack<>();
            int[] num = new int[n];
            for (int i = 0; i < n; ++i) {
                num[i] = scanner.nextInt();
            }

            int pos = 0;
            boolean flag = false;
            for (int i = 1; i <= n; ++i) {
                stack.push(i);
                if (stack.size() > m) {
                    flag = true;
                    break;
                }
                while (!stack.isEmpty() && num[pos] == stack.peek()) {
                    ++pos;
                    stack.pop();
                }
            }

            if (!flag && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}