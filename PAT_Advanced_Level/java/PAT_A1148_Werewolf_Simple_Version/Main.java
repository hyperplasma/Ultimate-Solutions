package PAT_A1148_Werewolf_Simple_Version;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 110;
    static int n;
    static int[] statements;
    static Set<Integer> liars = new HashSet<>();

    static boolean check(int wolf1, int wolf2) {
        liars.clear();
        for (int i = 1; i <= n; i++) {
            int accusedPlayer = Math.abs(statements[i]);
            boolean saidWolf = statements[i] < 0;

            if (saidWolf) {
                if (accusedPlayer != wolf1 && accusedPlayer != wolf2) {
                    liars.add(i);
                }
            } else {
                if (accusedPlayer == wolf1 || accusedPlayer == wolf2) {
                    liars.add(i);
                }
            }
        }

        if (liars.size() != 2) return false;

        int lyingWolves = 0;
        for (int liar : liars) {
            if (liar == wolf1 || liar == wolf2) {
                lyingWolves++;
            }
        }
        return lyingWolves == 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        statements = new int[N];

        for (int i = 1; i <= n; i++) {
            statements[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (check(i, j)) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }

        System.out.println("No Solution");
    }
}