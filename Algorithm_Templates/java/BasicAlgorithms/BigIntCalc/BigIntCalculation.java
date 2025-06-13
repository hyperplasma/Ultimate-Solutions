package BasicAlgorithms.BigIntCalc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 高精度计算（使用列表存储大数）
 */
public class BigIntCalculation {

    public static int BASE = 10;  // 进制

    /**
     * 高精度加法 C = A + B, A >= 0, B >= 0
     */
    public static ArrayList<Integer> add(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() < B.size()) {
            return add(B, A);
        }

        ArrayList<Integer> C = new ArrayList<>();
        int t = 0;  // 进位
        for (int i = 0; i < A.size(); i++) {
            t += A.get(i);
            if (i < B.size()) {
                t += B.get(i);
            }
            C.add(t % BASE);
            t /= BASE;
        }

        if (t > 0) {
            C.add(t); // 存入最后的进位
        }
        return C;
    }

    // 比较两个高精度整数的大小，返回A - B的符号
    public static int cmp(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() > B.size()) {
            return 1;   // 优先比较长度
        } else if (A.size() < B.size()) {
            return -1;
        }

        for (int i = A.size() - 1; i >= 0; i--)  // 从高位起逐位比较
            if (A.get(i) > B.get(i)) {
                return 1;
            } else if (A.get(i) < B.get(i)) {
                return -1;
            }

        return 0;
    }

    /**
     * 高精度减法 C = A - B, A >= B, A >= 0, B >= 0
     */
    public static ArrayList<Integer> sub(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> C = new ArrayList<>();
        int t = 0;  // 借位
        for (int i = 0; i < A.size(); i++) {
            t = A.get(i) - t;   // 成为本轮的被减数
            if (i < B.size()) {
                t -= B.get(i); // 先直接相减，t<0则说明需借位
            }
            C.add((t + BASE) % BASE);     // 若t<0，则存的是借位后的差；否则正常存差
            if (t < 0) { // 判断是否需借位
                t = 1;
            } else {
                t = 0;
            }
        }

        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);   // 去除前导0（结果为0则保留1位）
        }
        return C;
    }

    /**
     * 高精度乘法 C = A * b, A >= 0, b >= 0
     */
    public static ArrayList<Integer> mul(ArrayList<Integer> A, int b) {
        ArrayList<Integer> C = new ArrayList<>();
        int t = 0;  // 进位
        for (int i = 0; i < A.size() || t > 0; i++) {    // 自动处理最后剩余进位(i>=size但t>0)
            if (i < A.size()) {
                t += A.get(i) * b;
            }
            C.add(t % BASE);
            t /= BASE;
        }

        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);   // b为0时，需去除前导0
        }
        return C;
    }

    /**
     * 高精度除法 A / b = C ... r, A >= 0, b > 0
     */
    public static ArrayList<Integer> div(ArrayList<Integer> A, int b, int[] r) {
        ArrayList<Integer> C = new ArrayList<>();
        r[0] = 0;  // 余数
        for (int i = A.size() - 1; i >= 0; i--) {    // 从最高位开始除
            r[0] = r[0] * BASE + A.get(i);
            C.add(r[0] / b); // 暂时将高位存于低位
            r[0] %= b;
        }

        Collections.reverse(C);    // 逆转后即为正常存储形式
        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        return C;
    }

    // 将以列表存储的大数格式化为字符串
    private static String printf(ArrayList<Integer> num) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.size() - 1; i >= 0; i--) {
            sb.append(num.get(i));
        }
        return sb.toString();
    }
}
