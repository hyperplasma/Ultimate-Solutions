package MC0072;

public class Main {
    public static String solution(int num, String data) {
        int[] rCnt = new int[num];  // > 0
        int[] lCnt = new int[num];  // < 0

        for (int i = 1; i < num; i++) {
            if ((data.charAt(i - 1) == 'R' && data.charAt(i) == '.') || (rCnt[i - 1] > 0 && data.charAt(i) == '.')) {
                rCnt[i] = rCnt[i - 1] + 1;
            }
        }
        for (int i = num - 2; i >= 0; i--) {
            if ((data.charAt(i + 1) == 'L' && data.charAt(i) == '.') || (lCnt[i + 1] < 0 && data.charAt(i) == '.')) {
                lCnt[i] = lCnt[i + 1] - 1;
            }
        }

        StringBuilder res = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < num; i++) {
            if (data.charAt(i) == '.' && rCnt[i] + lCnt[i] == 0) {
                if (!res.isEmpty()) {
                    res.append(',');
                }
                res.append(i + 1);
                sum++;
            }
        }

        if (sum == 0) {
            return "0";
        }
        return sum + ":" + res;
    }

    public static void main(String[] args) {
        //  You can add more test cases here
        System.out.println(solution(14, ".L.R...LR..L..").equals("4:3,6,13,14"));
        System.out.println(solution(5, "R....").equals("0"));
        System.out.println(solution(1, ".").equals("1:1"));
    }
}
