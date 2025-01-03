package MC0008;

public class Main {
    public static int solution(int[] array) {
        int candidate = 0;
        int count = 0;

        // 第一步：找出可能的候选数字
        for (int num : array) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // 第二步：验证候选数字是否确实出现次数超过一半
        count = 0;
        for (int num : array) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > array.length / 2) {
            return candidate;
        } else {
            throw new IllegalArgumentException("No majority element found");
        }
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(new int[]{1, 3, 8, 2, 3, 1, 3, 3, 3}) == 3);
        System.out.println(solution(new int[]{5, 5, 5, 1, 2, 5, 5}) == 5);
        System.out.println(solution(new int[]{9, 9, 9, 9, 8, 9, 8, 8}) == 9);
    }
}