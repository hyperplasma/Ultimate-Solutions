package MC0047;

/**
 * 47. 完美偶数计数
 */
public class Main {
    public static int solution(int n, int l, int r, int[] a) {
        int cnt = 0;
        for (int num : a) {
            if (num % 2 == 0 && num >= l && num <= r) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 3, 8, new int[]{1, 2, 6, 8, 7}) == 2);
        System.out.println(solution(4, 10, 20, new int[]{12, 15, 18, 9}) == 2);
        System.out.println(solution(3, 1, 10, new int[]{2, 4, 6}) == 3);
    }
}