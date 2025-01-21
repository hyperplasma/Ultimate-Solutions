package PAT_A1047_Student_List_for_Course;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/**
 * 测试点3内存超限
 */
public class Main {
    static final int N = 40010;
    static final int M = 2510;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] name = new String[N];
        List<Integer>[] list = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<>();
        }

        // 读取学生姓名和其注册的课程
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            name[i] = s;

            for (int j = 0; j < num; j++) {
                int x = Integer.parseInt(st.nextToken());
                list[x].add(i);
            }
        }

        br.close();

        // 输出课程注册信息
        for (int i = 1; i <= k; ++i) {
            System.out.println(i + " " + list[i].size());

            // 按学生姓名的字典顺序排序
            list[i].sort(Comparator.comparing(a -> name[a]));

            for (int idx : list[i]) {
                System.out.println(name[idx]);
            }
        }
    }
}