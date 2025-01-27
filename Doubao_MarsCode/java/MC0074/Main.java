package MC0074;

public class Main {
    public static String solution(int[] plates, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (i + 1 < n && plates[i + 1] - plates[i] == 1) {
                i++;
            }
            if (i - j + 1 >= 3) {
                res.append(plates[j]).append("-").append(plates[i]).append(",");
            } else if (i - j + 1 == 2) {
                res.append(plates[j]).append(",").append(plates[j + 1]).append(",");
            } else {
                res.append(plates[j]).append(",");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public static void main(String[] args) {
        //  You can add more test cases here
        System.out.println(solution(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}, 10).equals("-3--1,2,10,15,16,18-20"));
        System.out.println(solution(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}, 20).equals("-6,-3-1,3-5,7-11,14,15,17-20"));
        System.out.println(solution(new int[]{1, 2, 7, 8, 9, 10, 11, 19}, 8).equals("1,2,7-11,19"));
    }
}