package DataStructure.DisjointSet;

/**
 * 维护到祖宗结点距离的并查集
 */
public class DisjointSetWithDistance {
    static final int N = 100010;

    static int n;
    static int[] p = new int[N];
    static int[] d = new int[N];    // d[i]存储结点i到其根结点p[i]的距离

    /**
     * 初始化
     */
    public static void init() {
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            d[i] = 0;   // 初始化全为0
        }
    }

    /**
     * 并查集核心操作
     */
    public static int find(int x) {
        if (p[x] != x) {
            int u = find(p[x]);    // u临时记录根结点
            d[x] += d[p[x]];    // 更新x到根p[x]的路径长度
            p[x] = u;
        }
        return p[x];
    }

    /**
     * 合并结点a和b所在集合：将a并至b
     */
    public static void union(int a, int b) {
        p[find(a)] = find(b);
    }

    /**
     * 根据具体问题，初始化根find(a)的偏移量
     */
    public static void setDistance(int a, int distance) {
        d[find(a)] = distance;
    }
}