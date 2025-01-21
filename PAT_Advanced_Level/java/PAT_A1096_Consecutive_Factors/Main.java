package PAT_A1096_Consecutive_Factors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                List<Integer> seq = new ArrayList<>();
                for (int m = n, j = i; m % j == 0; j++) {
                    seq.add(j);
                    m /= j;
                }

                if (seq.size() > res.size()) {
                    res = seq;
                }
            }
        }

        if (res.isEmpty()) {
            res.add(n);
        }

        System.out.println(res.size());
        System.out.print(res.get(0));
        for (int i = 1; i < res.size(); i++) {
            System.out.print("*" + res.get(i));
        }
    }
}