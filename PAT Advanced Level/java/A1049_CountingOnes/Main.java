package A1049_CountingOnes;

import java.util.*;

public class Main {
    public static int calc(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }

        int res = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            int d = nums.get(i);
            int left = 0, right = 0, power = 1;
            for (int j = nums.size() - 1; j > i; j--) left = left * 10 + nums.get(j);
            for (int j = i - 1; j >= 0; j--) {
                right = right * 10 + nums.get(j);
                power *= 10;
            }

            if (d == 0) res += left * power;
            else if (d == 1) res += left * power + right + 1;
            else res += (left + 1) * power;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(calc(n));
        scanner.close();
    }
}