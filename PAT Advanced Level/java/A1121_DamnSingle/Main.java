package A1121_DamnSingle;

import java.io.*;
import java.util.*;

/**
 * 测试点3、4超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 读取配偶对数量
        int n = Integer.parseInt(br.readLine());

        // 存储配偶对
        int[][] couples = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            couples[i][0] = Integer.parseInt(line[0]);
            couples[i][1] = Integer.parseInt(line[1]);
        }

        // 读取派对参与者数量和ID
        int m = Integer.parseInt(br.readLine());
        String[] guests = br.readLine().split(" ");
        Set<Integer> party = new HashSet<>();
        for (int i = 0; i < m; i++) {
            party.add(Integer.parseInt(guests[i]));
        }

        // 移除成对出现的配偶
        for (int[] couple : couples) {
            if (party.contains(couple[0]) && party.contains(couple[1])) {
                party.remove(couple[0]);
                party.remove(couple[1]);
            }
        }

        // 将剩余的单身人士排序
        Integer[] result = party.toArray(new Integer[0]);
        Arrays.sort(result);

        // 输出结果
        StringBuilder sb = new StringBuilder();
        sb.append(result.length).append('\n');

        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(String.format("%05d", result[i]));
        }
        System.out.print(sb);

        br.close();
    }
}
