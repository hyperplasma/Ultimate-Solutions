package DataStructure.DisjointSet;

/**
 * 朴素并查集
 */
public class DisjointSet {
    static final int N = 100010;

    static int n;
    static int[] p = new int[N];    // p[1 ... n]，p[i]存储结点i的祖先（路径压缩后则为根结点）

    /**
     * 初始化
     */
    public static void init() {
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
    }

    /**
     * 并查集核心操作：返回结点x所属集合的根结点，并进行路径压缩
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
        p[find(a)] = find(b);   // 将a的根接在b的根之后
    }
}