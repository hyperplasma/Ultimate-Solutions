package PAT_A1139_First_Contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 测试点5超时
 */
public class Main {
    static final int N = 10010;
    static List<Integer>[] g = new ArrayList[N];
    static boolean[] isGirl = new boolean[N];
    static int n, m, S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            String strA = st.nextToken();
            String strB = st.nextToken();

            if (strA.charAt(0) == '-') {
                strA = strA.substring(1);
                isGirl[Integer.parseInt(strA)] = true;
            }
            if (strB.charAt(0) == '-') {
                strB = strB.substring(1);
                isGirl[Integer.parseInt(strB)] = true;
            }

            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);
            g[a].add(b);
            g[b].add(a);
        }

        int Q = Integer.parseInt(reader.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(reader.readLine());
            S = Math.abs(Integer.parseInt(st.nextToken()));
            T = Math.abs(Integer.parseInt(st.nextToken()));

            List<Friend> res = new ArrayList<>();
            for (int i : g[S]) {
                if (isGirl[S] == isGirl[i] && i != T) { // 排除"S->T"一步到位的情况
                    for (int j : g[i]) {
                        if (isGirl[j] == isGirl[T] && j != S) { // 同上
                            for (int k : g[j]) {
                                if (k == T) {
                                    res.add(new Friend(i, j));
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(res.size());
            if (!res.isEmpty()) {
                Collections.sort(res);
                for (Friend it : res) {
                    System.out.printf("%04d %04d\n", it.a, it.b);
                }
            }
        }
    }
}

class Friend implements Comparable<Friend> {
    int a, b;

    Friend(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Friend t) {
        if (this.a != t.a) {
            return this.a - t.a;
        } else {
            return this.b - t.b;
        }
    }
}