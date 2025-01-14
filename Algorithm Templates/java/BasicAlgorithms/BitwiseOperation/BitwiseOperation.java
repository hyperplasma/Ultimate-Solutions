package BasicAlgorithms.BitwiseOperation;

/**
 * 位运算
 */
public class BitwiseOperation {
    /**
     * 返回x的最后一位1
     */
    public static int lowbit(int x) {
        return x & -x;  // -x = ~x + 1
    }

    /**
     * 输出整数x的二进制表示（31位）
     */
    public static void printInBinary(int x) {
        for (int i = 0; i < 31; i++) {
            System.out.print(x >> i & 1);
        }
    }

    /**
     * 统计x的二进制表示中有几位1
     */
    public static int countOnesInBinary(int x) {
        int cnt = 0;
        while (x != 0) {
            x -= lowbit(x);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(lowbit(5));  // 1
        printInBinary(5);  // 101
        System.out.println(countOnesInBinary(5));  // 2
    }
}