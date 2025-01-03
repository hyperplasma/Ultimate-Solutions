import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(reader.readLine());
        String[] nums = reader.readLine().split(" ");

        for (String num : nums) {
            if (num.length() == 1) {
                System.out.println("Yes");
                continue;
            }
            boolean isLucky = true;
            String s = num.substring(0, 1);
            int i = 1;
            while (s.length() < num.length()) {
                s += num.charAt(i);
                int a = Integer.parseInt(s);
                if (a % s.length() != 0) {
                    isLucky = false;
                    break;
                }
                i++;
            }

            if (isLucky) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}