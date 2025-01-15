package MC0034;

public class Main {
    public static int solution(int n, int[] nums) {
        int max1 = 0, max2 = 0, max3 = 0;
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num != max1) {
                max3 = max2;
                max2 = num;
            } else if (num > max3 && num != max2) {
                max3 = num;
            }
        }

        if (max3 == 0) {
            return max1;
        }
        return max3;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{3, 2, 1}) == 1);
        System.out.println(solution(2, new int[]{1, 2}) == 2);
        System.out.println(solution(4, new int[]{2, 2, 3, 1}) == 1);
    }
}