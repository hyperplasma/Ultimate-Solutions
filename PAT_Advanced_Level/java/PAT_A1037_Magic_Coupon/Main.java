package PAT_A1037_Magic_Coupon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 测试点4超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        int n1 = Integer.parseInt(reader.readLine().trim());
        int[] num1 = new int[n1];
        String[] num1Str = reader.readLine().trim().split("\\s+");
        for (int i = 0; i < n1; i++) {
            num1[i] = Integer.parseInt(num1Str[i]);
        }

        int n2 = Integer.parseInt(reader.readLine().trim());
        int[] num2 = new int[n2];
        String[] num2Str = reader.readLine().trim().split("\\s+");
        for (int i = 0; i < n2; i++) {
            num2[i] = Integer.parseInt(num2Str[i]);
        }

        Arrays.sort(num1);
        Arrays.sort(num2);

        for (int i = 0; i < n1 && i < n2 && num1[i] < 0 && num2[i] < 0; i++) {
            sum += num1[i] * num2[i];
        }

        for (int i = n1 - 1, j = n2 - 1; i >= 0 && j >= 0 && num1[i] > 0 && num2[j] > 0; i--, j--) {
            sum += num1[i] * num2[j];
        }

        System.out.print(sum);
    }
}