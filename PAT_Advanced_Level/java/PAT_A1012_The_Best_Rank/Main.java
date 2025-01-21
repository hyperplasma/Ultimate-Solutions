package PAT_A1012_The_Best_Rank;

import java.io.*;

/**
 * 极易超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        int n, m;
        st.nextToken();
        n = (int) st.nval;
        st.nextToken();
        m = (int) st.nval;

        int[] id = new int[n];
        int[][] score = new int[n][4];
        int[][] pl = new int[4][101];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            id[i] = (int) st.nval;
            int avg = 0;
            for (int j = 0; j < 3; j++) {
                st.nextToken();
                score[i][j] = (int) st.nval;
                avg += score[i][j];
                pl[j][score[i][j]]++;
            }
            score[i][3] = (int) (Math.round((double) avg / 3));
            pl[3][score[i][3]]++;
        }

        int[][] rank = new int[n][4];
        for (int i = 0; i < 4; i++) {
            int[] sum = new int[101];
            sum[100] = 0;
            for (int j = 99; j >= 0; j--) {
                sum[j] = sum[j + 1] + pl[i][j + 1];
            }

            for (int j = n - 1; j >= 0; j--) {
                rank[j][i] = sum[score[j][i]] + 1;
            }

        }

        StringBuilder[] rankMap = new StringBuilder[1_000_000];
        for (int i = 0; i < n; i++) {
            int min = n + 1;
            for (int j = 0; j < 4; j++) {
                if (min > rank[i][j]) {
                    min = rank[i][j];
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(min).append(" ");
            if (rank[i][3] == min) {
                sb.append("A");
                rankMap[id[i]] = sb;
            } else if (rank[i][0] == min) {
                sb.append("C");
                rankMap[id[i]] = sb;
            } else if (rank[i][1] == min) {
                sb.append("M");
                rankMap[id[i]] = sb;
            } else if (rank[i][2] == min) {
                sb.append("E");
                rankMap[id[i]] = sb;
            }
        }

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int searchedId = (int) st.nval;
            if (rankMap[searchedId] == null) {
                sb.append("N/A");
            } else {
                sb.append(rankMap[searchedId]);
            }
            sb.append("\n");
        }
        pw.print(sb);
        pw.flush();
    }
}