package MC0040;

/**
 * 40. 环状DNA序列的最小表示法
 */
public class Main {
    public static String solution(String dnaSeq) {
        String minSeq = dnaSeq;
        for (int i = 1; i < dnaSeq.length(); i++) {
            String curSeq = dnaSeq.substring(i) + dnaSeq.substring(0, i);
            if (curSeq.compareTo(minSeq) < 0) {
                minSeq = curSeq;
            }
        }
        return minSeq;
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution("ATCA").equals("AATC"));
        System.out.println(solution("CGAGTC").equals("AGTCCG"));
        System.out.println(solution("TCATGGAGTGCTCCTGGAGGCTGAGTCCATCTCCAGTAG").equals("AGGCTGAGTCCATCTCCAGTAGTCATGGAGTGCTCCTGG"));
    }
}