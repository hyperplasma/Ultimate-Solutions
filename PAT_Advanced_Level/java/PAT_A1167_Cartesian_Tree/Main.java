package PAT_A1167_Cartesian_Tree;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 50;
    static final int INF = 0x3f3f3f3f;

    static int n;
    static Map<Integer, Integer> l = new HashMap<>();
    static Map<Integer, Integer> r = new HashMap<>();
    static Map<Integer, Integer> pos = new HashMap<>();
    static Map<Integer, Boolean> hasL = new HashMap<>();
    static Map<Integer, Boolean> hasR = new HashMap<>();
    static int[] inorder = new int[N];

    static int findMin(int left, int right) {
        int min = INF;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, inorder[i]);
        }
        return min;
    }

    static void buildTree(int root, int inL, int inR) {
        if (inL > inR) return;

        int k = pos.get(root);

        int leftMin = findMin(inL, k - 1);
        if (leftMin != INF) {
            l.put(root, leftMin);
            hasL.put(root, true);
        }

        int rightMin = findMin(k + 1, inR);
        if (rightMin != INF) {
            r.put(root, rightMin);
            hasR.put(root, true);
        }

        if (hasL.getOrDefault(root, false)) {
            buildTree(l.get(root), inL, k - 1);
        }
        if (hasR.getOrDefault(root, false)) {
            buildTree(r.get(root), k + 1, inR);
        }
    }

    static void levelOrder(int root) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);

            if (hasL.getOrDefault(cur, false)) {
                queue.offer(l.get(cur));
            }
            if (hasR.getOrDefault(cur, false)) {
                queue.offer(r.get(cur));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(result.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());

        int root = INF;
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            pos.put(inorder[i], i);
            root = Math.min(root, inorder[i]);
        }

        buildTree(root, 0, n - 1);
        levelOrder(root);
    }
}