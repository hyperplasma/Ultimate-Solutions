package PAT_A1019_General_Palindromic_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n, b;
    static List<Integer> nums = new ArrayList<>();

    public static boolean check() {
        for (int i = 0, j = nums.size() - 1; i < j; i++, j--) {
            if (!nums.get(i).equals(nums.get(j))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        if (n == 0) {
            nums.add(0);
        } else {
            while (n > 0) {
                nums.add(n % b);
                n /= b;
            }
        }

        if (check()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // 输出转换后的数字
        System.out.print(nums.get(nums.size() - 1));
        for (int i = nums.size() - 2; i >= 0; i--) {
            System.out.print(" " + nums.get(i));
        }
    }
}