package DataStructure.Trie;

/**
 * 字典树
 */
public class Trie {
    static final int N = 100010;

    static int[][] son = new int[N][26];        // son[p][u]记录结点p的第u个子结点
    static int[] cnt = new int[N];      // cnt[p]存储以结点p结尾的单词数量
    static int idx = 0;     // idx初始为0（0号点既是根结点，又是空结点）

    /**
     * 插入一个字符串
     */
    public static void insert(String str) {
        int p = 0;    // 从根结点0起遍历Trie的指针
        for (int i = 0; i < str.length(); i++) {
            int u = str.charAt(i) - 'a';    // 将字符转换为对应的索引
            if (son[p][u] == 0) {
                son[p][u] = ++idx;    // 不存在则创建该子结点
            }
            p = son[p][u];    // 更新指针走向当前子结点
        }
        cnt[p]++;    // p最终指向字符串末尾字母，p计数器自增
    }

    /**
     * 查询字符串出现的次数
     */
    public static int query(String str) {
        int p = 0;    // 从根结点开始
        for (int i = 0; i < str.length(); i++) {
            int u = str.charAt(i) - 'a'; // 将字符转换为对应的索引
            if (son[p][u] == 0) {
                return 0;       // 不存在则直接返回0
            }
            p = son[p][u];    // 更新指针至下一个结点
        }
        return cnt[p];    // p最终指向字符串末尾字母，返回数量
    }
}
