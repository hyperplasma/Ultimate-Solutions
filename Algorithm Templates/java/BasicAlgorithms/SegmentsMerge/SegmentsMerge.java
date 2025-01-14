package BasicAlgorithms.SegmentsMerge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 区间合并
 */
public class SegmentsMerge {
    static List<int[]> segs = new ArrayList<>();    // 每个元素表示一段区间，int[0]表示左端点，int[1]表示右端点

    /**
     * 合并区间
     */
    public static List<int[]> merge() {
        List<int[]> res = new ArrayList<>();

        segs.sort(Comparator.comparingInt(a -> a[0])); // 按左端点大小排序

        int st = Integer.MIN_VALUE, ed = Integer.MIN_VALUE; // 当前维护区间（初始化为负无穷）
        for (int[] seg : segs) {
            if (ed < seg[0]) {    // 若与当前维护区间无交集
                if (st != Integer.MIN_VALUE) {
                    res.add(new int[]{st, ed});    // 当前区间结束维护并保存
                }
                st = seg[0];    // 转移至此区间
                ed = seg[1];
            } else {
                ed = Math.max(ed, seg[1]);    // 有交集则比较右端点
            }
        }

        if (st != Integer.MIN_VALUE) {
            res.add(new int[]{st, ed});    // 保存最后一个区间
        }
        return res;
    }

    public static void main(String[] args) {
        segs.add(new int[]{1, 3});
        segs.add(new int[]{2, 6});
        segs.add(new int[]{8, 10});
        segs.add(new int[]{15, 18});
        System.out.println(merge());
    }
}
