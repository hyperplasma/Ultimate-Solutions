package DataStructure.DisjointSet;

/**
 * 维护集合大小的并查集
 */
public class DisjointSetWithSize {
    static final int N = 100010;

    static int n;
    static int[] p = new int[N];
    static int[] cnt = new int[N];  // cnt[i]存储根结点i的集合中结点数（仅根结点的cnt有意义）

    /**
     * 初始化
     */
    public static void init() {
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            cnt[i] = 1; // 初始化各结点为根，其所属集合大小为1
        }
    }

    /**
     * 并查集核心操作
     */
    public static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    /**
     * 合并结点a和b所在集合：将a并至b
     */
    public static void union(int a, int b) {
        if (find(a) == find(b)) return; // 若已在同一集合内则跳过

        cnt[find(b)] += cnt[find(a)];   // 需将a所属集合的大小加至b
        p[find(a)] = find(b);
    }
}
